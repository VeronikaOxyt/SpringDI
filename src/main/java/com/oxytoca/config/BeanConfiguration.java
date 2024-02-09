package com.oxytoca.config;

import com.oxytoca.student.MyStudent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@ComponentScan("com.oxytoca")
@PropertySource("classpath:data.properties")
public class BeanConfiguration {

    private List<String> listOfSubjects(String stringSubjects) {
        return List.of(stringSubjects.split(","));
    }

    private List<Double> listOfGrades(String grades) {
        return Arrays
                .stream(grades.split(","))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

    private Map<String, Double> reportCardForStudent( String subjects, String stringGrades) {
        Map<String, Double> reportCard = new HashMap<>();
        List<String> subjectsList = listOfSubjects(subjects);
        for (int i = 0; i < subjectsList.size(); i++) {
            reportCard.put(subjectsList.get(i), listOfGrades(stringGrades).get(i));
        }
        return reportCard;
    }

    @Bean(initMethod = "init")
    public MyStudent newStudent1(@Value("${newStudent.grades1}") String stringGrades,
                                 @Value("${newStudent.name1}") String name,
                                 @Value("${subjects}") String stringSubjects) {
        return new MyStudent(name, reportCardForStudent(stringSubjects, stringGrades));
    }

    @Bean(initMethod = "init")
    public MyStudent newStudent2(@Value("${newStudent.grades2}") String stringGrades,
                                 @Value("${newStudent.name2}") String name,
                                 @Value("${subjects}") String stringSubjects) {
        return new MyStudent(name, reportCardForStudent(stringSubjects, stringGrades));
    }

    @Bean(initMethod = "init")
    public MyStudent newStudent3(@Value("${newStudent.grades3}") String stringGrades,
                                 @Value("${newStudent.name3}") String name,
                                 @Value("${subjects}") String stringSubjects) {
        return new MyStudent(name, reportCardForStudent(stringSubjects, stringGrades));
    }
}
