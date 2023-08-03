package model;

import java.util.Calendar;
import java.util.Date;

public class Management extends NhanVien {

    int resolveIssueNumber;
    int otherTaskNumber;
    double allowance;

    public Management() {
    }

    public Management(int role, String empID, String account, Calendar workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int resolveIssueNumber, int otherTaskNumber, double allowance) {
        super(empID, account, workStartingDate, productivityScore, monthlyIncome, rewardSalary, role);
        this.resolveIssueNumber = resolveIssueNumber;
        this.otherTaskNumber = otherTaskNumber;
        this.allowance = allowance;
    }

    public int getResolveIssueNumber() {
        return resolveIssueNumber;
    }

    public void setResolveIssueNumber(int resolveIssueNumber) {
        this.resolveIssueNumber = resolveIssueNumber;
    }

    public int getOtherTaskNumber() {
        return otherTaskNumber;
    }

    public void setOtherTaskNumber(int otherTaskNumber) {
        this.otherTaskNumber = otherTaskNumber;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    double calMonthlyIncome() {
        return (resolveIssueNumber * 5000000) + (otherTaskNumber * 500000) + rewardSalary + allowance;
    }

    @Override
    double calReward() {
        return productivityScore * 3000000;
    }

    double calAllowance() {
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.MONTH) - super.getWorkStartingDate().get(Calendar.MONTH) >= 36) {
            allowance = 2000000 * productivityScore;
        } else {
            allowance = 1200000 * productivityScore;
        }
        return allowance;
    }
}
