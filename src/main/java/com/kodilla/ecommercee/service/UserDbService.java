package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.KeyException;
import com.kodilla.ecommercee.exception.UserConflictException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Slf4j
@Service
public class UserDbService {

    @Autowired
    private UserDao userDao;

    public void addNewUser(User user) throws UserConflictException {
        if (!userDao.findByUsername(user.getUsername()).isPresent()) {
            user.setEnable(true);
            saveUser(user);
            log.info("Zapisano użytkownika " + user.getUsername());
        } else {
            throw new UserConflictException("Użytkownik już istnieje");
        }
    }

    public User blockUser(long userId) throws UserNotFoundException {
        Optional<User> user = userDao.findById(userId);
        if (user.isPresent()) {
            User userToBlock = user.get();
            userToBlock.setEnable(false);
            saveUser(userToBlock);
            log.info("Użytkownik " + userToBlock.getUsername() + " został zablokowany");
            return userToBlock;
        } else {
            throw new UserNotFoundException("Użytkownik nie istnieje");
        }
    }

    public String createKeyForUser(String username, String password) throws UserNotFoundException,KeyException {
        Optional<User> optionalUser = userDao.findByUsernameAndPassword(username, password);
        User user = optionalUser.orElseThrow(() -> new UserNotFoundException("Użytkownik nie istnieje lub podano błędne dane"));
        if (user.getUserKey()==null) {
            return generateKey(user);
        }
        else {
            throw new KeyException("Uzytkownik posiada ważny klucz");
        }
    }

    private String generateKey(User user) {
        String key = RandomString.make(10);
        user.setUserKey(key);
        saveUser(user);
        log.info("Wytworzono klucz dla użytkownika " + user.getUsername());
        Thread thread = new Thread(() ->
        {
            try {
                Thread.sleep(Duration.ofHours(1).toMillis());
                removeKey(user);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return key;
    }

    private void removeKey(User user) {
        user.setUserKey(null);
        saveUser(user);
        log.info("Klucz użytkownika " + user.getUsername() + " wygasł");
    }

    private void saveUser(User user){
        userDao.save(user);
    }
}
