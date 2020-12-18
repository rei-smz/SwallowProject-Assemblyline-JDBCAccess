package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class QuickCon {
    private static final String template = "select * from student where ssn=";
    private static int ssn=444111110;
    @Autowired
    private JdbcTemplate jdbcTemplate1;
    @RequestMapping("/nigga")
    @ResponseBody
    @Scheduled(fixedRate = 5000)
    public List<Map<String,Object>> contextLoads() {
        if(ssn>=444111120)
            ssn=444111110;
        List<Map<String,Object>> result=jdbcTemplate1.queryForList(template+Integer.toString(ssn++));
        return result;
    }

    @RequestMapping("/quick")
    @ResponseBody
    public String quick()
    {
        return "hello motherfucker";
    }


}
