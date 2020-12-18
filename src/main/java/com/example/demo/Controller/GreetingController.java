package com.example.demo.Controller;
import com.example.demo.RestService.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    /*private static final String template = "Hello, %s!";*/
    private static final String template = " %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    /*
    @RequestParam binds the value of the query string parameter name into
     the name parameter of the greeting() method.
     If the name parameter is absent in the request,
     the defaultValue of World is used.
     */

    @GetMapping("/greeting")
    //public Greeting[] greeting(@RequestParam(value = "name", defaultValue = "World") String name){
    /*public Greeting[] greeting()
    {
        Greeting[] g = new Greeting[20];
        String[] name= {"佳艺","高登","佳艺","高登","佳艺","高登","佳艺","高登","佳艺","高登",
                "佳艺","高登","佳艺","高登","佳艺","高登","佳艺","高登","佳艺","高登"};
        for(int i=0;i<20;i++)
        {
            g[i]=new Greeting(counter.incrementAndGet(), String.format(template, name[i]));
        }
        return g;
    }*/
    @Scheduled(fixedRate = 1000)
    //schdule 不能有参数
    /*public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {*/
    public Greeting greeting()
    {
           Greeting g = new Greeting(counter.incrementAndGet(),
                   String.format(template, dateFormat.format(new Date())));
        return g;
    }
}