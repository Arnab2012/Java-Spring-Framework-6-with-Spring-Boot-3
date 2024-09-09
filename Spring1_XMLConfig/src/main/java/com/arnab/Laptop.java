package com.arnab;

public class Laptop implements Computer {
    Laptop(){
        System.out.println("Laptop object created");
    }
    public void compile(){
        System.out.println("Compiling in Laptop...");
    }
}
