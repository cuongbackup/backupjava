package model;

public abstract class Card {

    private String cardId;
    private String cardNumber;
    private String dateRelease;
    private String cardType;

    public Card() {

    }

    public Card(String cardId, String cardNumber, String dateRelease, String cardType) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.dateRelease = dateRelease;
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public abstract void showMe();
}
