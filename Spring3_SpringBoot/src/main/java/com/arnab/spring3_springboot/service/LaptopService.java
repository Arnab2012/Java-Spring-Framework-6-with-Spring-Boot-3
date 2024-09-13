package com.arnab.spring3_springboot.service;

import com.arnab.spring3_springboot.repo.LaptopRepository;
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
