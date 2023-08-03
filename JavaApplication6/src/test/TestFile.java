package test;

import IO.ReadFile;
import IO.ReadFile2;
import IO.SaveFile;
import IO.SerializeFileIO;
import java.util.ArrayList;
import model.Student;

public class TestFile {

    public static void main(String[] args) {
        ArrayList<Student> stdList = new ArrayList<Student>();
        stdList.add(new Student("a", 18, "sup", 8));
        stdList.add(new Student("b", 23, "bruh", 9));
        boolean kq = SerializeFileIO.saveFile(stdList, "D:\\student.txt");
        if (kq == true) {
            System.out.println("Luu file thanh cong");
        }
        else {
            System.out.println("Luu file that bai");
        }
        stdList = ReadFile2.readFile2("D:\\Student.txt");
        stdList.forEach(s -> System.out.println(s));
    }
}
