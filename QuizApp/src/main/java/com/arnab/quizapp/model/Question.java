package com.arnab.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct;
    private String category;
    private String difficulty;
}
