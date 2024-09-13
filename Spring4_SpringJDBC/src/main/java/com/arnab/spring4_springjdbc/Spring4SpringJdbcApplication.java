package com.arnab.spring4_springjdbc;

import com.arnab.spring4_springjdbc.model.Student;
import com.arnab.spring4_springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.*;

@SpringBootApplication
public class Spring4SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Spring4SpringJdbcApplication.class, args);

		Student s=context.getBean(Student.class);
		Student s1=context.getBean(Student.class);
		s.setName("Arnab");
		s.setRollNo(116);
		s.setMarks(85);

//		s.setName("Ram");
//		s.setRollNo(119);
//		s.setMarks(78);

		s1.setName("Rahim");
		s1.setRollNo(120);
		s1.setMarks(76);

		StudentService service=context.getBean(StudentService.class);
//		service.addStudent(s);
//		service.addStudent(s1);
		List<Student> student=service.getAllStudents();
		for(Student st:student){
			System.out.println(st.toString());
		}
	}

}
