package model;

import java.util.Calendar;

public class Leader extends NhanVien{
    int reviewTaskNumber;
    int supportTaskNumber;
    double allowance;

    public Leader() {
    }

    public Leader(int role, String empID, String account, Calendar workStartingDate, double productivityScore, double monthlyIncome, double rewardSalary, int reviewTaskNumber, int supportTaskNumber, double allowance) {
        super(empID, account, workStartingDate, productivityScore, monthlyIncome, rewardSalary, role);
        this.reviewTaskNumber = reviewTaskNumber;
        this.supportTaskNumber = supportTaskNumber;
        this.allowance = allowance;
    }

    public int getReviewTaskNumber() {
        return reviewTaskNumber;
    }

    public void setReviewTaskNumber(int reviewTaskNumber) {
        this.reviewTaskNumber = reviewTaskNumber;
    }

    public int getSupportTaskNumber() {
        return supportTaskNumber;
    }

    public void setSupportTaskNumber(int supportTaskNumber) {
        this.supportTaskNumber = supportTaskNumber;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
    
        @Override
    double calMonthlyIncome() {
        return (reviewTaskNumber * 4000000) + (supportTaskNumber * 400000) + rewardSalary + allowance;
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
