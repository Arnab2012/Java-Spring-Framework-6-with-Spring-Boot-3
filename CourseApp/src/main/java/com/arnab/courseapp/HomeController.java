package com.arnab.courseapp;

import com.arnab.courseapp.model.Course;
import com.arnab.courseapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired // Controller will connect to service
    private CourseService service;

    @GetMapping({"/","home"})
    public String home(){
        return "course";
    }

    @GetMapping("addcourse")
    public String add(){
        return "AddCourse";
    }

//    Here course is DTO(Data Transfer Object) as it is transferred between Controller,Service and Repo
    @PostMapping("success")
    public String success(Course course){
        service.add(course);
        return "Success";
    }

    @GetMapping("viewallcourses")
    public String view(Model m){
        List<Course> course=service.viewAll();
        m.addAttribute("courses",course);
        return "ViewAllCourses";
    }
}
