package pro192_se17a07.Lab1;

import java.util.Scanner;

public class Lab1_b2 {

    public static void main(String[] args) {
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
        System.out.println("Rectangle's minor sides: " + minorSides);
    }
}
