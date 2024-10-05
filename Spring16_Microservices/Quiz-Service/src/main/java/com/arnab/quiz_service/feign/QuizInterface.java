package com.arnab.quiz_service.feign;

import com.arnab.quiz_service.model.QuestionWrapper;
import com.arnab.quiz_service.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    //  to generate a quiz with random question (for a particular category)
    @PostMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuiz(@RequestParam String category, @RequestParam int numQ);

    //  to get Questions from questionIds
    @PostMapping("question/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds);

    //  to calculate score
    @PostMapping("question/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<UserResponse> response);
}
