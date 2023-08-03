package pro192_se17a07;

import java.util.Scanner;

public class Lab1_b4 {

    public static void main(String[] args) {
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
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}
