package com.kodilla.ecommercee.dto;


public class GroupDto {
    private final long id;
    private final String name;

    public GroupDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}