package com.arnab.quiz_service.controller;

import com.arnab.quiz_service.model.QuestionWrapper;
import com.arnab.quiz_service.model.QuizDTO;
import com.arnab.quiz_service.model.UserResponse;
import com.arnab.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz") // common mapping for all request
public class QuizController {

    @Autowired
    QuizService service;

//  to create a quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO dto){
        return service.createQuiz(dto.getCategory(),dto.getNumQ(), dto.getTitle());
    }

//  get the quiz questions
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return service.getQuiz(id);
    }

//  submit a quiz and get score
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<UserResponse> response){
        return service.submitQuiz(id,response);
    }
}