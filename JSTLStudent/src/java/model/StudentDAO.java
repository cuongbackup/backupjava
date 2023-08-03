/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class StudentDAO {

    public List<Student> getStudents() {
        List<Student> sl = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "Select * from studentTBL";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                Student student = new Student(id, firstName, lastName, email);
                sl.add(student);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return sl;
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO studentTBL (firstname, lastname, email)\n" + "VALUES (?,?, ?);";
        DBContext db = DBContext.getInstance();

        Connection con;

        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.execute();

            statement.close();
            con.close();

        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    public void updateStudent(Student student) {
        String sql = " UPDATE [VKUStudentDB].[dbo].[studentTBL]\n"
                + "SET firstName=?, lastName=?, email = ?\n"
                + "WHERE id = ?";
        DBContext db = DBContext.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setInt(4, student.getId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public Student getStudent(String idd) {
        int id = Integer.parseInt(idd);
        DBContext db = DBContext.getInstance();

        Student student = null;
        String sql = "Select * from studentTBL where id=?";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {

                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                student = new Student(id, firstName, lastName, email);

            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return student;
    }

    public void deleteStudent(String idd) {
        try {
            DBContext db = DBContext.getInstance();
            Connection con = db.openConnection();
            String sql = "DELETE FROM studentTBL WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
