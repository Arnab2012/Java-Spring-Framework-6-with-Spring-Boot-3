package com.arnab.spring3_springboot.repo;

import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public LaptopRepository() {
        System.out.println("Second Laptop Repository");
    }

    public void save(){
        System.out.println("Laptop saved Successfully...");
    }
}
