package com.kodilla.ecommercee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(allowSetters = true,value = "password")
public class UserDto {
    private String username;
    private String password;
    private boolean isEnabled;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto() {
        super();
    }

    public UserDto(String username, boolean isEnabled) {
        this.username = username;
        this.isEnabled = isEnabled;
    }
}