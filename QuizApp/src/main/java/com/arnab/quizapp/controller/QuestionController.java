package com.arnab.quizapp.controller;

import com.arnab.quizapp.model.Question;
import com.arnab.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question") // common mapping for all request
public class QuestionController {

    @Autowired
    QuestionService service;

//  to get all questions from database
    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return service.getAllQuestions();
    }

//  to get questions for a Particular category from database
    @GetMapping("getquestion/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return service.getQuestionByCategory(category);
    }

//  to add question in the database
    @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }
}