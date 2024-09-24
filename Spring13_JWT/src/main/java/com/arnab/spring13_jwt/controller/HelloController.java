package com.arnab.spring13_jwt.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greet(HttpServletRequest request){
        return "Hello Security "+request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "About Spring Security "+request.getSession().getId();
    }

}
