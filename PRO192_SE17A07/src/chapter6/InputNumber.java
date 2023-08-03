package chapter6;

import java.util.Scanner;

public class InputNumber {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int number = Integer.parseInt(s);
            System.out.println(number);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Thank you");
    }
}
