package chapter3;

import java.util.Scanner;

public class TestArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of employees: ");
        int numberOfEmployee = sc.nextInt();
        Employee[] employee = new Employee[numberOfEmployee];
        for (int i = 0; i < numberOfEmployee; i++) {
            employee[i] = new Employee();
        }
        for (int i = 0; i < numberOfEmployee; i++) {
            employee[i].inputInf();
            System.out.println("Completed inputting employee no " + (i + 1) + "\n");
        }
        System.out.println("---Employees list---");
        for (int i = 0; i < numberOfEmployee; i++) {
            employee[i].outputInf();
        }
    }
}
