//package com.kodilla.ecommercee.controller;
//
//import com.kodilla.ecommercee.dto.GroupDto;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/v1")
//public class GroupController {
//
//    @GetMapping(value = "getAllGroups")
//    public List<GroupDto> getListOfAllGroups() {
//        List<GroupDto> list = new ArrayList<>();
//        list.add(new GroupDto(1, "test group"));
//        return list;
//    }
//
//    @GetMapping(value = "getGroupById")
//    public GroupDto getGroupById(@RequestParam(value = "groupId") @NotNull Long groupId) {
//        return new GroupDto(groupId, "test group");
//    }
//
//    @PostMapping(value = "addNewGroup")
//    public void addNewGroup(@RequestBody GroupDto groupDto) {
//    }
//
//    @PutMapping(value = "updateGroup")
//    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
//        return groupDto;
//    }
//}
