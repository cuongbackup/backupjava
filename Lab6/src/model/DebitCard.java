package model;

import java.util.ArrayList;

public class DebitCard extends Card {

	private String dateValid;
	private double amountRemain;

	public String getDateValid() {
		return dateValid;
	}

	public void setDateValid(String dateValid) {
		this.dateValid = dateValid;
	}

	public double getAmountRemain() {
		return amountRemain;
	}

	public void setAmountRemain(double amountRemain) {
		this.amountRemain = amountRemain;
	}

	public DebitCard() {

	}

	public DebitCard(String cardId, String cardNumber, String dateRelease, String cardType, String dateValid,
			double amountRemain) {
		super(cardId, cardNumber, dateRelease, cardType);
		this.dateValid = dateValid;
		this.amountRemain = amountRemain;
	}

	public String toString() {
		return "2, " + this.getCardId() + ", " + this.getCardNumber() + ", " + this.getDateRelease() + ", "
				+ this.getCardType() + ", " + this.getDateValid() + ", " + this.getAmountRemain();
	}
        
        
	@Override
	public void showMe() {
		System.out.println("+------------------------------------------+");
		System.out.format("| Card ID : %-30s |%n", this.getCardId());
		System.out.format("| Card number : %-26s |%n", this.getCardNumber());
		System.out.format("| Date release : %-25s |%n", this.getDateRelease());
		System.out.format("| Card type : %-28s |%n", this.getCardType());
		System.out.format("| Date valid : %-27s |%n", this.getDateValid());
		System.out.format("| Amount Remain : %-24.2f |%n", this.getAmountRemain());
		System.out.format("|                                          |%n");
		System.out.println("+------------------------------------------+");
		System.out.println();
	}

	public void display(ArrayList<Card> listCard) {
		String alignment = "| %-10s | %-15s | %-12s | %-12s | %-12s | %-13.2f |%n";
		System.out.println(
				"+------------+-----------------+--------------+--------------+--------------+---------------+");
		System.out.println(
				"| Card ID    | Card Number     | Date Release | Card Type    | Date valid   | Amount Remain |");
		System.out.println(
				"+------------+-----------------+--------------+--------------+--------------+---------------+");
		for (int i = 0; i < listCard.size(); i++) {
			if (listCard.get(i) instanceof DebitCard) {
				System.out.format(alignment, listCard.get(i).getCardId(), listCard.get(i).getCardNumber(),
						listCard.get(i).getDateRelease(), listCard.get(i).getCardType(),
						((DebitCard) listCard.get(i)).getDateValid(), ((DebitCard) listCard.get(i)).getAmountRemain());
			}
		}
		System.out.println(
				"+------------+-----------------+--------------+--------------+--------------+---------------+");
	}
}
