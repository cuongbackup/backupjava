package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Dev;
import model.Leader;
import model.Management;
import model.NhanVien;

public class Manager {

    private ArrayList<NhanVien> listnv;
    String path = Paths.get("").toAbsolutePath().toString();
    SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

    public Manager() throws ParseException {
        listnv = new ArrayList<>();
        loadData(path + "/src/model/employee.txt");
    }

    public void loadData(String fName) throws ParseException {
        String name = null;
        try {
            FileInputStream fis = new FileInputStream(fName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(",");
                if (line.charAt(0) == '1') {
                    Management m = new Management(Integer.parseInt(arr[0]), arr[1], arr[2], convert(df.parse(arr[3])), 0, 0,
                            0, Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), 0);
                    listnv.add(m);
                }
                if (line.charAt(0) == '2') {
                    Leader l = new Leader(Integer.parseInt(arr[0]), arr[1], arr[2], convert(df.parse(arr[3])), 0, 0,
                            0, Integer.parseInt(arr[7]), Integer.parseInt(arr[8]), 0);
                    listnv.add(l);
                }
                if (line.charAt(0) == '3') {
                    Dev d = new Dev(Integer.parseInt(arr[0]), arr[1], arr[2], convert(df.parse(arr[3])), 0, 0,
                            0, Integer.parseInt(arr[7]), 0);
                    listnv.add(d);
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

    public Calendar convert(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}

//    public void display() {
//        SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
//        System.out.println("\nManagement: ");
//        String alignment1 = "| %-8d | %-20s | %-20s | %-10s | %-20d | %-12d\n";
//        System.out
//                .format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
//        for (int i = 0; i < listnv.size(); i++) {
//            if (listnv.get(i) instanceof Management) {
//                System.out.format(alignment1, listnv.get(i).getRole(), listnv.get(i).getEmpID(),
//                        listnv.get(i).getAccount(), formatter.format(listnv.get(i).getWorkStartingDate()),
//                        ((Management) listnv.get(i)).getResolveIssueNumber(), ((Management) listnv.get(i)).getOtherTaskNumber());
//            }
//        }
//        System.out.println("\nLeader: ");
//        String alignment2 = "| %-8d | %-20s | %-20s | %-10s | %-20d | %-12d\n";
//        System.out
//                .format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
//        System.out
//                .format("| ID       | First Name           | Last Name            | Birth date | Address              | Phone        | Email                  | Grad date | Grad rank | Grad school\n");
//        for (int i = 0; i < listnv.size(); i++) {
//            if (listnv.get(i) instanceof DebitCard) {
//                System.out.format(alignment2, listnv.get(i).getCardID(), listnv.get(i).getCardNumber(),
//                        formatter.format(listnv.get(i).getDateRelease()),
//                        ((DebitCard) listnv.get(i)).getDateValid(), ((DebitCard) listnv.get(i)).getAmountRemain());
//            }
//        }
//        System.out.println("\nAtm card: ");
//        String alignment3 = "| %-8s | %-20s | %-20s | %-10d | %-20s | %-12s | %-22s | %-8s | %-8s | %-13s\n";
//        System.out
//                .format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
//        System.out
//                .format("| ID       | First Name           | Last Name            | Birth date | Address              | Phone        | Email                  | Major    | Semester | AtmCard school\n");
//        for (int i = 0; i < listnv.size(); i++) {
//            if (listnv.get(i) instanceof AtmCard) {
//                System.out.format(alignment3, listnv.get(i).getCardID(), listnv.get(i).getCardNumber(),
//                        formatter.format(listnv.get(i).getDateRelease()),
//                        ((AtmCard) listnv.get(i)).getAmount());
//            }
//        }
//    }
//}
