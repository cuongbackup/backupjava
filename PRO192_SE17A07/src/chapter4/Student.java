package chapter4;

public class Student extends Person implements Comment{

    private double gpa;

    public Student(String name, int age, String address, double gpa) {
        super(name, age, address);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    @Override
    public void doing() {
        System.out.println("Studying");
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" + "gpa=" + gpa + '}';
    }

    @Override
    public boolean rate() {
        if (gpa >= 5) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void evaluate() {
        if (rate()) {
            System.out.println("Chuc mung ban da pass");
        }
        else {
            System.out.println("Hay co gang hoc tiep nhe");
        }
    }

    @Override
    public boolean checkAge() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
