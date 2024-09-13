package com.arnab.spring3_springboot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Programmer {
    @Value("21") // setting value
    private int age;
    private Computer com;

    public Computer getCom() {
        return com;
    }
    @Autowired
//    @Qualifier("desktop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void code(){
        com.compile();
    }
}
