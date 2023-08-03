package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import view.Menu;

public class Library extends Menu {

    private ArrayList<Book> stdList = new ArrayList<Book>();
    Scanner sc = new Scanner(System.in);

    public void readData() throws IOException {
        try {
            if (stdList.isEmpty() == false) {
                stdList.removeAll(stdList);
            }
            FileInputStream fis = new FileInputStream("D:\\test\\lib.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(":");
                if (arr.length == 4) {
                    Book b = new Book(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
                    stdList.add(b);
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

    public void searchBook() {
        String menuName = "Find";
        String[] options = {"Find by BookID", "Find by Title", "Find by Author", "Find by Year of publishing"};
        String id, title, author;
        int year;
        int counter = 0;
        int choice = execute(menuName, options);
        switch (choice) {
            case 1:
                System.out.println("Enter BookID: ");
                id = sc.nextLine();
                System.out.println("---------------");
                for (int i = 0; i < stdList.size(); i++) {
                    if (id.equals(stdList.get(i).getBookID())) {
                        counter++;
                        System.out.println(stdList.get(i));
                    }
                }
                System.out.println("---------------");
                System.out.println("Total: " + counter + " book(s)");
                break;
            case 2:
                System.out.println("Enter Title to find: ");
                title = sc.nextLine();
                System.out.println("---------------");
                for (int i = 0; i < stdList.size(); i++) {
                    if (title.equals(stdList.get(i).getBookTitle())) {
                        counter++;
                        System.out.println(stdList.get(i));
                    }
                }
                System.out.println("---------------");
                System.out.println("Total: " + counter + " book(s)");
                break;
            case 3:
                System.out.println("Enter Author to find: ");
                author = sc.nextLine();
                System.out.println("---------------");
                for (int i = 0; i < stdList.size(); i++) {
                    if (author.equals(stdList.get(i).getAuthor())) {
                        counter++;
                        System.out.println(stdList.get(i));
                    }

                }
                System.out.println("---------------");
                System.out.println("Total: " + counter + " book(s)");
                break;
            case 4:
                System.out.println("Enter Year of publishing to find: ");
                year = sc.nextInt();
                System.out.println("---------------");
                for (int i = 0; i < stdList.size(); i++) {
                    if (year == stdList.get(i).getYear()) {
                        counter++;
                        System.out.println(stdList.get(i));
                    }
                }
                System.out.println("---------------");
                System.out.println("Total: " + counter + " book(s)");
                break;
        }
    }

    public void printData() {
        for (Book b : stdList) {
            System.out.println(b);
        }
    }

    public void consoleInput() {
        System.out.println("Enter BookID: ");
        String id = sc.nextLine();
        System.out.println("Enter Title: ");
        String title = sc.nextLine();
        System.out.println("Enter Author: ");
        String author = sc.nextLine();
        System.out.println("Enter Year of publishing: ");
        int year = Integer.valueOf(sc.nextLine());
        Book book = new Book(id, title, author, year);
        stdList.add(book);
    }

    @Override
    public int execute(String menuName, Object[] options) {
        int choice = getSeleted();
        return choice;    
    }
}
