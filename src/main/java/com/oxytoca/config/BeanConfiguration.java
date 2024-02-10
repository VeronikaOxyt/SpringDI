package com.oxytoca.config;

import com.oxytoca.student.MyStudent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.*;

@Configuration
@ComponentScan("com.oxytoca")
@PropertySource("classpath:data.properties")
public class BeanConfiguration {

    @Bean(initMethod = "init")
    public MyStudent newStudent1(@Value("${newStudent.name1}") String name) {
        Map<String, Double> reportCard = new HashMap<>();
        reportCard.put("math", 5.0);
        reportCard.put("economics", 4.0);
        reportCard.put("technicalDrawing", 5.0);
        reportCard.put("physics", 4.0);
        return new MyStudent(name, reportCard);
    }

    @Bean(initMethod = "init")
    public MyStudent newStudent2(@Value("${newStudent.name2}") String name) {
        Map<String, Double> reportCard = new HashMap<>();
        reportCard.put("math", 5.0);
        reportCard.put("economics", 4.0);
        reportCard.put("technicalDrawing", 5.0);
        reportCard.put("physics", 3.0);
        return new MyStudent(name, reportCard);
    }

    @Bean(initMethod = "init")
    public MyStudent newStudent3(@Value("${newStudent.name3}") String name) {
        Map<String, Double> reportCard = new HashMap<>();
        reportCard.put("math", 3.0);
        reportCard.put("economics", 3.0);
        reportCard.put("technicalDrawing", 2.0);
        reportCard.put("physics", 2.0);
        return new MyStudent(name, reportCard);
    }
}