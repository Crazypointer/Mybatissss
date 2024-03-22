package com.test;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.TestMapper;
import org.junit.jupiter.api.*;

@Log
public class MainTest {
   private static SqlSessionFactory factory;
   @BeforeAll
   @SneakyThrows
   public static void before() {
      factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
   }

   @DisplayName("Mybatis test")
   @RepeatedTest(3)
    public void test(){
        try(SqlSession session = factory.openSession(true)){
            TestMapper testMapper = session.getMapper(TestMapper.class);
            System.out.println(testMapper.getStudentById(1));
        }
    }
    @DisplayName("Mybatis test2")

    @Test
    public void test2(){
        System.out.println("我是test2");
   }

}

