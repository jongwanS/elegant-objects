package ch02;

import java.util.Objects;

public class CashIdentityMutability {
    private final int dollars;

    public CashIdentityMutability(int dollars) {
        this.dollars = dollars;
    }

    public CashIdentityMutability mul(int factor){
        return new CashIdentityMutability(this.dollars*factor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashIdentityMutability that = (CashIdentityMutability) o;
        return dollars == that.dollars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dollars);
    }
}
