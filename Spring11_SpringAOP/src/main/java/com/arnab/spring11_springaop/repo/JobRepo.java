package com.arnab.spring11_springaop.repo;

import com.arnab.spring11_springaop.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// connecting to the database using Spring JPA

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer>{

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProf, String postDesc);
}
