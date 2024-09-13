package com.arnab.courseapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data // for creating Getter Setters
@NoArgsConstructor // for creating no Argument Constructor
@AllArgsConstructor // for creating All Arguments Constructor
public class Course {
    private int courseId;
    private String courseName;
    private List<String> techStack;
    private String teacherName;
    private int duration;

}
