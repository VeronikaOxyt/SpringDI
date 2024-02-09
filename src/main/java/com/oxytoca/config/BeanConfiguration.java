package com.oxytoca.config;

import com.oxytoca.student.NewStudent;
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
    private List<String> subjects = new ArrayList<>();

    private void listOfSubjects(@Value("${subjects}") String stringSubjects) {
        subjects = List.of(stringSubjects.split(","));
    }

    private List<Double> listOfGrades(String grades) {
        return Arrays
                .stream(grades.split(","))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

    private Map<String, Double> reportCardForStudent(String stringGrades) {
        Map<String, Double> reportCard = new HashMap<>();

        for (int i = 0; i < subjects.size(); i++) {
            reportCard.put(subjects.get(i), listOfGrades(stringGrades).get(i));
        }
        return reportCard;
    }

    @Bean(initMethod = "init")
    public NewStudent newStudent1(@Value("${newStudent.grades1}") String stringGrades,
                               @Value("${newStudent.name1}") String name) {
        System.out.println(reportCardForStudent(stringGrades));
        return new NewStudent(name, reportCardForStudent(stringGrades));
    }

    @Bean(initMethod = "init")
    public NewStudent newStudent2(@Value("${newStudent.grades2}") String stringGrades,
                               @Value("${newStudent.name2}") String name) {
        System.out.println("CREATING newStudent2");
        return new NewStudent(name, reportCardForStudent(stringGrades));
    }

    @Bean(initMethod = "init")
    public NewStudent newStudent3(@Value("${newStudent.grades3}") String stringGrades,
                               @Value("${newStudent.name3}") String name) {
        System.out.println("CREATING newStudent3");
        return new NewStudent(name, reportCardForStudent(stringGrades));
    }
}
