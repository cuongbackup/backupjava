/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Khoa extends Sinhvien{
    private String khoaID, khoaName;
    
    public Khoa() {}

    public Khoa(String khoaID, String khoaName, String studentID, String lastName, String firstName, String email, String gender, String facultty, String className, Date date) {
        super(studentID, lastName, firstName, email, gender, facultty, className, date);
        this.khoaID = khoaID;
        this.khoaName = khoaName;
    }

    public String getKhoaID() {
        return khoaID;
    }

    public void setKhoaID(String khoaID) {
        this.khoaID = khoaID;
    }

    public String getKhoaName() {
        return khoaName;
    }

    public void setKhoaName(String khoaName) {
        this.khoaName = khoaName;
    }
    
    
}
