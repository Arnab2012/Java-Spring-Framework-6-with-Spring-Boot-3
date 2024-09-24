package com.arnab.spring13_jwt.service;

import com.arnab.spring12_springsecurity.model.Users;
import com.arnab.spring12_springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
//    creating BCryptEncoder
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
    public void addUser(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        repo.save(user);
    }
}
