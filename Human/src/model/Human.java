/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Human {
    private int id;
    private String name;
    private Date dob;
    private boolean gender;
    private HumanType type;
    
    public Human() {
        
    }

    public Human(int id, String name, Date dob, boolean gender, HumanType type) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public HumanType getType() {
        return type;
    }

    public void setType(HumanType type) {
        this.type = type;
    }
    
    
}
