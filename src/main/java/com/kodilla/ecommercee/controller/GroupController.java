package com.kodilla.ecommercee.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/v1")
public class GroupController {

    @GetMapping(value = "group")
    public List<Object> getListOfAllGroups() {
        return new ArrayList();
    }

    @GetMapping(value = "group")
    public Object getGroupById(@RequestParam(value = "groupId") @NotNull Long groupId) {
        return new Object();
    }

    @PostMapping(value = "group")
    public void addNewGroup(@RequestBody Object object) {
    }

    @PutMapping(value = "group")
    public Object updateGroup(@RequestBody Object object) {
        return object;
    }


}