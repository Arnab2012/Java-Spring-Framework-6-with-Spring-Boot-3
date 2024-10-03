package com.arnab.quizapp.controller;

import com.arnab.quizapp.model.QuestionWrapper;
import com.arnab.quizapp.model.UserResponse;
import com.arnab.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return service.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{title}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable String title){
        return service.getQuiz(title);
    }

    @PostMapping("submit/{title}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable String title, @RequestBody List<UserResponse> response){
        return service.submitQuiz(title,response);
    }
}
