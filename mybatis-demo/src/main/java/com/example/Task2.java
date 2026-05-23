package com.example;

import com.example.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sqlSessionFactory.openSession(true)) {
                StudentMapper mapper = session.getMapper(StudentMapper.class);

                System.out.println("--- Task 2: Query all attributes of the student table ---");
                List<Map<String, Object>> columns = mapper.describeStudents();
                System.out.printf("%-15s %-15s %-5s %-5s %-8s %-10s%n",
                        "Field", "Type", "Null", "Key", "Default", "Extra");
                System.out.println("-".repeat(60));
                for (Map<String, Object> col : columns) {
                    System.out.printf("%-15s %-15s %-5s %-5s %-8s %-10s%n",
                            col.get("Field"), col.get("Type"), col.get("Null"),
                            col.get("Key"), col.get("Default"), col.get("Extra"));
                }

                System.out.println("\nTask 2 done.");
            }
        }
    }
}
