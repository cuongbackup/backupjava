/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Fastfood {

    private int id;
    private String name;
    private String type;
    private float price;
    private int amount;

    public Fastfood() {

    }

    public Fastfood(int id, String name, String type, float price, int amount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public Fastfood(String name, String type, float price, int amount) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fastfood{" + "id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", amount=" + amount + '}';
    }

    
}
