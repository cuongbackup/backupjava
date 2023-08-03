package model;

import java.util.ArrayList;

public class ATMCard extends Card {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ATMCard() {
        super();
    }

    public ATMCard(String cardId, String cardNumber, String dateRelease, String cardType, double amount) {
        super(cardId, cardNumber, dateRelease, cardType);
        this.amount = amount;
    }

    public String toString() {
        return "3, " + this.getCardId() + ", " + this.getCardNumber() + ", " + this.getDateRelease() + ", "
                + this.getCardType() + ", " + this.getAmount();
    }

    @Override
    public void showMe() {
        System.out.println("+------------------------------------------+");
        System.out.format("| Card ID : %-30s |%n", this.getCardId());
        System.out.format("| Card number : %-26s |%n", this.getCardNumber());
        System.out.format("| Date release : %-25s |%n", this.getDateRelease());
        System.out.format("| Card type : %-28s |%n", this.getCardType());
        System.out.format("| Amount : %-31.2f |%n", this.getAmount());
        System.out.format("|                                          |%n");
        System.out.format("|                                          |%n");
        System.out.println("+------------------------------------------+");
        System.out.println();

    }

    public void display(ArrayList<Card> listCard) {
        String alignment = "| %-10s | %-15s | %-12s | %-12s | %-13.2f |%n";
        System.out.println("+------------+-----------------+--------------+--------------+---------------+");
        System.out.println("| Card ID    | Card Number     | Date Release | Card Type    | Amount        |");
        System.out.println("+------------+-----------------+--------------+--------------+---------------+");
        for (int i = 0; i < listCard.size(); i++) {
            if (listCard.get(i) instanceof ATMCard) {
                System.out.format(alignment, listCard.get(i).getCardId(), listCard.get(i).getCardNumber(),
                        listCard.get(i).getDateRelease(), listCard.get(i).getCardType(),
                        ((ATMCard) listCard.get(i)).getAmount());
            }
        }
        System.out.println("+------------+-----------------+--------------+--------------+---------------+");
    }
}
