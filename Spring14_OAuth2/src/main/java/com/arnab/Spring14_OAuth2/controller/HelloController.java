package com.arnab.Spring14_OAuth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greet(){
        return "Hello there is OAuth2";
    }
}
