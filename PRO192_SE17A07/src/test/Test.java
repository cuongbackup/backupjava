package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of employees: ");
        int numberOfEmployee = sc.nextInt();
        ArrayList<Employee> employeeList = new ArrayList<>(numberOfEmployee);

        for (int i = 0; i < numberOfEmployee; i++) {
            employeeList.add(newEmployee());
            System.out.println("Completed inputting employee no " + (i + 1) + "\n");
        }
        System.out.println("---Employees list---");
        for (int i = 0; i < numberOfEmployee; i++) {
            employeeList.get(i).outputInf();
        }
    }

    static Employee newEmployee() {
        Employee employee = new Employee();
        employee.input();
        return employee;
    }
}
