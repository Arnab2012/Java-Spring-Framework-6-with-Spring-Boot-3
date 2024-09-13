package com.arnab.spring2_javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int age;
    //    private Laptop lap;
//    private Desktop1 dek;
    @Autowired
    private Computer com;

    public int getAge() {
        return age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Alien(Computer com, int age) {
        System.out.println("Parameterized Constructor Called");
        this.com = com;
        this.age = age;
    }

    //    constructor
    public Alien(){
        System.out.println("Alien Object Created");
    }

    public void code(){
        com.compile();
        System.out.println("Coding...");
    }
}