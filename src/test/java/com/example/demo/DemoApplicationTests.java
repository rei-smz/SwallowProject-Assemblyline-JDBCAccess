package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate1;
    @Test
    void contextLoads() {

        List<Map<String,Object>> result=jdbcTemplate1.queryForList("select * from student;");
        System.out.println("Quert result is "+result.size());
        System.out.println("success");

    }
    @Test
    void testMysqlUpdate()
    {
            jdbcTemplate1.execute("select * from student");
            System.out.println("fucku");
    }

}
