package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapUserDtoToUser(UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getUserKey(),
                userDto.getPassword(),
                userDto.getUsername(),
                userDto.getCart(),
                userDto.getOrders(),
                userDto.isEnable()
        );
    }

    public User mapUserDtoToUser(String username, String password) {
        return new User(username, password);
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserKey(),
                user.getPassword(),
                user.getUsername(),
                user.getCart(),
                user.getOrders(),
                user.isEnable(),
                user.getTimeOfCreateKey()
        );
    }
}
