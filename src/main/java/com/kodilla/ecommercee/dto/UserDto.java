package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    private long userId;
    private long userKey;
    private String username;
    private String password;
    private Cart cart;
    private List<Order> orders;
    private boolean isEnable=true;
    private LocalDateTime timeOfKeyCreated;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getUserKey()  {
        if (timeOfKeyCreated == null || timeOfKeyCreated.minusHours(1).isAfter(LocalDateTime.now())) {
            return userKey;
        } else {
            return Long.valueOf(null);
        }
    }
}