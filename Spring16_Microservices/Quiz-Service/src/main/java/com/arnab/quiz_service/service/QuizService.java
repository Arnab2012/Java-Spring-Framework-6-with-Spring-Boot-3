package com.arnab.quiz_service.service;

import com.arnab.quiz_service.feign.QuizInterface;
import com.arnab.quiz_service.model.QuestionWrapper;
import com.arnab.quiz_service.model.Quiz;
import com.arnab.quiz_service.model.UserResponse;
import com.arnab.quiz_service.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizrepo;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try{
            List<Integer> questions= quizInterface.generateQuiz(category,numQ).getBody();
            Quiz quiz=new Quiz();
            quiz.setTitle(title);
            quiz.setQuestionIds(questions);
            quizrepo.save(quiz);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        try{
            Quiz quiz=quizrepo.findById(id).get();
            List<Integer> questionIds=quiz.getQuestionIds();
            List<QuestionWrapper> qw=quizInterface.getQuestionsFromId(questionIds).getBody();
            return new ResponseEntity<>(qw,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<UserResponse> response) {
        try {
            int score=quizInterface.getScore(response).getBody();
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(-1,HttpStatus.BAD_REQUEST);
    }
}
