package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exceptions {

    Scanner sc = new Scanner(System.in);

    public Exceptions() {

    }

    public int checkNull(String test) {
        if (test.length() == 0) {
            System.err.println("Khong the rong");
            System.out.print("Moi nhap lai: ");
            return 0;
        } else {
            return 1;
        }
    }

    public int checkGrade(String grade) {
        double grade2 = Double.parseDouble(grade);
        if (grade2 >= 0.0d && grade2 <= 10.0d) {
            return 1;
        }
        System.err.println("Diem phai trong khoang [0,10]");
        System.out.print("Moi nhap lai: ");
        return 0;
    }
}
