package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapUserDtoToUser(UserDto userDto) {
        return new User(
                userDto.getUsername(),
                userDto.getPassword()
                );
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getUsername(),
                user.isEnable()
        );
    }
}
