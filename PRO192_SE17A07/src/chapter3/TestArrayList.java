package chapter3;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {

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

        int choice;
        boolean isStop = false;
        while (isStop == false) {
            do {
                System.out.println("1. Add new employee");
                System.out.println("2. Remove an employee by idx");
                System.out.println("3. Display information of an employee by idx");
                System.out.println("4. Display information of all employees");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
            } while (choice < 1 || choice > 5);
            switch (choice) {
                case 1:
                    employeeList.add(newEmployee());
                    break;
                case 2:
                    if (!employeeList.isEmpty()) {
                        System.out.println("List of employees with name & Idx:");
                        for (int i = 0; i < employeeList.size(); i++) {
                            System.out.println("Idx: " + (i + 1) + ": " + (employeeList.get(i).getName()));
                        }
                        System.out.print("Enter the employee idx you want to remove: ");
                        employeeList.remove(getIdx());
                    } else {
                        System.out.println("The list is empty");
                    }
                    break;
                case 3:
                    if (!employeeList.isEmpty()) {
                        System.out.println("List of employees with name & idx:");
                        for (int i = 0; i < employeeList.size(); i++) {
                            System.out.println("Idx: " + (i + 1) + ": " + (employeeList.get(i).getName()));
                        }
                        System.out.print("Enter the employee idx to know more: ");
                        (employeeList.get(getIdx())).outputInf();
                    } else {
                        System.out.println("The list is empty");
                    }
                    break;
                case 4:
                    if (!employeeList.isEmpty()) {
                        for (int i = 0; i < employeeList.size(); i++) {
                            (employeeList.get(i)).outputInf(i);
                        }
                    } else {
                        System.out.println("The list is empty");
                    }
                    break;
                case 5:
                    isStop = true;
                    break;
            }
        }
        sc.close();

    }

    static int getIdx() {
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        sc.nextLine();
        return (idx - 1);
    }

    static Employee newEmployee() {
        Employee employee = new Employee();
        employee.inputInf();
        return employee;
    }
}
