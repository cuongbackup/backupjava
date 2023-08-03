package DTO;

import java.util.Scanner;

public class Statue extends Item {

    private int weight;
    private String colour;

    public Statue() {

    }

    public Statue(int value, String creator, int weight, String colour) {
        super(value, creator);
        this.weight = weight;
        this.colour= colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void inputStatue() {
        Scanner sc = new Scanner(System.in);
        input();
        sc = new Scanner(System.in);
        System.out.println("Input weight: ");
        weight = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Input colour: ");
        colour = sc.nextLine();
    }
    
    public void outputStatue() {
        output();
        System.out.println("Weight: " + (weight));
        System.out.println("Colour: " + (colour) + "\n");
    }
}
