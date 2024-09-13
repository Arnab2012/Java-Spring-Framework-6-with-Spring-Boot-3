package com.arnab.courseapp.repo;

import com.arnab.courseapp.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepo {
    List<Course> courseList = new ArrayList<>(Arrays.asList(
            new Course(1, "Java Full Stack", Arrays.asList("Java", "Spring", "Hibernate"), "Dhrupad Chakraborty", 40),
            new Course(2, "Python Data Science", Arrays.asList("Python", "Pandas", "NumPy", "Scikit-Learn"), "Avik Sarkar", 60),
            new Course(3, "Web Development", Arrays.asList("HTML", "CSS", "JavaScript", "React"), "Souradeep Dey", 50),
            new Course(4, "DevOps", Arrays.asList("Docker", "Kubernetes", "Jenkins", "AWS"), "Dhrupad Chakroborty", 45),
            new Course(5, "Cybersecurity Fundamentals", Arrays.asList("Network Security", "Cryptography", "Firewalls"), "Ratul Biswas", 35)
    ));

    public List<Course> viewAll() {
        return courseList;
    }

    public void add(Course course) {
        courseList.add(course);
        System.out.println(courseList);
    }
}
