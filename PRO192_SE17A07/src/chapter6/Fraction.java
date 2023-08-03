package chapter6;

public class Fraction {

    int tuso;
    int mauso;

    public Fraction(int tuso, int mauso) throws FractionException {
        if (mauso == 0) {
            throw new FractionException("Mau so = 0");
        }
        this.tuso = tuso;
        this.mauso = mauso;
    }

    @Override
    public String toString() {
        return tuso + "/" + mauso;
    }

}
