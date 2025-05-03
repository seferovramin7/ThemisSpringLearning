package com.assignment.themisspringlearning.controller;


import com.assignment.themisspringlearning.model.UserEntity;
import com.assignment.themisspringlearning.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserEntity getUserService(@RequestParam String name) {
        System.out.println(name);
        return userService.saveUser(name);
    }
}
