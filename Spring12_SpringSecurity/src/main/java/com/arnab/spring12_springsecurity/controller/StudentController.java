package com.arnab.spring12_springsecurity.controller;

import com.arnab.spring12_springsecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(
            Arrays.asList(
            new Student(1,"Arnab",70),
            new Student(2,"Ayan",80)
            )
    );

    @GetMapping("getCsrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("add")
    public void add(@RequestBody Student student){
        students.add(student);
    }
}
