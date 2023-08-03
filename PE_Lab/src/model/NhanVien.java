package model;

import java.util.Calendar;

public abstract class NhanVien {
    String empID;
    String account;
    Calendar workStartingDate;
    double productivityScore;
    double monthlyIncome;
    double rewardSalary;
    int role;

    public NhanVien() {        
    }
    public NhanVien(String empID, String account, Calendar workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int role) {
        this.empID = empID;
        this.account = account;
        this.workStartingDate = workStartingDate;
        this.productivityScore = productivityScore;
        this.monthlyIncome = monthlyIncome;
        this.rewardSalary = rewardSalary;
        this.role = role;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Calendar getWorkStartingDate() {
        return workStartingDate;
    }

    public void setWorkStartingDate(Calendar workStartingDate) {
        this.workStartingDate = workStartingDate;
    }

    public double getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(double productivityScore) {
        this.productivityScore = productivityScore;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getRewardSalary() {
        return rewardSalary;
    }

    public void setRewardSalary(double rewardSalary) {
        this.rewardSalary = rewardSalary;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    abstract double calMonthlyIncome();
    abstract double calReward();
}
