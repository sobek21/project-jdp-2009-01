package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.user.KeyException;
import com.kodilla.ecommercee.exception.user.UserConflictException;
import com.kodilla.ecommercee.exception.user.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserDbService {

    @Autowired
    private UserDao userDao;

    public void addNewUser(User user) throws UserConflictException {
        if (!userDao.existsById(user.getUserId()) && !userDao.existsByUsername(user.getUsername())) {
            userDao.save(user);
            log.info("Zapisano użytkownika " + user.getUsername() + ", o numerze ID " + user.getUserId());
        } else {
            throw new UserConflictException("Użytkownik już istnieje");
        }
    }

    public List<User> blockUsers() {

        List<User> blockUsersList = getAllActiveUsers();

        for (User user: blockUsersList) {
            if (user.getUserKeyValidity().equals(Instant.now())) {
                user.setEnable(false);
                user.setUserKey(null);
                updateUser(user);
            }
        }
        return blockUsersList;
                
    }

    public String createKeyForUser(String username, String password) throws UserNotFoundException, KeyException {
        User user = findUserByUsernameAndPassword(username, password)
                .orElseThrow(() -> new UserNotFoundException("Użytkownik nie istnieje lub podano błędne dane"));
        if (user.getUserKey() == null) {
            String key = generateKey(user);
            return key;
        } else {
            throw new KeyException("Uzytkownik posiada ważny klucz");
        }
    }

    private List<User> getAllActiveUsers() {
        return userDao.findAll().stream()
                .filter(user -> user.isEnable() == true)
                .collect(Collectors.toList());
    }

    private String generateKey(User user) {
        String key = RandomString.make(10);
        user.setUserKey(key);
        user.setUserKeyValidity(Instant.now().plus(1, ChronoUnit.HOURS));
        updateUser(user);
        String message = "Wytworzono klucz dla użytkownika " + user.getUsername() + ": " + key + "\n ważny do: " + user.getUserKeyValidity();
        log.info(message);
        return message;
    }

    private Optional<User> findById(long userId) {
        return userDao.findById(userId);
    }

    private void updateUser(User user) {
        userDao.save(user);
        log.info("Uaktualniono użytkownika: " + user.getUsername() + ", o numerze Id: " + user.getUserId());
    }

    private Optional<User> findUserByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
