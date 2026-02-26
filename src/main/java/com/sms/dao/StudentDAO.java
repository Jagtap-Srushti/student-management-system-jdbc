package com.sms.dao;

import com.sms.model.Student;
import java.util.*;


public interface StudentDAO{
    void addStudent(Student std);
    List<Student> getAllStudents();
    void updateStudent(int id,String course);
    void deleteStudent(int id);
}

