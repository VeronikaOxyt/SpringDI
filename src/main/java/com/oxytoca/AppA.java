package com.oxytoca;

import com.oxytoca.teacher.MyTeacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppA {
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextA.xml");

        MyTeacher teacher = context.getBean("newTeacherBean", MyTeacher.class);
        teacher.getStudents().forEach(System.out::println);
        context.close();
    }
}
