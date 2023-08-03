package IO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.Student;

public class SaveFile {
    public static boolean saveFile(ArrayList<Student> stdList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osr = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osr);
            for (Student t : stdList) {
                String line = t.getName() + ";" + t.getAge() + ";" + t.getAddress() + ";" + t.getGpa();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osr.close();
            fos.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
