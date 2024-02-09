package com.oxytoca;

import com.oxytoca.teacher.NewTeacher;
import com.oxytoca.teacher.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class AppA
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextA.xml");

        Teacher teacher = context.getBean("newTeacherBean", NewTeacher.class);

        context.close();
    }
}
