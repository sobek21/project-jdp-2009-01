package com.kodilla.ecommercee.dto;

public class UserDto {
    private long userId;
    private String username;
    private String firstname;
    private String lastname;

    public UserDto(final long userId, final String username, final String firstname, final String lastname) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}