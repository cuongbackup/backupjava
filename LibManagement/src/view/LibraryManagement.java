package view;

import java.io.IOException;
import java.util.Scanner;

import model.Library;

public class LibraryManagement extends Menu<String> {

    public static void main(String[] args) {
        Library lib = new Library();
        int choice;
        String mainMenuName = "Library Management";
        String[] options1 = {"List all books", "Search book", "Add new Book", "Exit"};
        do {
            choice = execute(mainMenuName, options1);
            switch (choice) {
                case 1:
                    lib.printData();
                    break;
                case 2:
                    lib.searchBook();
                    break;
                case 3:
                    String st =("Add book");
                    String[] op2 = {"Add new Book from file", "Add new Book from console"};
                    int op = execute(st, op2);
                    switch (op) {
                        case 1:
			       try {
                            lib.readData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                        case 2:
                            lib.consoleInput();
                            break;
                    }
                    break;
            }
        } while ((choice < 4) && (choice > 0));
    }

    @Override
    public int execute(String menuName, Object[] options) {
        int choice = getSeleted();
        return choice;
    }
}
