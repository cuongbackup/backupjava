package DTO;

import java.util.Scanner;

public class Item {

    private int value;
    private String creator;

    public Item() {

    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input value: ");
        value = sc.nextInt();
        sc = new Scanner(System.in);
        do {
            System.out.println("Input creator: ");
            creator = sc.nextLine();
        } while (creator == "");
    }

    public void output() {
        System.out.println("Value: " + (value));
        System.out.println("Creator: " + (creator));
    }
}
