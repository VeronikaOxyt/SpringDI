package com.oxytoca;

import com.oxytoca.config.BeanConfiguration;
import com.oxytoca.teacher.NewTeacher;
import com.oxytoca.teacher.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppB {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Teacher teacher = context.getBean("newTeacherBean", NewTeacher.class);

        context.close();
    }
}
