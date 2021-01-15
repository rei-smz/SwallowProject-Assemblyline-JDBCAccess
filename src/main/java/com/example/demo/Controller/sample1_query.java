package com.example.demo.Controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@CrossOrigin
public class sample1_query {
    @JsonProperty("id")
    private static final String template = "select * from sample1 where id=%d";
    private static int ssn=1;
    @Autowired
    private JdbcTemplate jdbcTemplate1;
    @RequestMapping("/sample1")
    @ResponseBody
    public List<Map<String,Object>> contextLoads() {
        List<Map<String,Object>> result=jdbcTemplate1.queryForList(String.format(template,ssn++));
        return result;
    }
}