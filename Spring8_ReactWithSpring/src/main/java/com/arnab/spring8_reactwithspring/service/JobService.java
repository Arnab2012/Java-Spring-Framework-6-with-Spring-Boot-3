package com.arnab.spring8_reactwithspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.spring8_reactwithspring.model.JobPost;
import com.arnab.spring8_reactwithspring.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;

//  method to return all Job Posts
	public List<JobPost> getAllJobs() {
//		return repo.getAllJobs();
		return repo.findAll();
	}

//	method to get Job Post based on PostId
	public JobPost getJob(int postId) {
//		return repo.getJob(postId);
		return repo.findById(postId).orElse(new JobPost());
	}


//	method to add a Job Post
	public void addJob(JobPost jobPost) {
//		repo.addJob(jobPost);
		repo.save(jobPost);
	}

//	method to update a Job Post
	public void updateJob(JobPost jobPost) {
//		repo.updateJob(jobPost);
		repo.save(jobPost);
	}

//	method to delete a Job Post
	public void deleteJob(int postId) {
//		repo.deleteJob(postId);
		repo.deleteById(postId);
	}

//	add demo data while the table is created first
	public void load(){
		List<JobPost> jobs = new ArrayList<>(Arrays.asList(
				new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
						List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
				new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
						3, List.of("HTML", "CSS", "JavaScript", "React")),
				new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
						List.of("Python", "Machine Learning", "Data Analysis"))

		));
		repo.saveAll(jobs);
	}

	public List<JobPost> search(String keyword) {
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}
}

