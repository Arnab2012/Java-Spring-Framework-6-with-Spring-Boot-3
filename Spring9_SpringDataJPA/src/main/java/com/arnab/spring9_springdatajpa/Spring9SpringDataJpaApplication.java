package com.arnab.spring9_springdatajpa;

import com.arnab.spring9_springdatajpa.model.Student;
import com.arnab.spring9_springdatajpa.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Spring9SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Spring9SpringDataJpaApplication.class, args);

		StudentRepo repo=context.getBean(StudentRepo.class);

//		getting Student Class Objects
		Student s1=context.getBean(Student.class);
		Student s2=context.getBean(Student.class);
		Student s3=context.getBean(Student.class);

//		setting values
		s1.setRollNo(1);
		s1.setName("Ayan");
		s1.setMarks(80);

		s2.setRollNo(2);
		s2.setName("Arnab");
		s2.setMarks(85);

		s3.setRollNo(3);
		s3.setName("Pritam");
		s3.setMarks(76);

//		to save a row in the table
//		repo.save(s1);

		repo.save(s2);
		repo.save(s3);

//		for fetching all data
		System.out.println(repo.findAll());

//		fetching data by Id (findById() to find By Primary Key)
//		System.out.println(repo.findById(3));

		Optional<Student> s=repo.findById(4);
		System.out.println(s.orElse(new Student()));

		System.out.println(repo.findByName("Ayan"));
		System.out.println(repo.findByMarks(85));
		System.out.println(repo.findByMarksGreaterThan(72));
	}


}
