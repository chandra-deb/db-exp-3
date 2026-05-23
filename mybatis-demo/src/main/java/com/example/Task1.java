package com.example;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sqlSessionFactory.openSession(true)) {
                StudentMapper mapper = session.getMapper(StudentMapper.class);

                System.out.println("--- Task 1: CRUD Operations ---");

                System.out.println("-- Select all students --");
                List<Student> all = mapper.selectAll();
                all.forEach(System.out::println);

                System.out.println("-- Insert a new student --");
                Student newStudent = new Student("DemoUser", "male", "Computer Science", Date.valueOf("2004-02-01"), 3.4);
                mapper.insertStudent(newStudent);
                System.out.println("Inserted student id=" + newStudent.getSid());

                System.out.println("-- Update the new student --");
                newStudent.setSname("DemoUserUpdated");
                newStudent.setScreditPoints(3.9);
                mapper.updateStudent(newStudent);

                System.out.println("-- Select by id --");
                Student s = mapper.selectById(newStudent.getSid());
                System.out.println(s);

                System.out.println("-- Delete the demo student --");
                mapper.deleteById(newStudent.getSid());

                System.out.println("Task 1 done.");
            }
        }
    }
}
