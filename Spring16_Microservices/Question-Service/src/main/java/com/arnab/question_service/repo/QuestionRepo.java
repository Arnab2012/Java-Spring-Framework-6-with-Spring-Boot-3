package com.arnab.question_service.repo;


import com.arnab.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value="Select q.id from question q where q.category=:category Order By Rand() Limit :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int numQ);
}
