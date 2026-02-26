package com.sms.main;

import com.sms.dao.StudentDAO;
import com.sms.dao.impl.StudentDAOImpl;
import com.sms.model.Student;

import java.util.*;


public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentDAO dao=new StudentDAOImpl();
        while(true){
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");




            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    System.out.println("Name: ");
                    String name=sc.nextLine();
                    System.out.println("Email: ");
                    String email=sc.nextLine();
                    System.out.println("Course");
                    String course=sc.nextLine();
                    dao.addStudent(new Student(name,email,course));
                    break;
                case 2:
                    List<Student> list=dao.getAllStudents();
                    if(list.isEmpty()){
                        System.out.println("No Studentfound.");
                    }
                    else {
                        list.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.println("Enter ID :");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("New Course: ");
                    String newCourse=sc.nextLine();
                    dao.updateStudent(id,newCourse);
                    break;
                case 4:
                    System.out.println("Enter ID: ");
                    int deleteId=sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");

            }
        }
    }
}
