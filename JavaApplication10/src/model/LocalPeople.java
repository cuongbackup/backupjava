/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Administrator
 */
public class LocalPeople extends Customer{
    private String address;

    public LocalPeople() {
    }

    public LocalPeople(String cusID, String name, String birthDate, String sex, String identifyID, int vacineTime, String travelDate, int ticketPrice, String address) {
        super(cusID, name, birthDate, sex, identifyID, vacineTime, travelDate, ticketPrice);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "LocalPeople{" + "cusID=" + getCusID() + ", name=" + getName() + ", birthDate=" + getBirthDate() + ", sex=" + getSex() +  ", identifyID=" + getIdentifyID() + ", vacineTime=" + getVacineTime() + ", travelDate=" + getTravelDate() + ", ticketPrice=" + getTicketPrice() + ", address=" + address + '}';
    }    
}
