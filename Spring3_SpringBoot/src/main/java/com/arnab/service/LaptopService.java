package com.arnab.service;

import com.arnab.model.Laptop;
import com.arnab.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    public LaptopService() {
        System.out.println("First Laptop Service");
    }

    @Autowired
    private LaptopRepository repo;
    public void addLaptop() {
        System.out.println("Laptop Added Successfully");
        repo.save();
    }

}
