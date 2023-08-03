package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.jar.Pack200;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Fruit;
import model.Order;
import view.Validation;

public class Shop {

    public void saveOrderToFile(Hashtable<String, ArrayList<Order>> order) throws IOException {
        String path = Paths.get("").toAbsolutePath().toString() + "\\src\\model\\order.txt";
        FileOutputStream fos = new FileOutputStream(path, true);
        String line = "\n";
        String attribute = "Customer = [Fruit ID - Fruit Name - Quantity - Price]";
        fos.write(attribute.getBytes());
        fos.write(line.getBytes());
        fos.write(order.toString().getBytes());
        fos.write(line.getBytes());
        fos.write(line.getBytes());
        fos.flush();
        fos.close();
        System.out.println("Save file successfully!");
    }

    public void saveFruitToFile(ArrayList<Fruit> listFruit) throws IOException {
        String path = Paths.get("").toAbsolutePath().toString() + "\\src\\model\\fruit.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osr = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osr);
            for (Fruit f : listFruit) {
                String line = f.getId() + ":" + f.getName() + ":" + f.getPrice() + ":" + f.getQuantity() + ":" + f.getOrigin();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osr.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Data failed to save!");
        }
    }

    public void loadFruitFromFile(ArrayList<Fruit> listFruit) {
        String path = Paths.get("").toAbsolutePath().toString() + "\\src\\model\\fruit.txt";
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(":");
                if (arr.length == 5) {
                    Fruit f = new Fruit(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4]);
                    listFruit.add(f);
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

    public void createFruit(ArrayList<Fruit> fruit) {
        while (true) {
            System.out.print("Enter fruit id: ");
            String id = Validation.checkInputString();
            if (!Validation.checkIdExist(fruit, id)) {
                System.err.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String name = Validation.checkInputString();
            System.out.print("Enter fruit price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter fruit quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter fruit origin: ");
            String origin = Validation.checkInputString();
            Fruit f = new Fruit(id, name, price, quantity, origin);
            fruit.add(f);
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public void viewOrder(Hashtable<String, ArrayList<Order>> orders) {
        if (orders.isEmpty()) {
            System.out.println("There are no orders");
            return;
        }
        for (String name : orders.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> order = orders.get(name);
            printOrder(order);
        }
    }

    public void shopping(ArrayList<Fruit> fruit, Hashtable<String, ArrayList<Order>> orders) {
        if (fruit.isEmpty()) {
            System.err.println("There are no fruits to buy.");
            return;
        }
        ArrayList<Order> order = new ArrayList<>();
        while (true) {
            printShop(fruit);
            System.out.print("Enter item number: ");
            int item = Validation.checkInputIntLimit(1, fruit.size());
            Fruit fruits = getFruitByItem(fruit, item - 1);
            if (fruits.getQuantity() == 0) {
                System.out.println("Out of order");
                if (!Validation.checkInputYN()) {
                    break;
                }
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruits.getQuantity());
            fruits.setQuantity(fruits.getQuantity() - quantity);
            if (Validation.checkItemExist(order, fruits.getId())) {
                updateOrder(fruits.getId(), quantity, order);
            } else {
                order.add(new Order(fruits.getId(), fruits.getName(),
                        quantity, fruits.getPrice()));
            }
            if (!Validation.checkInputYN()) {
                break;
            }
        }
        printOrder(order);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        orders.put(name, order);
        try {
            saveFruitToFile(fruit);
        } catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            saveOrderToFile(orders);
        } catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Add successfully");
    }

    public Fruit getFruitByItem(ArrayList<Fruit> fruit, int item) {
        int i = 0;
        for (Fruit fruits : fruit) {
            if (i == item) {
                return fruits;
            }
            i++;
        }
        return null;
    }

    public void updateOrder(String id, int quantity, ArrayList<Order> privateOrders) {
        for (Order orders : privateOrders) {
            if (orders.getId().equalsIgnoreCase(id)) {
                orders.setQuantity(orders.getQuantity() + quantity);
                return;
            }
        }
    }

    public void printShop(ArrayList<Fruit> fruit) {
        System.out.println("List of fruit: ");
        String alignment = "| %-13s | %-19s | %-12s | %-21.0f\n";
        String alignment1 = "| %-13s | %-19s | %-11s | %-21s\n";
        System.out
                .format("------------------------------------------------------------------------------------------%n");
        System.out
                .format(alignment1, "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
        for (int i = 0; i < fruit.size(); i++) {
            System.out.format(alignment, fruit.get(i).getId(), fruit.get(i).getName(), fruit.get(i).getOrigin(), fruit.get(i).getPrice());
        }
    }

    public void printOrder(ArrayList<Order> order) {
        double total = 0;
        System.out.println("List of order: ");
        String alignment = "| %-13s | %-19d | %-11.0f | %-21.0f\n";
        String alignment1 = "| %-13s | %-19s | %-11s | %-21s\n";
        System.out
                .format("------------------------------------------------------------------------------------------%n");
        System.out
                .format(alignment1, "++ Product ++", "++ Quantity ++", "++ Price ++", "++ Amount ++");
        for (int i = 0; i < order.size(); i++) {
            double a = order.get(i).getPrice() * order.get(i).getQuantity();
            System.out.format(alignment, order.get(i).getName(), order.get(i).getQuantity(), order.get(i).getPrice(), a);
            total += a;
        }
        System.out.println("Total: " + total);
    }
}
