package model;

public class Transaction {

    private String transactionId;
    private String cardId;
    private String transactionDate;
    private double money;
    private String note;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Transaction(String transactionId, String cardId, String transactionDate, double money, String note) {
        super();
        this.transactionId = transactionId;
        this.cardId = cardId;
        this.transactionDate = transactionDate;
        this.money = money;
        this.note = note;
    }

    public Transaction() {

    }

}
