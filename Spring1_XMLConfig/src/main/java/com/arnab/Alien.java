package com.arnab;

public class Alien {

    private int age;
//    private Laptop lap;
//    private Desktop1 dek;
    private Computer com;

    public int getAge() {
        return age;
    }

//    public Laptop getLap() {
//        return lap;
//    }

//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }
    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public Alien(Computer com, int age) {
        System.out.println("Parameterized Constructor Called");
        this.com = com;
        this.age = age;
    }

    //    constructor
    Alien(){
        System.out.println("Alien Object Created");
    }

    public void code(){
        com.compile();
        System.out.println("Coding...");
    }
}
