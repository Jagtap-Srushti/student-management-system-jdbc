package com.sms.dao.impl;

import com.sms.util.DBConnection;
import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public void addStudent(Student std) {
        String query="insert into students (name,email,course) values (?,?,?)";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,std.getName());
            ps.setString(2,std.getEmail());
            ps.setString(3, std.getCourse());

            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list=new ArrayList<>();
        String query="Select * from students";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Student s=new Student(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("course"));
                list.add(s);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void updateStudent(int id, String course) {
        String query="update students set course=? where id=?";
            try{
                Connection con= DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,course);
                ps.setInt(2,id);

                int count= ps.executeUpdate();

                if(count>0){
                    System.out.println("Student updated successfully!");
                }
                else{
                    System.out.println("Student not found!");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

    }

    @Override
    public void deleteStudent(int id) {
        String query="delete from students where id=?";

        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);

            int row=ps.executeUpdate();

            if(row>0){
                System.out.println("Student Deleted Successfully");
            }
            else{
                System.out.println("Student Not Found!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
