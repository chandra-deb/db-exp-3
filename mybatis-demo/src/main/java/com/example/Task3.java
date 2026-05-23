package com.example;

import com.example.mapper.StudentMapper;
import com.example.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sqlSessionFactory.openSession(true)) {
                StudentMapper mapper = session.getMapper(StudentMapper.class);

                System.out.println("--- Task 3 (Optional): Dynamic multi-condition query ---\n");

                // 1. Fuzzy search by name
                System.out.println("1) Fuzzy search by name (name contains 'i'):");
                Map<String, Object> params = new HashMap<>();
                params.put("name", "i");
                mapper.selectByConditions(params).forEach(System.out::println);

                System.out.println("\n2) Filter by major (Computer Science):");
                params.clear();
                params.put("major", "Computer Science");
                mapper.selectByConditions(params).forEach(System.out::println);

                System.out.println("\n3) Credit range query (credits >= 3.0 AND <= 4.0):");
                params.clear();
                params.put("minCredits", 3.0);
                params.put("maxCredits", 4.0);
                mapper.selectByConditions(params).forEach(System.out::println);

                System.out.println("\n4) Combined: name fuzzy + major + credit range + pagination (limit 1):");
                params.clear();
                params.put("name", "a");
                params.put("major", "Computer Science");
                params.put("minCredits", 3.0);
                params.put("maxCredits", 4.0);
                params.put("limit", 1);
                params.put("offset", 0);
                mapper.selectByConditions(params).forEach(System.out::println);

                System.out.println("\nTask 3 done.");
            }
        }
    }
}
