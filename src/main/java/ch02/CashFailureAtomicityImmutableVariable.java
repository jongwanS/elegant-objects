package ch02;

public class CashFailureAtomicityImmutableVariable {
    private final int dollars;
    private final int cents;

    public CashFailureAtomicityImmutableVariable(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public CashFailureAtomicityImmutableVariable mul(int factor) {
        if (1 == 1) {
            throw new RuntimeException("oops...");
        }
        return new CashFailureAtomicityImmutableVariable(
                this.dollars * factor,
                this.cents * factor
        );
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }
}
