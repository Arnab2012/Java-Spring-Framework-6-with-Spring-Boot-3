package com.arnab.spring2_javaconfig;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    public Desktop() {
        System.out.println("Desktop Object Created");
    }

    public void compile(){
        System.out.println("Compiling in desktop...");
    }
}
