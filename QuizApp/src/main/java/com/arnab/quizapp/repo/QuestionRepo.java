package com.arnab.quizapp.repo;

import com.arnab.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value="Select * from question q where q.category=:category Order By Rand() Limit :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
