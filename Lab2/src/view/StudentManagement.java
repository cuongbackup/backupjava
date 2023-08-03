package view;

import controller.School;
import java.util.ArrayList;
import model.Student;
import controller.Menu;

public class StudentManagement extends Menu<String> {

    static String[] menu = {"Add Data", "Enter Student Information", "Export Student List", "Sort - Print the list (by name)",
        "Print student in the same city", "Update - Delete", "Report Courses", "Exit"};
    ArrayList<Student> listStudent = new ArrayList<Student>();
    private School sch = new School();

    public StudentManagement() {
        super("Student Management", menu);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                sch.addData(listStudent);
                break;
            case 2:
                sch.inputStd(listStudent);
                break;
            case 3:
                sch.display(listStudent);
                break;
            case 4:
                sch.sortAndPrint(listStudent);
                break;
            case 5:
                sch.countAndPrint(listStudent);
                break;
            case 6:
                sch.updateAndDelete(listStudent);
                break;
            case 7:
                sch.report(listStudent);
                break;
            case 8:
                System.out.println("Have a nice day!");
                System.exit(0);
        }

    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.run();
    }
}
