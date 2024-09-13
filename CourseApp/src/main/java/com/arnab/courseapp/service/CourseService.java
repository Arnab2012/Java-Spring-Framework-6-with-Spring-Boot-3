package com.arnab.courseapp.service;

import com.arnab.courseapp.model.Course;
import com.arnab.courseapp.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired // service will connect with Repo
    private CourseRepo repo;

    public void add(Course course){
        repo.add(course);
    }
    public List<Course> viewAll(){
        return repo.viewAll();
    }
}
