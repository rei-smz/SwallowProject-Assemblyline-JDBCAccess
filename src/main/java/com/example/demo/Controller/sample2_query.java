package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
@CrossOrigin
public class sample2_query {


    private static final String template = "select * from sample2 where id=%d";
    private static int ssn=1;
    private static int ssn2=1;
    private static long rows;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;
    @RequestMapping("/sample2")
    @ResponseBody
    public List<Map<String,Object>> contextLoads() {
        List<Map<String,Object>> result=jdbcTemplate1.queryForList(String.format(template,ssn++));
        return result;
    }
    @RequestMapping("/sp2rows")
    @Scheduled(fixedRate = 200)
    //refresh info_page for 0.2ms
    public long rows() {
        String sentence="select table_rows from tables where table_name=\"sample2\";";
        return jdbcTemplate2.queryForObject(sentence,long.class);
    }
    @RequestMapping("/function2")
    @ResponseBody
    public String fun1() {
        String fun1="y=ax+b,a=2,b=3,result = %f";
        double result1=jdbcTemplate1.queryForObject(String.format("select length from sample1 where id=%d",ssn2++),double.class);
        return String.format(fun1,(result1*2+3));
    }
}