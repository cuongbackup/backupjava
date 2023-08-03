/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Customer {
    private String cusID;
    private String name;
    private String birthDate;
    private String sex;
    private String identifyID;
    private int vacineTime;
    private String travelDate;
    private int ticketPrice;
    
    public Customer() {
        
    }

    public Customer(String cusID, String name, String birthDate, String sex, String identifyID, int vacineTime, String travelDate, int ticketPrice) {
        this.cusID = cusID;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.identifyID = identifyID;
        this.vacineTime = vacineTime;
        this.travelDate = travelDate;
        this.ticketPrice = ticketPrice;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentifyID() {
        return identifyID;
    }

    public void setIdentifyID(String identifyID) {
        this.identifyID = identifyID;
    }

    public int getVacineTime() {
        return vacineTime;
    }

    public void setVacineTime(int vacineTime) {
        this.vacineTime = vacineTime;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusID=" + cusID + ", name=" + name + ", birthDate=" + birthDate + ", sex=" + sex + ", identifyID=" + identifyID + ", vacineTime=" + vacineTime + ", travelDate=" + travelDate + ", ticketPrice=" + ticketPrice + '}';
    }
    
    
}
