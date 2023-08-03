/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Administrator
 */

public class Sinhvien {
    private String studentID, lastName, firstName, email, gender, facultty, className;
    private Date date;
    
    public Sinhvien() {}

    public Sinhvien(String studentID, String lastName, String firstName, String email, String gender, String facultty, String className, Date date) {
        this.studentID = studentID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.gender = gender;
        this.facultty = facultty;
        this.className = className;
        this.date = date;
    }

    public String getFacultty() {
        return facultty;
    }

    public void setFacultty(String facultty) {
        this.facultty = facultty;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public ArrayList<Sinhvien> listStudent() {
    return null;
}
    public inputStudent()
}
