package view;

import java.util.ArrayList;

import controller.Menu;
import controller.BankManager;
import model.ATMCard;
import model.Card;
import model.CreditCard;
import model.DebitCard;
import model.Transaction;

public class BankManagement extends Menu<String> {

    static String[] options = {"Load card and transactions from file", "Display cards", "Input card",
        "Transfer", "Display transactions", "Exit"};
    private BankManager b = new BankManager();

    ArrayList<Card> listCard = new ArrayList<Card>();
    ArrayList<Transaction> listTrans = new ArrayList<Transaction>();

    public BankManagement() {
        super("Bank Management", options);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                b.readCardFromFile(listCard);
                b.readTransFromFile(listTrans);
                break;
            case 2:
                b.sortFile(listCard);
                b.display(listCard);
                break;
            case 3:
                b.inputCard(listCard);
                break;
            case 4:
                b.transfer(listCard, listTrans);
                break;
            case 5:
                b.displayTransaction(listTrans);
                break;
            case 6:
                System.out.println("Have a nice day!");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        BankManagement main = new BankManagement();
        main.run();

    }
}
