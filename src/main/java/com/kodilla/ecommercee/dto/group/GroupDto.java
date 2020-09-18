package com.kodilla.ecommercee.dto.group;


public class GroupDto {
    private long id;
    private String name;

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
