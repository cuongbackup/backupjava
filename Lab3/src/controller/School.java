package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import model.Address;
import model.Biz;
import model.IT;
import model.Student;
import view.Validation;

public class School {

    Scanner sc = new Scanner(System.in);
    Validation dv = new Validation();

    public void addData(ArrayList<Student> listStudent) {
        String[] id = {"1", "2", "3", "4", "5", "6", "7", "8",
            "9", "10"};
        String[] name = {"Quoc Cuong", "Anh Tu", "Quang Nhat", "Anh Dung", "Bao Ngoc", "Anh Khoi", "Dinh Dan",
            "Anh Thu", "Minh Nhat", "Nhat Tan"};
        String[] cityAddress = {"Da Nang", "Hue", "Quang Nam", "Quang Nam", "Da Nang", "Da Nang", "Quang Nam", "Quang Nam",
            "Da Nang", "Quang Nam"};
        String[] score1 = {"3", "6", "7", "8", "9", "0", "0", "0", "0", "0"};
        String[] score2 = {"6", "7", "8", "9", "6", "0", "0", "0", "0", "0"};
        String[] score3 = {"0", "0", "0", "0", "0", "6", "9", "9", "6", "8"};
        String[] score4 = {"0", "0", "0", "0", "0", "7", "7", "6", "8", "7"};
        ArrayList<Address> listAddress = new ArrayList<Address>();
        for (int i = 0; i < 10; i++) {
            listAddress.add(new Address("Vietnam", cityAddress[i], "1"));
        }
        for (int i = 0; i < 5; i++) {
            IT st = new IT(id[i], name[i], listAddress.get(i), Double.parseDouble(score1[i]), Double.parseDouble(score2[i]));
            listStudent.add(st);
        }
        for (int i = 5; i < 10; i++) {
            Biz st = new Biz(id[i], name[i], listAddress.get(i), Double.parseDouble(score3[i]), Double.parseDouble(score4[i]));
            listStudent.add(st);
        }
        System.out.println("Data added!");
    }

    public void inputStd(ArrayList<Student> listStudent) {
        String choice;
        do {
            System.out.println("Choose faculty: IT (1) or Biz(2) ?");
            System.out.print("Your choice: ");
            choice = sc.nextLine().trim();
            if (!(choice.equals("1") || choice.equals("2"))) {
                System.out.println("Wrong input!");
            }
        } while (!(choice.equals("1") || choice.equals("2")));
        if (choice.equals("1")) {
            IT stIT = new IT();
            System.out.print("Enter student's ID: ");
            stIT.setId(sc.nextLine().trim());
            System.out.print("Enter student's name: ");
            stIT.setName(sc.nextLine().trim());
            System.out.print("Enter student's country: ");
            String country = sc.nextLine().trim();
            System.out.print("Enter student's city: ");
            String city = sc.nextLine().trim();
            System.out.print("Enter student's street: ");
            String street = sc.nextLine().trim();
            stIT.setAddress(new Address(country, city, street));
            stIT.inputStd();
            listStudent.add(stIT);
        }
        if (choice.equals("2")) {
            Biz stBiz = new Biz();
            System.out.print("Enter student's ID: ");
            stBiz.setId(sc.nextLine().trim());
            System.out.print("Enter student's name: ");
            stBiz.setName(sc.nextLine().trim());
            System.out.print("Enter student's address: ");
            stBiz.setAddress(new Address(sc.nextLine().trim()));
            stBiz.inputStd();
            listStudent.add(stBiz);
        }
    }

