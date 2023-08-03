package chapter6;

public class TestFraction {

    public static void main(String[] args) {
        try {
            Fraction f1 = new Fraction(1, 2);
            System.out.println(f1);
            Fraction f2 = new Fraction(1, 0);
        } catch (FractionException e) {
            e.printStackTrace();
        }

    }
}
