package com.arnab.question_service.service;


import com.arnab.question_service.model.Question;
import com.arnab.question_service.model.QuestionWrapper;
import com.arnab.question_service.model.UserResponse;
import com.arnab.question_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo repo;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            repo.save(question);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> generateQuiz(String category, int numQ) {
        try{
            List<Integer> questions= repo.findRandomQuestionByCategory(category,numQ);
            return new ResponseEntity<>(questions,HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        try{
            List<QuestionWrapper> questions=new ArrayList<>();
            for(int id:questionIds) {
                Question q = repo.findById(id).get();
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questions.add(qw);
            }
            return new ResponseEntity<>(questions,HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> getScore(List<UserResponse> response) {
        try {
            int score = 0;
            for (UserResponse ur : response) {
                Question q=repo.findById(ur.getId()).get();
                if (ur.getResponse().equals(q.getCorrect())) score++;
            }
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(-1,HttpStatus.BAD_REQUEST);
    }
}
