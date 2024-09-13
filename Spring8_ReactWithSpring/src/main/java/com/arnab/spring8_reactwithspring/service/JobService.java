package com.arnab.spring8_reactwithspring.service;

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
		return repo.getAllJobs();
	}

//	method to get Job Post based on PostId
	public JobPost getJob(int postId) {
		return repo.getJob(postId);
	}

//	method to add a Job Post
	public void addJob(JobPost jobPost) {
		repo.addJob(jobPost);
	}

//	method to update a Job Post
	public void updateJob(JobPost jobPost) {
		repo.updateJob(jobPost);
	}

//	method to delete a Job Post
	public void deleteJob(int postId) {
		repo.deleteJob(postId);
	}
}