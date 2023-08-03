/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Administrator
 */
public class OutProvincePeople extends Customer{
    private String province;

    public OutProvincePeople() {
    }

    public OutProvincePeople(String cusID, String name, String birthDate, String sex, String identifyID, int vacineTime, String travelDate, int ticketPrice, String province) {
        super(cusID, name, birthDate, sex, identifyID, vacineTime, travelDate, ticketPrice);
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    @Override
    public String toString() {
        return "OutProvincePeople{" + "cusID=" + getCusID() + ", name=" + getName() + ", birthDate=" + getBirthDate() + ", sex=" + getSex() +  ", identifyID=" + getIdentifyID() + ", vacineTime=" + getVacineTime() + ", travelDate=" + getTravelDate() + ", ticketPrice=" + getTicketPrice() + ", province=" + province + '}';
    }    
}
