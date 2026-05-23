package com.example.mapper;

import com.example.pojo.Student;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> selectAll();
    Student selectById(int sid);
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteById(int sid);

    // Optional dynamic multi-condition query
    List<Student> selectByConditions(Map<String, Object> params);
}
