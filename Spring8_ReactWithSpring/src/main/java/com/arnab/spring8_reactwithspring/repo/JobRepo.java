package com.arnab.spring8_reactwithspring.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnab.spring8_reactwithspring.model.JobPost;


// connecting to the database using Spring JPA

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer>{

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProf,String postDesc);
}

// without connecting to the database

//@Repository
//public class JobRepo {

//	 arrayList to store store JobPost objects
//	List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//			new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//			new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//					3, List.of("HTML", "CSS", "JavaScript", "React")),
//			new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//					List.of("Python", "Machine Learning", "Data Analysis"))
//
//	));
//
//  method to return all Job Posts
//	public List<JobPost> getAllJobs() {
//		return jobs;
//	}
//
//	method to get Job Post based on PostId
//	public JobPost getJob(int postId){
//		for(JobPost job:jobs){
//			if(job.getPostId()==postId){
//				return job;
//			}
//		}
//		return null;
//	}
//
//	method to add a Job Post
//	public void addJob(JobPost jobPost) {
//		jobs.add(jobPost);
//	}
//
//	method to update a Job Post
//	public void updateJob(JobPost jobPost) {
//		for(JobPost jobPost1:jobs){
//			if(jobPost1.getPostId()==jobPost.getPostId()){
//				jobPost1.setPostId(jobPost.getPostId());
//				jobPost1.setPostDesc(jobPost.getPostDesc());
//				jobPost1.setPostProfile(jobPost.getPostProfile());
//				jobPost1.setPostTechStack(jobPost.getPostTechStack());
//				jobPost1.setReqExperience(jobPost.getReqExperience());
//			}
//		}
//	}
//
//	method to delete a Job Post
//	public void deleteJob(int postId) {
//		jobs.removeIf(job -> job.getPostId() == postId);
//	}
//}
