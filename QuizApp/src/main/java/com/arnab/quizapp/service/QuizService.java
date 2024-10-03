package com.arnab.quizapp.service;

import com.arnab.quizapp.model.Question;
import com.arnab.quizapp.model.QuestionWrapper;
import com.arnab.quizapp.model.Quiz;
import com.arnab.quizapp.model.UserResponse;
import com.arnab.quizapp.repo.QuestionRepo;
import com.arnab.quizapp.repo.QuizRepo;
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
    QuestionRepo questionrepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try{
            List<Question> questions= questionrepo.findRandomQuestionByCategory(category,numQ);
            Quiz quiz=new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizrepo.save(quiz);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(String title) {
        try{
            Quiz quiz=quizrepo.findByTitle(title);
            List<Question> questions=quiz.getQuestions();
            List<QuestionWrapper> quizWrapper=new ArrayList<>();
            for(Question q:questions){
                QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
                quizWrapper.add(qw);
            }
            return new ResponseEntity<>(quizWrapper,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> submitQuiz(String title, List<UserResponse> response) {
        try {
            Quiz quiz = quizrepo.findByTitle(title);
            List<Question> questions = quiz.getQuestions();

            int score = 0,i=0;
            for (UserResponse ur : response) {
                if (ur.getResponse().equals(questions.get(i++).getCorrect())) score++;
            }
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(-1,HttpStatus.BAD_REQUEST);
    }
}
