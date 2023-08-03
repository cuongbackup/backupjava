package model;

import java.util.Calendar;

public class Dev extends NhanVien {

    int doneTaskNumber;
    int workingHour;

    public Dev() {
    }

    public Dev(int role, String empID, String account, Calendar workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int doneTaskNumber, int workingHour) {
        super(empID, account, workStartingDate, productivityScore, monthlyIncome, rewardSalary, role);
        this.doneTaskNumber = doneTaskNumber;
        this.workingHour = workingHour;
    }

    public int getDoneTaskNumber() {
        return doneTaskNumber;
    }

    public void setDoneTaskNumber(int doneTaskNumber) {
        this.doneTaskNumber = doneTaskNumber;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    @Override
    double calMonthlyIncome() {
        return (workingHour * 1500000) + rewardSalary + doneTaskNumber;
    }

    @Override
    double calReward() {
        return 0;
    }
}
