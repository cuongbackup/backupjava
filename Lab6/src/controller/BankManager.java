package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.ATMCard;
import model.Card;
import model.CreditCard;
import model.DebitCard;
import model.Transaction;
import view.Validation;

public class BankManager {

    Validation dv = new Validation();

    CreditCard cre = new CreditCard();
    DebitCard deb = new DebitCard();
    ATMCard atm = new ATMCard();
    private ArrayList<Card> card;
    private ArrayList<Transaction> trans;

    public void readCardFromFile(ArrayList<Card> listCard) {
        String path = Paths.get("").toAbsolutePath().toString() + "\\src\\card.txt";
        File file = new File(path);
        String[] card = new String[200];
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                card = sc.nextLine().split(",");
                switch (Integer.parseInt(card[0])) {
                    case 1:
                        listCard.add(new CreditCard(card[1], card[2], card[3], card[4], card[5],
                                Double.parseDouble(card[6]), Double.parseDouble(card[7])));
                        break;
                    case 2:
                        listCard.add(
                                new DebitCard(card[1], card[2], card[3], card[4], card[5], Double.parseDouble(card[6])));
                        break;
                    case 3:
                        listCard.add(new ATMCard(card[1], card[2], card[3], card[4], Double.parseDouble(card[5])));
                        break;
                }
            }
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Data failed to load!");
        }
    }

    public void readTransFromFile(ArrayList<Transaction> listTrans) {
        String path = Paths.get("").toAbsolutePath().toString() + "\\src\\transaction.txt";
        File file = new File(path);
        String[] trans = new String[200];
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                trans = sc.nextLine().split(",");
                listTrans.add(new Transaction(trans[0], trans[1], trans[2], Double.parseDouble(trans[3]), trans[4]));
            }
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Data failed to load!");
        }
    }

    void saveCardToFile(ArrayList<Card> cardList) {
        try {
            String pathCard = Paths.get("").toAbsolutePath().toString() + "\\src\\card.txt";
            FileOutputStream fos = new FileOutputStream(pathCard);
            OutputStreamWriter osr = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osr);
            for (Card c : cardList) {
                String line = null;
                if (c instanceof CreditCard) {
                    line = 1 + "," + c.getCardId() + "," + c.getCardNumber() + "," + c.getDateRelease() + "," + c.getCardType() + ","
                            + ((CreditCard) c).getDateValid() + "," + ((CreditCard) c).getAmountDue() + "," + ((CreditCard) c).getAmountMax();
                }
                if (c instanceof DebitCard) {
                    line = 2 + "," + c.getCardId() + "," + c.getCardNumber() + "," + c.getDateRelease() + "," + c.getCardType() + ","
                            + ((DebitCard) c).getDateValid() + "," + ((DebitCard) c).getAmountRemain();
                }
                if (c instanceof ATMCard) {
                    line = 3 + "," + c.getCardId() + "," + c.getCardNumber() + "," + c.getDateRelease() + "," + c.getCardType() + ","
                            + ((ATMCard) c).getAmount();
                }
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osr.close();
            fos.close();
            System.out.println("File saved successfully!");
        } catch (IOException e) {
            System.out.println("Data failed to save!");
        }
    }

    void saveTransToFile(ArrayList<Transaction> tList) {
        try {
            String pathTrans = Paths.get("").toAbsolutePath().toString() + "\\src\\transaction.txt";
            FileOutputStream fos = new FileOutputStream(pathTrans);
            OutputStreamWriter osr = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osr);
            for (Transaction t : tList) {
                String line = t.getTransactionId() + "," + t.getCardId() + "," + t.getTransactionDate() + "," + t.getMoney() + "," + t.getNote();
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

    public void display(ArrayList<Card> listCard) {
        System.out.println("Credit Card list:");
        cre.display(listCard);
        System.out.println("Debit Card list:");
        deb.display(listCard);
        System.out.println("ATM Card list:");
        atm.display(listCard);
    }

    public void inputCard(ArrayList<Card> listCard) {
        while (true) {
            System.out.println("What type of card to create ? (1 = Credit card, 2 = Debit card, 3 = ATM card)");
            Scanner sc = new Scanner(System.in);
            switch (dv.checkInputIntLimit(1, 3)) {
                case 1:
                    CreditCard c = new CreditCard();
                    System.out.print("Enter card ID: ");
                    c.setCardId(dv.checkCardIdExist(listCard));
                    System.out.print("Enter card number: ");
                    c.setCardNumber(dv.checkCardNumberExist(listCard));
                    System.out.print("Enter date release: ");
                    c.setDateRelease(dv.checkInputDate());
                    c.setCardType("CreditCard");
                    System.out.print("Enter date valid: ");
                    String dateValid = "";
                    while (true) {
                        dateValid = dv.checkInputDate();
                        if (dv.checkDateValid(c, dateValid)) {
                            c.setDateValid(dateValid);
                            break;
                        } else {
                            System.out.println("Must be lower than release date");
                            System.out.print("Enter date valid: ");
                        }
                    }
                    c.setAmountDue(0);
                    System.out.print("Enter amount max: ");
                    c.setAmountMax(dv.checkInputDoubleLimit(1, 1000000000));
                    listCard.add(c);
                    break;
                case 2:
                    DebitCard d = new DebitCard();
                    System.out.print("Enter card ID: ");
                    d.setCardId(dv.checkCardIdExist(listCard));
                    System.out.print("Enter card number: ");
                    d.setCardNumber(dv.checkCardNumberExist(listCard));
                    System.out.print("Enter date release: ");
                    d.setDateRelease(dv.checkInputDate());
                    d.setCardType("DebitCard");
                    System.out.print("Enter date valid: ");
                    dateValid = "";
                    while (true) {
                        dateValid = dv.checkInputDate();
                        if (dv.checkDateValid(d, dateValid)) {
                            d.setDateValid(dateValid);
                            break;
                        } else {
                            System.out.println("Must be lower than release date");
                            System.out.print("Enter date valid: ");
                        }
                    }
                    System.out.print("Enter amount remain: ");
                    d.setAmountRemain(dv.checkInputDoubleLimit(1, 1000000000));
                    listCard.add(d);
                    break;
                case 3:
                    ATMCard a = new ATMCard();
                    System.out.print("Enter card ID: ");
                    a.setCardId(dv.checkCardIdExist(listCard));
                    System.out.print("Enter card number: ");
                    a.setCardNumber(dv.checkCardNumberExist(listCard));
                    System.out.print("Enter date release: ");
                    a.setDateRelease(dv.checkInputDate());
                    a.setCardType("ATMCard");
                    System.out.print("Enter amount: ");
                    a.setAmount(dv.checkInputDoubleLimit(1, 1000000000));
                    listCard.add(a);
                    break;
            }
            if (!dv.checkInputYN()) {
                saveCardToFile(listCard);
                return;
            }
        }
    }

    public void sortFile(ArrayList<Card> listCard) {
        Collections.sort(listCard, new Comparator<Card>() {
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(Card o1, Card o2) {
                try {
                    if (f.parse(o1.getDateRelease()).equals(f.parse(o2.getDateRelease()))) {
                        return o1.getCardId().compareTo(o2.getCardId());
                    } else {
                        return f.parse(o1.getDateRelease()).compareTo(f.parse(o2.getDateRelease()));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }

        });
    }

    public void transfer(ArrayList<Card> card, ArrayList<Transaction> trans) {
        if (card.isEmpty()) {
            System.err.println("There are no cards yet.");
            return;
        }
        while (true) {
            display(card);
            System.out.println("What type of card to transfer ? (1 = Credit card, 2 = Debit card, 3 = ATM card)");
            int item = dv.checkInputIntLimit(1, 3);
            switch (item) {
                case 1: {
                    System.out.print("Enter transaction ID: ");
                    String tranID = dv.checkInputString();
                    System.out.print("Enter card ID: ");
                    String id = dv.checkInputString();
                    boolean check = false;
                    for (int i = 0; i < card.size(); i++) {
                        if (card.get(i) instanceof CreditCard && card.get(i).getCardId().equals(id)) {
                            check = true;
                            CreditCard cr = (CreditCard) card.get(i);
                            System.out.print("Enter transaction date: ");
                            String date = dv.checkInputDate();
                            if (!dv.checkInputTransDay(date) || !dv.checkTransDay(cr, date)) {
                                System.err.println("TransactionDateException");
                                System.err.println("Transaction failed");
                                break;
                            }
                            System.out.print("Transfer amount: ");
                            double money = dv.checkTransCreditCard(cr.getAmountMax(), cr.getAmountDue());
                            if (money == 0) {
                                break;
                            }
                            System.out.print("Transfer note: ");
                            String note = dv.checkInputString();
                            cr.setAmountDue(cr.getAmountDue() + money);
                            cr.showMe();
                            trans.add(new Transaction(tranID, id, date, money, note));
                            saveCardToFile(card);
                            break;
                        }
                    }
                    if (check == false) {
                        System.out.println("Card does not exist");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter transaction ID: ");
                    String tranID = dv.checkInputString();
                    System.out.print("Enter card ID: ");
                    String id = dv.checkInputString();
                    boolean check = false;
                    for (int i = 0; i < card.size(); i++) {
                        if (card.get(i) instanceof DebitCard && id.equals(card.get(i).getCardId())) {
                            check = true;
                            DebitCard dc = (DebitCard) card.get(i);
                            System.out.print("Enter transaction date: ");
                            String date = dv.checkInputDate();
                            if (!dv.checkInputTransDay(date) || !dv.checkTransDay(dc, date)) {
                                System.err.println("TransactionDateException");
                                System.err.println("Transaction failed");
                                break;
                            }
                            System.out.print("Transfer amount: ");
                            double money = dv.checkTransDebitCard(dc.getAmountRemain());
                            if (money == 0) {
                                break;
                            }
                            System.out.print("Transfer note: ");
                            String note = dv.checkInputString();
                            dc.setAmountRemain(dc.getAmountRemain() - money);
                            dc.showMe();
                            trans.add(new Transaction(tranID, id, date, money, note));
                            saveCardToFile(card);
                            break;
                        }
                    }
                    if (check == false) {
                        System.out.println("Card does not exist");
                        break;
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter transaction ID: ");
                    String tranID = dv.checkInputString();
                    System.out.print("Enter card ID: ");
                    String id = dv.checkInputString();
                    boolean check = false;
                    for (int i = 0; i < card.size(); i++) {
                        if (card.get(i) instanceof ATMCard && id.equals(card.get(i).getCardId())) {
                            check = true;
                            ATMCard atm = (ATMCard) card.get(i);
                            System.out.print("Enter transaction date: ");
                            String date = dv.checkInputDate();
                            if (!dv.checkInputTransDay(date) || !dv.checkTransDay(atm, date)) {
                                System.err.println("TransactionDateException");
                                System.err.println("Transaction failed");
                                break;
                            }
                            System.out.print("Transfer amount: ");
                            double money = dv.checkTransATMCard(atm.getAmount());
                            if (money == 0) {
                                break;
                            }
                            System.out.print("Transfer note: ");
                            String note = dv.checkInputString();
                            atm.setAmount(atm.getAmount() - money);
                            atm.showMe();
                            trans.add(new Transaction(tranID, id, date, money, note));
                            saveCardToFile(card);
                            break;
                        }
                    }
                    if (check == false) {
                        System.out.println("Card does not exist");
                        break;
                    }
                    break;
                }
            }
            if (!dv.checkInputYN()) {
                saveTransToFile(trans);
                return;
            }
        }
    }

    public void displayTransaction(ArrayList<Transaction> trans) {
        String alignment = "| %-17s | %-15s | %-16s | %-12f | %-20s | %n";
        System.out.println("+------------+-----------------+--------------+--------------+---------------+");
        System.out.println("| Transaction ID    | Card Number     | Transaction Date | Money         | Note                 |");
        System.out.println("+------------+-----------------+--------------+--------------+---------------+");
        for (int i = 0; i < trans.size(); i++) {
            System.out.format(alignment, trans.get(i).getTransactionId(), trans.get(i).getCardId(),
                    trans.get(i).getTransactionDate(), trans.get(i).getMoney(),
                    trans.get(i).getNote());

        }
        System.out.println("+------------+-----------------+--------------+--------------+---------------+");
    }
    
        public void printTop3(ArrayList<Transaction> trans) {
        Map<String, ArrayList<Transaction>> collect = trans.stream().collect(Collectors.groupingBy(transaction
                -> transaction.getTransactionId(), Collectors.toCollection(ArrayList::new)));
        for (String id : collect.keySet()) {
            ArrayList<Transaction> tran = collect.get(id);
            double sum = 0;
            for(Transaction t: tran) {
            sum = sum + t.getMoney();
        }
            
    }
}
}
