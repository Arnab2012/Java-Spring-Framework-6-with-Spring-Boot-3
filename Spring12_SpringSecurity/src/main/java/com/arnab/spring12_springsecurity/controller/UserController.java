package com.arnab.spring12_springsecurity.controller;

import com.arnab.spring12_springsecurity.model.Users;
import com.arnab.spring12_springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("register")
    public void addUser(@RequestBody Users user){
        service.addUser(user);
    }
}
