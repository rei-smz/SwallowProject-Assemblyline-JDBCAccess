package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
public class sample3_query {


    private static final String template = "select * from sample3 where id=%d";
    private static int ssn=1;
    private static long rows;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;
    @RequestMapping("/sample3")
    @ResponseBody
    public List<Map<String,Object>> contextLoads() {
        List<Map<String,Object>> result=jdbcTemplate1.queryForList(String.format(template,ssn++));
        return result;
    }
    @RequestMapping("/sp3rows")
    @Scheduled(fixedRate = 200)
    //refresh info_page for 0.2ms
    public long rows() {
        String sentence="select table_rows from tables where table_name=\"sample3\";";
        return jdbcTemplate2.queryForObject(sentence,long.class);
    }
}