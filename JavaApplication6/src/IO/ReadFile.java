package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.Student;

public class ReadFile {
    public static ArrayList<Student> readFile(String path) {
        ArrayList<Student> stdList = new ArrayList<Student>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(";");
                if (arr.length == 4) {
                    Student s = new Student(arr[0], Integer.parseInt(arr[1]), arr[2], Float.parseFloat(arr[3]));
                    stdList.add(s);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stdList;
    }
}
       
