package ch02;

public class CashThreadSafe {
    private int dollars;
    private int cents;

    public CashThreadSafe(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public void mul(int factor) {
        this.dollars *= factor;
        this.cents *= factor;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public String toString() {
        return "CashThreadSafe{" +
                "dollars=" + dollars +
                ", cents=" + cents +
                '}';
    }
}
