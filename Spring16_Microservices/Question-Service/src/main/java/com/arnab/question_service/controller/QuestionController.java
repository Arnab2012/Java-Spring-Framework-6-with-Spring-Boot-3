package com.arnab.question_service.controller;


import com.arnab.question_service.model.Question;
import com.arnab.question_service.model.QuestionWrapper;
import com.arnab.question_service.model.UserResponse;
import com.arnab.question_service.service.QuestionService;
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

//  to generate a quiz with random question (for a particular category)
    @PostMapping("generate")
    public ResponseEntity<List<Integer>> generateQuiz(@RequestParam String category,@RequestParam int numQ){
        return service.generateQuiz(category,numQ);
    }

//  to get Questions from questionIds
    @PostMapping("getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds){
        return service.getQuestionsFromId(questionIds);
    }

//  to calculate score
    @PostMapping("getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<UserResponse> response){
        return service.getScore(response);
    }
}