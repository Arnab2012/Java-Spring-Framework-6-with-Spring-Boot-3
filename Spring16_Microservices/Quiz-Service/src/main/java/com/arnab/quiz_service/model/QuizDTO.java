package com.arnab.quiz_service.model;

import lombok.Data;

@Data
public class QuizDTO {
    private String category;
    private int numQ;
    private String title;
}
