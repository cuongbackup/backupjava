package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Card;

public class Validation {

    static private final Scanner in = new Scanner(System.in);

    private final String DATE_VALID = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|"
            + "(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" + "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)"
            + "0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])"
            + "|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])"
            + "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    static public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public double checkInputDoubleLimit(double min, double max) {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public boolean checkInputYN() {
        System.out.print("Do you want to continue? (Y/N): ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public String checkCardIdExist(ArrayList<Card> listCard) {
        String id = null;
        id = in.nextLine().trim();
        for (Card card : listCard) {
            if (card.getCardId().equalsIgnoreCase(id)) {
                System.out.println("Id exist.");
                System.out.print("Enter again: ");
                id = checkCardIdExist(listCard);
            }
        }
        return id;
    }

    public String checkCardNumberExist(ArrayList<Card> listCard) {
        String number = null;
        number = in.nextLine().trim();
        for (Card card : listCard) {
            if (card.getCardNumber().equalsIgnoreCase(number)) {
                System.out.println("Id exist.");
                System.out.print("Enter again: ");
                number = checkCardIdExist(listCard);
            }
        }
        return number;
    }

    public boolean checkTransDay(Card c, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date release = null;
        Date trans = null;
        try {
            release = sdf.parse(c.getDateRelease());
            trans = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return release.compareTo(trans) < 0 ? true : false;
    }

    public boolean checkInputTransDay(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date root = null;
        Date trans = null;

        try {
            root = sdf.parse("01/01/1900");
            trans = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return trans.compareTo(root) < 0 ? false : true;
    }
    
        public boolean checkDateValid(Card c, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date release = null;
        Date valid = null;
        try {
            release = sdf.parse(c.getDateRelease());
            valid = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return release.compareTo(valid) < 0 ? true : false;
    }

    public String checkInputDate() {
        while (true) {
            String result = checkInputString();
            if (result.matches(DATE_VALID)) {
                return result;
            } else {
                System.err.println("Input date with format dd/mm/yyyy");
                System.out.print("Enter again: ");
            }
        }
    }

    public double checkTransCreditCard(double amountMax, double amountDue) {
        double money = checkInputDoubleLimit(0, 1000000000);
        if (amountDue + money < amountMax) {
            return money;
        } else {
            System.err.println("Card don’t enough money to payment");
            System.err.println("Transaction failed");
        }
        return 0;
    }

    public double checkTransDebitCard(double remain) {
        double money = checkInputDoubleLimit(0, 1000000000);
        if (remain > money) {
            return money;
        } else {
            System.err.println("Card don’t enough money to payment");
            System.err.println("Transaction failed");
        }
        return 0;
    }

    public double checkTransATMCard(double remain) {
        double money = checkInputDoubleLimit(0, 1000000000);
        if (remain > money) {
            return money;
        } else {
            System.err.println("Card don’t enough money to payment");
            System.err.println("Transaction failed");
        }
        return 0;
    }
}
