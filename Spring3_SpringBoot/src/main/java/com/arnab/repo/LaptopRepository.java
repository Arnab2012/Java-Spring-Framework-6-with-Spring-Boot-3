package com.arnab.repo;

import com.arnab.model.Laptop;
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
