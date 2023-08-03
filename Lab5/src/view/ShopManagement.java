package view;

import controller.Shop;
import java.util.ArrayList;
import model.Fruit;
import controller.Menu;
import java.io.IOException;
import java.util.Hashtable;
import model.Order;

public class ShopManagement extends Menu<String> {

    static String[] menu = {"Input fruit list from file", "Create Fruit", "View orders", "Shopping (for buyer)", "Exit"};
    private Shop s = new Shop();
    Hashtable<String, ArrayList<Order>> orders = new Hashtable<>();
    ArrayList<Fruit> fruit = new ArrayList<>();

    public ShopManagement() {
        super("Shop Management", menu);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                s.loadFruitFromFile(fruit);
                break;
            case 2:
                s.createFruit(fruit);
                break;
            case 3:
                s.viewOrder(orders);
                break;
            case 4:
                s.shopping(fruit, orders);
                break;
            case 5:
                    System.out.println("Have a nice day");
                    System.exit(0);
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        ShopManagement m = new ShopManagement();
        m.run();
    }
}
