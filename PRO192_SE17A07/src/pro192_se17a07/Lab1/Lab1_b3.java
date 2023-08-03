package pro192_se17a07;

import java.util.Scanner;

public class Lab1_b3 {

    public static void main(String[] args) {
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
        System.out.println("Electricity price: " + price);
    }
}
