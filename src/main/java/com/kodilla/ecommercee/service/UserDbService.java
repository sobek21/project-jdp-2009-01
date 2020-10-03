package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exeption.UserConflictExeption;
import com.kodilla.ecommercee.exeption.UserNotFoundExeption;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserDbService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    public void addNewUser(String username,String password) throws UserConflictExeption {
        if (!userDao.findByUsername(username).isPresent()) {
            userDao.save(userMapper.mapUserDtoToUser(username,password));
        } else {
            throw new UserConflictExeption("Użytkownik już istnieje");
        }
    }

    public UserDto blockUser(long userId) throws UserNotFoundExeption {
        Optional<User> user = userDao.findById(userId);
        if (user.isPresent()) {
            User userToBlock = user.get();
            userToBlock.setEnable(false);
            userDao.save(userToBlock);
            return userMapper.mapUserToUserDto(userToBlock);
        } else {
            throw new UserNotFoundExeption("Użytkownik nie istnieje");
        }
    }

    public void createKeyForUser(String username, String password) throws UserNotFoundExeption {
        Optional<User> optionalUser = userDao.findByUsernameAndPassword(username, password);
        if (optionalUser.isPresent()) {
            optionalUser.get().setUserKey(generateKey());
        } else throw new UserNotFoundExeption("Użytkownik nie istnieje lub podano błędne dane");
    }

    private long generateKey() {
        Random random = new Random();
        return random.nextLong();
    }
}
