package chapter4;

public class Manager extends Teacher {

    private int bonus;

    public Manager(String name, int age, String address, int salary, int bonus) {
        super(name, age, address, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" + "salary=" + getSalary() + '}';
    }

}
