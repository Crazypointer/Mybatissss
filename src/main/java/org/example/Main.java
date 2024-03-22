package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entry.Student;
import org.example.mapper.TestMapper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TestMapper mapper = session.getMapper(TestMapper.class);
            Student student = mapper.getStudentById(1 );
        }

    }
}
