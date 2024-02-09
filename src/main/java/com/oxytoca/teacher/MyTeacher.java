package com.oxytoca.teacher;

import com.oxytoca.student.MyStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("newTeacherBean")
public class MyTeacher implements Teacher {
    List<MyStudent> listOfStudents;

    public MyTeacher() {

    }
    @Autowired
    public void setListOfStudents(List<MyStudent> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public List<MyStudent> getStudents() {
        return listOfStudents;
    }
}
