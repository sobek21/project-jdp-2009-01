package com.kodilla.ecommercee.dto;


public class GroupDto {
    private final long groupId;
    private final String name;

    public GroupDto(long groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public long getId() {
        return groupId;
    }

    public String getName() {
        return name;
    }
}