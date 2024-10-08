package com.arnab.spring4_springjdbc.repo;

import com.arnab.spring4_springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
//    for JDBC operations
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        System.out.println("Student Data Saved");
        String query="Insert into Student (name,rollNo,marks) values(?,?,?)";
//        same as execute update in JDBC
        int row=jdbc.update(query,s.getName(),s.getRollNo(),s.getMarks());
        System.out.println(row+" effected");
    }

    public List<Student> findAll() {
        List<Student> student=new ArrayList<>();

        String query="Select * from Student";
//        Overriding mapRow method
//        RowMapper<Student> mapper=new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s=new Student();
//                s.setName(rs.getString("name"));
//                s.setRollNo(rs.getInt("rollNo"));
//                s.setMarks(rs.getInt("marks"));
//                return s;
//            }
//        };

//        using Lambda Expression
        return jdbc.query(query,(rs,rowNum)->{
                Student s=new Student();
                s.setName(rs.getString("name"));
                s.setRollNo(rs.getInt("rollNo"));
                s.setMarks(rs.getInt("marks"));
                return s;
        });

    }
}
