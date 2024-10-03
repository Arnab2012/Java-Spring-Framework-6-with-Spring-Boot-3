package com.arnab.quizapp.repo;

import com.arnab.quizapp.model.Question;
import com.arnab.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
    Quiz findByTitle(String title);
}
