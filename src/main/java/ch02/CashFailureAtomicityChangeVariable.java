package ch02;


public class CashFailureAtomicityChangeVariable {
    private int dollars;
    private int cents;

    public CashFailureAtomicityChangeVariable(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public void mul(int factor) {
        this.dollars *= factor;
        if (1 == 1) {
            throw new RuntimeException("oops...");
        }
        this.cents *= factor;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }
}
