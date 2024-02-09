package com.oxytoca.teacher;

import com.oxytoca.student.NewStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("newTeacherBean")
public class NewTeacher implements Teacher {
    List<NewStudent> listOfStudents;

    public NewTeacher() {
        System.out.println("Teacher bean is created");
    }
    @Autowired
    public void setListOfStudents(List<NewStudent> listOfStudents) {
        this.listOfStudents = listOfStudents;
        System.out.println("list of students is created " + listOfStudents.get(0).getReportCard() + listOfStudents.get(2).getReportCard());
    }

}
