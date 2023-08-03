package pro192_se17a07;

import java.util.Scanner;

public class Lab1_b5 {

    public static void studentInfo() {
        float avg;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input full name: ");
        name = sc.nextLine();
        sc = new Scanner(System.in);
        do {
            System.out.println("Input average score: ");
            avg = sc.nextFloat();
        } while ((avg < 0) || (avg > 10));
        System.out.println("<<Full name: " + name + ">> " + "<<Average score: " + avg + ">>\n");
    }

    public static void rectangleInfo() {
        float length, width;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input length: ");
            length = sc.nextFloat();
            System.out.println("Input width: ");
            width = sc.nextFloat();
        } while ((width > length) || (width > 0) || (length > 0));
        float perimeter = (length + width) * 2;
        float area = length * width;
        float minorSides = Math.min(length, width);
        System.out.println("Rectangle's perimeter: " + perimeter);
        System.out.println("Rectangle's area: " + area);
        System.out.println("Rectangle's minor sides: \n" + minorSides);
    }

    public static void electricityInfo() {
        float number, price;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input number of electricity: ");
            number = sc.nextFloat();
        } while (number < 0);
        if (number <= 50) {
            price = number * 1000;
        } else {
            price = (50 * 1000 + (number - 50) * 1200);
        }
        System.out.println("Electricity price: \n" + price);
    }

    public static void primeChecker() {
        int number;
        int check = 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Input an integer larger than 1:");
            number = sc.nextInt();
        } while (number < 2);
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                check = 0;
                break;
            }
        }
        if (check == 1) {
            System.out.println(number + " is a prime number\n");
        } else {
            System.out.println(number + " is not a prime number\n");
        }
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Input student's information");
            System.out.println("2. Calculate perimeter, area and minor sides of a rectangle");
            System.out.println("3. Calculate electricity bill");
            System.out.println("4. Check prime");
            System.out.println("Other. Quit");
            System.out.println("You choose: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    studentInfo();
                    break;
                }
                case 2: {
                    rectangleInfo();
                    break;
                }
                case 3: {
                    electricityInfo();
                    break;
                }
                case 4: {
                    primeChecker();
                    break;
                }
                default: {
                    break;
                }
            }
        } while ((choice > 0) && (choice < 5));
    }
}
