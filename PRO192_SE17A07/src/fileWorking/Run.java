package fileWorking;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of employees: ");
		int element = Integer.valueOf(sc.nextLine());
		Employee[] emp = new Employee[element];

		for (int i = 0; i < element; i++) {
			emp[i] = new Employee();
		}

		for (int i = 0; i < element; i++) {
			System.out.print("Enter the name of the employee: ");
			emp[i].setName(String.valueOf(sc.nextLine()));
			System.out.print("Enter the age of the employee: ");
			emp[i].setAge(Integer.valueOf(sc.nextLine()));
			System.out.print("Enter the address of the employee: ");
			emp[i].setAddress(String.valueOf(sc.nextLine()));
			System.out.print("Enter the basic salary of the employee: ");
			emp[i].setSalary(Integer.valueOf(sc.nextLine()));

			System.out.printf("Inputting employee %d completed. Input next employee? [Y/N]", i);
			if (String.valueOf(sc.nextLine()).toUpperCase().equals("N"))
				break;
		}
		System.out.println("Can't input anymore!");
		System.out.println("----------LIST OF EMPLOYEES----------");
		System.out.printf("%-15s %-15s %-15s %-15s\n", "Name", "Age", "Address", "Salary");
		for (int idx = 0; idx < element; idx++) {
			emp[idx].display();
		}

	}

}