    public void display(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        String alignment = "| %-8s | %-20s | %-12s | %-12s | %-12s | %-5.1f | %-5.1f | %-5.1f | %-5.1f | %-5.1f\n";
        System.out
                .format("------------------------------------------------------------------------------------------%n");
        System.out
                .format("| ID       | Name                 | Street       | City         | Country      | Java  | CSS   | Acc.  | Mar.  | GPA\n");
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i) instanceof IT) {
                System.out.format(alignment, listStudent.get(i).getId(), listStudent.get(i).getName(),
                        listStudent.get(i).getAddress().getStreet(),listStudent.get(i).getAddress().getCity(),
                        listStudent.get(i).getAddress().getCountry(),((IT) listStudent.get(i)).getJavaScore(),
                        ((IT) listStudent.get(i)).getCssScore(), null, null, ((IT) listStudent.get(i)).avgScore());
            }
            if (listStudent.get(i) instanceof Biz) {
                System.out.format(alignment, listStudent.get(i).getId(), listStudent.get(i).getName(),
                        listStudent.get(i).getAddress().getStreet(),listStudent.get(i).getAddress().getCity(),
                        listStudent.get(i).getAddress().getCountry(), null, null, ((Biz) listStudent.get(i)).getAccScore(),
                        ((Biz) listStudent.get(i)).getMarScore(), ((Biz) listStudent.get(i)).avgScore());
            }
        }
        System.out
                .format("------------------------------------------------------------------------------------------%n");
    }

    public void sortAndPrint(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        Collections.sort(listStudent, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                String[] split1 = o1.getName().split(" ");
                String[] split2 = o2.getName().split(" ");
                String lastName1 = split1[1];
                String lastName2 = split2[1];
                if (lastName1.compareTo(lastName2) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }

        });
        System.out.println("List Student Sorted! ");
        display(listStudent);
    }

    public void countAndPrint(ArrayList<Student> listStudent) {
        Map<String, Long> collect = listStudent.stream().collect(Collectors.groupingBy(student -> student.getAddress().getCity().toUpperCase(), Collectors.counting()));
        System.out.println(collect);
        Map<String, ArrayList<Student>> collect1 = listStudent.stream().collect(Collectors.groupingBy(student -> student.getAddress().getCity().toUpperCase(), Collectors.toCollection(ArrayList::new)));
        for (String address : collect1.keySet()) {
            System.out.println("Address: " + address);
            ArrayList<Student> st = collect1.get(address);
            display(st);
        }
    }

    public void updateAndDelete(ArrayList<Student> listStudent) {
        String choice;
        String idKey;
        ArrayList<Student> keyStudent = new ArrayList<Student>();
        if (listStudent.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        System.out.print("Enter student's ID to find: ");
        idKey = sc.nextLine().trim();
        if (listStudent.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        for (int i = 0; i < listStudent.size(); i++) {

            if (listStudent.get(i).getId().equals(idKey)) {
                keyStudent.add(listStudent.get(i));

            } else {
                System.out.println("No student matches!");
                return;
            }
        }
        display(keyStudent);
        do {
            System.out.println("Do you want to update (U) or delete (D) ?");
            choice = sc.nextLine().trim();
            if (choice.toUpperCase().equals("U")) {
                for (int i = 0; i < listStudent.size(); i++) {
                    if (listStudent.get(i).getId().equals(idKey)) {
                        System.out.print("Update student name: ");
                        listStudent.get(i).setName(sc.nextLine().trim());
                        System.out.print("Update student address: ");
                        listStudent.get(i).setAddress(new Address(sc.nextLine().trim()));
                        if (listStudent.get(i) instanceof IT) {
                            String input;
                            do {
                                System.out.print("Update Java score: ");
                                input = sc.nextLine().trim();
                                if (!input.matches(dv.scorePattern)) {
                                    System.out.println("Wrong input!");
                                }
                            } while (!input.matches(dv.scorePattern));
                            ((IT) listStudent.get(i)).setJavaScore(Double.valueOf(input));
                            do {
                                System.out.print("Update CSS score: ");
                                input = sc.nextLine().trim();
                                if (!input.matches(dv.scorePattern)) {
                                    System.out.println("Wrong input!");
                                }
                            } while (!input.matches(dv.scorePattern));
                            ((IT) listStudent.get(i)).setCssScore(Double.valueOf(input));
                        }
                        if (listStudent.get(i) instanceof Biz) {
                            String input;
                            do {
                                System.out.print("Enter Accounting score: ");
                                input = sc.nextLine().trim();
                                if (!input.matches(dv.scorePattern)) {
                                    System.out.println("Wrong input!");
                                }
                            } while (!input.matches(dv.scorePattern));
                            ((Biz) listStudent.get(i)).setAccScore(Double.valueOf(input));
                            do {
                                System.out.print("Enter Marketing score: ");
                                input = sc.nextLine().trim();
                                if (!input.matches(dv.scorePattern)) {
                                    System.out.println("Wrong input!");
                                }
                            } while (!input.matches(dv.scorePattern));
                            ((Biz) listStudent.get(i)).setMarScore(Double.valueOf(input));
                        }
                    }
                }
                System.out.println("Student updated!");
                return;
            } else if (choice.toUpperCase().equals("D")) {
                for (int i = 0; i < listStudent.size(); i++) {
                    if (listStudent.get(i).getId().equals(idKey)) {
                        listStudent.remove(i);
                    }
                }
                System.out.println("Student removed!");
                return;
            } else {
                System.out.println("Wrong input!");
            }
        } while (!(choice.equals("U") || choice.equals("D")));

    }

    public void report(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        String alignment = "| %-8s | %-20s | %-5.1f | %-5.1f | %-5.1f | %-5.1f | %-20s\n";
        System.out
                .format("------------------------------------------------------------------------------------------%n");
        System.out
                .format("| ID       | Name                 |Java  | CSS   | Acc.  | Mar.  | Passed\n");
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i) instanceof IT) {
                System.out.format(alignment, listStudent.get(i).getId(), listStudent.get(i).getName(),
                        ((IT) listStudent.get(i)).getJavaScore(),
                        ((IT) listStudent.get(i)).getCssScore(), null, null, report1(listStudent).get(listStudent.get(i).getName()));
            }
            if (listStudent.get(i) instanceof Biz) {
                System.out.format(alignment, listStudent.get(i).getId(), listStudent.get(i).getName(),
                        null, null, ((Biz) listStudent.get(i)).getAccScore(),
                        ((Biz) listStudent.get(i)).getMarScore(), report1(listStudent).get(listStudent.get(i).getName()));
            }
        }
        System.out
                .format("------------------------------------------------------------------------------------------%n");
    }

    public Set loop(String name, ArrayList<Student> listStudent) {
        Set<String> subjects = new HashSet<String>();
        for (Student s : listStudent) {
            if (s.getName().equals(name)) {
                if (s instanceof IT) {
                    if (((IT) s).getJavaScore() >= 4) {
                        subjects.add("Java");
                    }
                    if (((IT) s).getCssScore() >= 4) {
                        subjects.add("Css");
                    }
                }
                if (s instanceof Biz) {
                    if (((Biz) s).getAccScore() >= 4) {
                        subjects.add("Accounting");
                    }
                    if (((Biz) s).getMarScore() >= 4) {
                        subjects.add("Marketing");
                    }
                }
            }
        }
        return subjects;
    }

    public Map report1(ArrayList<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("The list is empty!");
            return null;
        }
        Set<String> subjects = new HashSet<String>();
        Map<String, Set> report = new HashMap<String, Set>();
        for (Student s : listStudent) {
            report.put(s.getName(), loop(s.getName(), listStudent));
        }
        return report;
    }
}
