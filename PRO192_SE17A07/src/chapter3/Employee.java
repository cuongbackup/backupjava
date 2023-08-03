package chapter3;

import java.util.Scanner;

public class Employee {

    private String name;
    private int age;
    private String address;
    private int salary;
    private float rate;

    public Employee() {

    }

    public Employee(String name, int age, String address, int salary, float rate) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.rate = rate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float calSalary() {
        return (int) (this.salary * this.rate);
    }

    public void inputInf() {
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        name = input.nextLine();
        System.out.print("Age: ");
        age = input.nextInt();
        input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();
        System.out.print("Base salary: ");
        salary = input.nextInt();
        input.nextLine();
        System.out.print("Rate: ");
        rate = input.nextFloat();
        input.nextLine();
    }

    public void outputInf() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + calSalary() + "\n");
    }

    public void outputInf(int i) {
        System.out.println("Employee [" + (i + 1) + "]'s name: " + name);
        System.out.println("Employee [" + (i + 1) + "]'s age: " + age);
        System.out.println("Employee [" + (i + 1) + "]'s address: " + address);
        System.out.println("Employee [" + (i + 1) + "]'s salary: " + salary);
        System.out.println("Employee [" + (i + 1) + "]'s rate: " + rate);
        System.out.println("--------------------------------------------");
    }
}
