package model;

import java.util.ArrayList;

public class CreditCard extends Card {

    private String dateValid;
    private double amountDue;
    private double amountMax;

    public String getDateValid() {
        return dateValid;
    }

    public void setDateValid(String dateValid) {
        this.dateValid = dateValid;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public double getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(double amountMax) {
        this.amountMax = amountMax;
    }

    public CreditCard() {

    }

    public CreditCard(String cardId, String cardNumber, String dateRelease, String cardType, String dateValid,
            double amountDue, double amountMax) {
        super(cardId, cardNumber, dateRelease, cardType);
        this.dateValid = dateValid;
        this.amountDue = amountDue;
        this.amountMax = amountMax;
    }

    @Override
    public String toString() {
        return "1, " + this.getCardId() + ", " + this.getCardNumber() + ", " + this.getDateRelease() + ", "
                + this.getDateValid() + ", " + this.getAmountDue() + ", " + this.getAmountMax();
    }

    @Override
    public void showMe() {
        System.out.println("+------------------------------------------+");
        System.out.format("| Card ID : %-30s |%n", this.getCardId());
        System.out.format("| Card number : %-26s |%n", this.getCardNumber());
        System.out.format("| Date release : %-25s |%n", this.getDateRelease());
        System.out.format("| Card type : %-28s |%n", this.getCardType());
        System.out.format("| Date valid : %-27s |%n", this.getDateValid());
        System.out.format("| Amount Due : %-27.2f |%n", this.getAmountDue());
        System.out.format("| Amount Max : %-27.2f |%n", this.getAmountMax());
        System.out.println("+------------------------------------------+");
        System.out.println();
    }

    public void display(ArrayList<Card> listCard) {
        String alignment = "| %-10s | %-15s | %-12s | %-12s | %-12s | %-10.2f | %-10.2f |%n";
        System.out.println(
                "+------------+-----------------+--------------+--------------+--------------+------------+------------+");
        System.out.println(
                "| Card ID    | Card Number     | Date Release | Card Type    | Date valid   | Amount Due | Amount Max |");
        System.out.println(
                "+------------+-----------------+--------------+--------------+--------------+------------+------------+");
        for (int i = 0; i < listCard.size(); i++) {
            if (listCard.get(i) instanceof CreditCard) {
                System.out.format(alignment, listCard.get(i).getCardId(), listCard.get(i).getCardNumber(),
                        listCard.get(i).getDateRelease(), listCard.get(i).getCardType(),
                        ((CreditCard) listCard.get(i)).getDateValid(), ((CreditCard) listCard.get(i)).getAmountDue(),
                        ((CreditCard) listCard.get(i)).getAmountMax());
            }
        }
        System.out.println(
                "+------------+-----------------+--------------+--------------+--------------+------------+------------+");
    }
}
