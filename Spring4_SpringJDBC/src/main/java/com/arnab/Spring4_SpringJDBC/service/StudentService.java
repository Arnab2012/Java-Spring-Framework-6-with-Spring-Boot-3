package com.arnab.Spring4_SpringJDBC.service;

import com.arnab.Spring4_SpringJDBC.model.Student;
import com.arnab.Spring4_SpringJDBC.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repo;

    public StudentRepository getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
        System.out.println("Student Added");
        repo.save(s);
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }
}
