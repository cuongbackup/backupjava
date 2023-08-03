/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class HourlyEmployee {
    private String employeeID;
    private String lastName;
    private double hourlyRate;
    private double hourlyWork;
    
    public HourlyEmployee() {
        
    }

    public HourlyEmployee(String employeeID, String lastName, double hourlyRate, double hourlyWork) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.hourlyWork = hourlyWork;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyWork() {
        return hourlyWork;
    }

    public void setHourlyWork(double hourlyWork) {
        this.hourlyWork = hourlyWork;
    }
    
    
}
