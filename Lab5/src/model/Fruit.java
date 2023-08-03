package model;

public class Fruit {

    private String id;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {

    }

    public Fruit(String id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
@Override
	public String toString() {
		return "Fruit ID: " + this.id + " Fruit name: " + this.name + " Price: " + this.price + "$ Quantity: "
				+ this.quantity + " Origin: " + this.origin;
	}
}
