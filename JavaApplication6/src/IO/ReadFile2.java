package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import model.Student;

public class ReadFile2 {
    public static ArrayList<Student> readFile2(String path) {
        ArrayList<Student> stdList = new ArrayList<Student>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oos = new ObjectInputStream(fis);

            oos.close();
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return stdList;
    }
}
       
