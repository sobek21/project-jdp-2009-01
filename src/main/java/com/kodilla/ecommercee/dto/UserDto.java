package com.kodilla.ecommercee.dto;

public class UserDto {
    private long userId;
    private long userKey;
    private String username;
    private String password;

    public UserDto(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public long getUserKey() {
        return userKey;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}