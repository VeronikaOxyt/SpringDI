package com.oxytoca;

import com.oxytoca.config.BeanConfiguration;
import com.oxytoca.teacher.MyTeacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppB {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);
        MyTeacher teacher = context.getBean("newTeacherBean", MyTeacher.class);
        teacher.getStudents().forEach(System.out::println);
        context.close();
    }
}
