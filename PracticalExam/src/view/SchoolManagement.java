/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.School;
import model.Student;

/**
 *
 * @author Administrator
 */
public class SchoolManagement extends Menu<String>{
    
    static String[] menu = {"List all students", "Search student", "Add new student", "Sorting display", "Exit"};
    private School sc = new School();
    
    public SchoolManagement() {
        super("School Management System", menu);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                School.display(sc.getStdList());
                break;
            case 2:
                stdSearching();
                break;
            case 3:
                stdAdd();
                break;
            case 4:
                stdSorting();
                break;
            case 5:
                System.exit(0);
        }
    }
    
    private String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine();
    }
    
    private void stdSearching() {
        String[] stdSearch = {"Find by studentID", "Find by Name"};
        Menu m = new Menu("Student Searcher", stdSearch) {
            public void execute(int n) {
                ArrayList<Student> rs = null;
                switch (n) {
                    case 1:
                        String val = getValue("Enter studentID: ");
                        rs = sc.search(s1 -> s1.getId().equals(val));
                        break;
                    case 2:
                        val = getValue("Enter name: ");
                        rs = sc.search(s2 -> s2.getName().equals(val));
                        break;
                    default:
                        return;
                }
                School.display(rs);
            }
        };
                }
    
        private void stdSorting() {
        String[] stdSearch = {"Sort by studentID", "Sort by Name", "Sort by average point in descending"};
        Menu m = new Menu("Student Sorter", stdSearch) {
            public void execute(int n) {
         
                switch (n) {
                    case 1:
                        sc.sort((s1, s2) -> s1.getID().compareTo(s2.getID()));
                        break;
                    case 2:
                        sc.sort((s1, s2) -> s1.getID().compareTo(s2.getID()));
                        break;
                    case 3:
                        sortByAverage(sc);
                    default:
                        return;
                }
                School.display(rs);
            }
        };
    }
}