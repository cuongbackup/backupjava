/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Administrator
 */
public class ForeignPeople extends Customer{
    private String passPort;
    private int travelTime;

    public ForeignPeople() {
    }

    public ForeignPeople(String cusID, String name, String birthDate, String sex, String identifyID, int vacineTime, String travelDate, int ticketPrice, String passPort, int travelTime) {
        super(cusID, name, birthDate, sex, identifyID, vacineTime, travelDate, ticketPrice);
        this.passPort = passPort;
        this.travelTime = travelTime;
    }

    public String getPassPort() {
        return passPort;
    }

    public void setPassPort(String passPort) {
        this.passPort = passPort;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }


    
    @Override
    public String toString() {
        return "ForeignPeople{" + "cusID=" + getCusID() + ", name=" + getName() + ", birthDate=" + getBirthDate() + ", sex=" + getSex() +  ", identifyID=" + getIdentifyID() + ", vacineTime=" + getVacineTime() + ", travelDate=" + getTravelDate() + ", ticketPrice=" + getTicketPrice() + ", passPort=" + passPort + ", travelTime=" + travelTime + '}';
    }    
}
