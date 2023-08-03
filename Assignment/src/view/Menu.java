package view;

import java.io.*;
import java.util.*;
import model.*;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private File dataFile = null;
    private FileOutputStream fileOutput;
    private OutputStreamWriter outputStream;
    private PrintWriter theWriter;
    private Exceptions check = new Exceptions();
    private String choiceList[] = {"Nhap thong tin sinh vien", "Cap nhat danh sach sinh vien bang MaSV", "In danh sach sinh vien",
        "Xuat TOP 5 sinh vien", "Tim sinh vien bang dia chi", "Xoa sinh vien bang MaSV",
        "Sap xep danh sach theo ho ten", "Liet ke danh sach sinh vien trong khoang diem TB", "Luu danh sach sinh vien vao file",
        "Doc danh sach sinh vien tu file"};
    private int choice, innerChoice = -1, numOfStudent, ITCnt = 0, bizCnt = 0;
    private String test;
    private final char ESC = 'e';

    public Menu() {

    }

    public void printMenu() {
        System.out.println("===================================================================");
        System.out.println("Chuong trinh quan li sinh vien");
        for (int i = 0; i < choiceList.length; i++) {
            System.out.println("\t\t\t[" + (i + 1) + "] " + choiceList[i]);
        }
        System.out.println("===================================================================");
    }


    public String input() {
        return input.nextLine();
    }

    public void setChoice() {
        do {
            System.out.print("Nhap lua chon: ");
            test = input();
            choice = Integer.parseInt(test);
        } while (choice < 1 || choice > 10);
    }

    public int getChoice() {
        return choice;
    }

   

    public void printData(ArrayList<SinhVien> sinhvienList, int noOfprint) {
        printInfo(sinhvienList, ITCnt, bizCnt, noOfprint);
    }

    private void printInfo(ArrayList<SinhVien> list, int ITCnt, int bizCnt, int noStudent) {
        
        if (ITCnt > 0) {
            System.out.println("\t\t\t<Sinh vien IT>");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof SVIT) {
                    exportInfo(list.get(i));
                }
            }
        }
        if (bizCnt > 0) {
            System.out.println("\t\t\t<Sinh vien Biz>");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof SVBiz) {
                    exportInfo(list.get(i));
                }
            }
        }
    }

    private void exportInfo(SinhVien s) {
        System.out.print("Ho va ten: " + s.getHoTen());
        System.out.print(", Ma SV: " + s.getMaSV());
        System.out.print(", Email: " + s.getEmail());
        System.out.print(", Dia chi: " + s.getDiaChi());
        if (s instanceof SVIT) {
            System.out.printf(", Diem Java: %.2f", ((SVIT) s).getDiemJava());
            System.out.printf(", Diem Css: %.2f", ((SVIT) s).getDiemCss());
            System.out.printf(", Diem trung binh IT: %.2f\n", s.getDiemTB());
        if (s instanceof SVBiz) {
            System.out.printf(", Diem Accounting: %.2f", ((SVBiz) s).getDiemKeToan());
            System.out.printf(", Diem Marketting: %.2f", ((SVBiz) s).getDiemMarketting());
            System.out.printf(", Diem trung binh Bussiness: %.2f\n", s.getDiemTB());
        }
        }
    }

    public void inputStudentInfo(ArrayList<SinhVien> sinhvienList) {
        System.out.print("So luong sinh vien: ");
        do {
            test = input();
            numOfStudent = Integer.parseInt(test);
            if (numOfStudent <= 0) {
                System.err.println("So luong sinh vien phai lon hon hoac bang 0");
                System.out.print("Vui long nhap lai: ");
            }
        } while (numOfStudent <= 0);
        for (int i = 0; (i < numOfStudent) && (test.charAt(0) != ESC); i++) {
            System.out.println("\t\t[0]: Sinh vien IT\t\t[1]Sinh vien Biz");
            do {
                System.out.print("Chon nganh cua sinh vien [0/1]: ");
                test = input();
                innerChoice = Integer.parseInt(test);
            } while (innerChoice < 0 || innerChoice > 2);
            if (innerChoice == 0) {
                ITCnt++;
            } else if (innerChoice == 1){
                bizCnt++;
            } else {
                ITCnt++;
                bizCnt++;
            }
            System.out.println("Sinh vien " + (i + 1));
            inputStudentInfo(sinhvienList, innerChoice);
            if ((i >= 1 && i != numOfStudent - 1) && (numOfStudent > 2)) {
                System.out.print("Nhan 'E' de tro ve: ");
                do {
                    test = input();
                } while (check.checkNull(test) == 0);
            }
        }
    }

    /**
     * @param list
     * @param majorID
     */
    private void inputStudentInfo(ArrayList<SinhVien> list, int majorID) {
        SinhVien sinhvien;
        SinhVien sinhvien1 = null;
        String grade;
        if (majorID == 0) {
            sinhvien = new SVIT();
        } else if (majorID == 1){
            sinhvien = new SVBiz();
        } else {
            sinhvien = new SVIT();
            sinhvien1 = new SVBiz();
        }
        System.out.print("Nhap ten sinh vien: ");
        test = input();
        sinhvien.setHoTen(test);
        sinhvien1.setHoTen(test);
        System.out.print("Nhap ma SV: ");
        test = input();
        sinhvien.setMaSV(test);
        sinhvien1.setMaSV(test);
        System.out.print("Nhap Email: ");
        test = input();
        sinhvien.setEmail(test);
        sinhvien1.setEmail(test);
        System.out.print("Nhap dia chi: ");
        sinhvien.setDiaChi(input().trim());
        sinhvien1.setDiaChi(input().trim());
        System.out.println("Nhap diem: ");
        if (majorID == 0) {
            System.out.print("Java: ");
        } else {
            System.out.print("Accounting: ");
        }
        do {
            grade = input();
        } while (check.checkGrade(grade) == 0);
        if (majorID == 0) {
            ((SVIT) sinhvien).setDiemJava(Double.parseDouble(grade));
        } else {
            ((SVBiz) sinhvien).setDiemKeToan(Double.parseDouble(grade));
        }

        if (majorID == 0) {
            System.out.print("Css: ");
        } else {
            System.out.print("Marketting: ");
        }
        do {
            grade = input();
        } while (check.checkGrade(grade) == 0);
        if (majorID == 0) {
            ((SVIT) sinhvien).setDiemCss(Double.parseDouble(grade));
        } else {
            ((SVBiz) sinhvien).setDiemMarketting(Double.parseDouble(grade));
        }
        //add to list
        list.add(sinhvien);
    }

    /**
     * @param sinhvienList
     */
    public void updateWithMaSV(ArrayList<SinhVien> sinhvienList) {
        for (int i = 0; i < sinhvienList.size(); i++) {
            System.out.println("[" + sinhvienList.get(i).getMaSV() + "] " + sinhvienList.get(i).getHoTen());
        }
        System.out.print("Nhap ma SV: ");
        test = input();
        if (updateStudentInfo(sinhvienList, test) == 1) {
            System.out.println("Cap nhat thanh cong");
        } else {
            System.out.println("Cap nhat that bai");
        }
    }

    private int updateStudentInfo(ArrayList<SinhVien> list, String mssv) {
        int updatePos = -1;
        boolean isStop = false;
        mssv = mssv.toLowerCase();
        String cmpMSSV;
        for (int i = 0; i < list.size(); i++) {
            cmpMSSV = list.get(i).getMaSV().toLowerCase();
            if (cmpMSSV.compareTo(mssv) == 0) {
                updatePos = i;
            }
        }
        if (updatePos == -1) {
            System.out.println("Khong tim thay sinh vien");
            return 0;
        }
        while (isStop == false) {
            boolean majorID = list.get(updatePos) instanceof SVIT;
            int choice;
            String[] fieldList1 = {"Ho ten", "Email", "Dia chi", "Diem Java", "Diem Css", "Thoat"};
            String[] fieldList2 = {"Ho Ten", "Email", "Dia chi", "Diem Accounting", "Diem Marketting", "Thoat"};
            if (majorID) {
                for (int i = 0; i < fieldList1.length; i++) {
                    System.out.println("[" + (i + 1) + "] " + fieldList1[i]);
                }
            } //If majorID is not SVIT
            else {
                for (int i = 0; i < fieldList2.length; i++) {
                    System.out.println("[" + (i + 1) + "] " + fieldList2[i]);
                }
            }

            do {
                System.out.print("Chon muc can cap nhat: ");
                test = input();

                choice = (int) Double.parseDouble(test);
                if ((double) choice != Double.parseDouble(test)) {
                    choice = 0;
                }
            } while (choice < 1 || choice > 6);
            if (choice == 6) {
                isStop = true;
            }
            boolean[] updatePart = {false, false, false, false, false};
            for (int i = 1; i < 6; i++) {
                if (i == choice) {
                    updatePart[i - 1] = true;
                }
            }
            update(list, list.get(updatePos), majorID, updatePart[0], updatePart[1], updatePart[2], updatePart[3], updatePart[4]);
        }
        return 1;
    }

    private void update(ArrayList<SinhVien> list, SinhVien sinhvien, boolean majorID, boolean updateName, boolean updateEmail, boolean updateDiaChi, boolean updateGrade1, boolean updateGrade2) {
        String grade;
        if (updateName) {
            System.out.println("Ten sinh vien can cap nhat: " + sinhvien.getHoTen());
            System.out.print("Ten moi: ");
            test = input();
            sinhvien.setHoTen(test);
        }
        if (updateEmail) {
            System.out.println("Email can cap nhat: " + sinhvien.getEmail());
            System.out.print("Email moi: ");
            test = input();

            sinhvien.setEmail(test);
        }
        if (updateDiaChi) {
            System.out.println("Dia chi can cap nhat: " + sinhvien.getDiaChi());
            System.out.print("Dia chi moi: ");
            test = input();
            sinhvien.setDiaChi(test);
        }
        if (updateGrade1) {
            if (majorID) {
                System.out.println("Diem Java cu: " + ((SVIT) sinhvien).getDiemJava());
                System.out.print("Diem Java moi: ");
            } else {
                System.out.println("Diem Accounting cu: " + ((SVBiz) sinhvien).getDiemKeToan());
                System.out.print("Diem Accounting moi: ");
            }
            do {
                grade = input();
            } while (check.checkGrade(grade) == 0);
            if (majorID) {
                ((SVIT) sinhvien).setDiemJava(Double.parseDouble(grade));
            } else {
                ((SVBiz) sinhvien).setDiemKeToan(Integer.parseInt(grade));
            }
        }
        if (updateGrade2) {
            if (majorID) {
                System.out.println("Diem Css cu: " + ((SVIT) sinhvien).getDiemCss());
                System.out.print("Diem Css moi: ");
            } else {
                System.out.println("Diem Marketting cu: " + ((SVBiz) sinhvien).getDiemMarketting());
                System.out.print("Diem Marketting gmoi: ");
            }
            do {
                grade = input();
            } while (check.checkGrade(grade) == 0);
            if (majorID) {
                ((SVIT) sinhvien).setDiemCss(Double.parseDouble(grade));
            } else {
                ((SVBiz) sinhvien).setDiemMarketting(Double.parseDouble(grade));
            }
        }
    }

    public int removeByMSSV(ArrayList<SinhVien> sinhvienList) {
        {
            for (int i = 0; i < sinhvienList.size(); i++) {
                System.out.println("[" + sinhvienList.get(i).getMaSV() + "] " + sinhvienList.get(i).getHoTen());
            }
            System.out.print("Nhap ma SV: ");
            test = input();
            int majorID = removeByMSSV(sinhvienList, test);
            if (majorID == 1) {
                ITCnt--;
                System.out.println("Xoa thanh cong");
                return 0;
            }
            if (majorID == 2) {
                bizCnt--;
                System.out.println("Xoa thanh cong");
                return 0;
            } else {
                System.out.println("Khong tim thay sinh vien");
            }
            return 0;
        }
    }

    private int removeByMSSV(ArrayList<SinhVien> list, String mssv) {
        int updatePos = -1, ret;
        mssv = mssv.toLowerCase();
        String compMSSV;
        for (int i = 0; i < list.size(); i++) {
            compMSSV = list.get(i).getMaSV().toLowerCase();
            if (compMSSV.compareTo(mssv) == 0) {
                updatePos = i;
            }
        }
        if (updatePos == -1) {
            return 0;
        }
        if (list.get(updatePos) instanceof SVIT) {
            ret = 1;
        } else {
            ret = 2;
        }
        list.remove(updatePos);
        return ret;
    }

    public void sortByDiemTB(ArrayList<SinhVien> list) {
        list.sort((sinhvien1, sinhvien2) -> {
            return -(sinhvien1).compareDiemTB(sinhvien2);
        });
    }

    public void sortByHoTen(ArrayList<SinhVien> list) {
        list.sort((sinhvien1, sinhvien2) -> {
            return sinhvien1.compareTo(sinhvien2);
        });
    }

    public void findByDiaChi(ArrayList<SinhVien> sinhvienList) {

        System.out.print("Nhap dia chi: ");
        test = input();

        if (findByDiaChi(sinhvienList, test) == 0) {
            System.out.println("Khong tim thay sinh vien");
        }
    }

    private int findByDiaChi(ArrayList<SinhVien> list, String address) {
        int pos = -1;
        address = address.trim().toLowerCase();
        String compDiaChi;
        for (int i = 0; i < list.size(); i++) {
            compDiaChi = list.get(i).getDiaChi().toLowerCase();
            if (compDiaChi.compareTo(address) == 0) {
                pos = i;
            }
        }
        if (pos == -1) {
            return 0;
        }
        int innerchoice;
        System.out.println("Tim thay sinh vien: " + list.get(pos).getHoTen());
        System.out.println("Xem thong tin chi tiet? [1] dong y, [0] khong dong y");
        do {
            System.out.println("Ban chon: ");
            test = input();
            innerchoice = Integer.parseInt(test);
        } while (innerchoice < 0 || innerchoice > 1);
        if (innerchoice == 1) {
            exportInfo(list.get(pos));
        }
        return 1;
    }
}