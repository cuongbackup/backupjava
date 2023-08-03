package view;

import controller.Manager;
import java.text.ParseException;



public class Tester extends Menu<String> {

    static String[] menu = {"f1", "f2", "f3", "Exit"};
    private Manager m;

    public Tester() throws ParseException{
        super("Emp Management", menu);
        this.m = new Manager();
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                System.out.println("Have a nice day!");
                System.exit(0);
        }

    }

    public static void main(String[] args) throws ParseException {
        Tester m = new Tester();
        m.run();
    }
}
