package controller;

import java.util.ArrayList;
import java.util.Scanner;
import view.Validation;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> choice;

    public Menu() {

    }

    public Menu(String td, String[] mc) {
        title = td;
        choice = new ArrayList<>();
        for (String s : mc) {
            choice.add((T) s);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("---------------------------------");
        for (int i = 0; i < choice.size(); i++) {
            System.out.println((i + 1) + ". " + choice.get(i));
        }
        System.out.println("---------------------------------");
    }

    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter selection: ");
            int c = Validation.checkInputIntLimit(1, 5);
            return c;
        }
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > choice.size()) {
                break;
            }

        }
    }
}
