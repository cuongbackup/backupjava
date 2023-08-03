package chapter4;

public class Teacher extends Person implements Comment, Comparable<Teacher>{

    private int salary;

    public Teacher(String name, int age, String address, int salary) {
        super(name, age, address);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "Salary{" + "salary=" + salary + '}';
    }

    @Override
    public void doing() {
        System.out.println("Teaching");
    }

    @Override
    public boolean rate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkAge() {
        if (this.age >= 60) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void evaluate() {
        if(checkAge()) {
            System.out.println("Chuc mung ban duoc nghi");
        }
        else {
            System.out.println("Hay tiep tuc lam viec nhe");
        }
    }
    
    @Override
    public int compareTo(Teacher t) {
        return Double.compare(this.getSalary(), t.getSalary());
    }
    
}
