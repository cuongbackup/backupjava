package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class School {

    private ArrayList<Student> stdList;

    public School() {
        stdList = new ArrayList<>();
        String path = Paths.get("").toAbsolutePath().toString();
        loadData(path + "/src/model/sch.txt");
    }

    public void loadData(String fName) {
                String student = "";
        try {
            FileInputStream fis = new FileInputStream(fName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = student.split(":");
                if (arr.length == 3) {
                    Student s = new Student(arr[0], arr[1], Integer.parseInt(arr[2]));
                    stdList.add(s);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("Data failed to load!");
        }
    }

    public ArrayList<Student> search(Predicate<Student> p) {
        ArrayList<Student> rs = new ArrayList<>();
        for (Student s : stdList) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
    }

    public ArrayList<Student> getStdList() {
        return stdList;
    }

    public void setBookList(ArrayList<Student> stdList) {
        this.stdList = stdList;
    }

    public static void display(ArrayList<Student> ls) {
        System.out.println("List of students\n--------------------");
        for (Student s : ls) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        System.out.println("Total: " + ls.size() + "students");
    }

    public ArrayList<Student> sortByAverage(Predicate<Student> p) {
        ArrayList<Student> sc = new ArrayList<>();
        sc.sort((Student t1, Student t2) -> {
            return Double.compare(t1.getAverage(), t2.getAverage());
        });
        return sc;
    }
}
