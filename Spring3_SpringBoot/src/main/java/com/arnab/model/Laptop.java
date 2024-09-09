package com.arnab.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer {
    public Laptop() {
        System.out.println("Third Laptop");
    }

    public void compile(){
        System.out.println("Compiling in Laptop...");
    }
}
