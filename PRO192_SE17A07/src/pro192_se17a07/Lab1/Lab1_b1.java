package pro192_se17a07.Lab1;

import java.util.Scanner;

public class Lab1_b1 {

    public static void main(String[] args) {
        float avg;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input full name: ");
        name = sc.nextLine();
        sc = new Scanner(System.in);
        do {
            System.out.println("Input average score: ");
            avg = sc.nextFloat(); //Khi input so thuc phai dung dau phay, vd: 6,7
        } while ((avg < 0) || (avg > 10));
        System.out.println("<<Full name: " + name + ">> " + "<<Average score: " + avg + ">>");
    }
}
