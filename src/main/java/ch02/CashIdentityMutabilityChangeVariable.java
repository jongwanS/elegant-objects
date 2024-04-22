package ch02;

import java.util.Objects;

public class CashIdentityMutabilityChangeVariable {
    private int dollars;

    public CashIdentityMutabilityChangeVariable(int dollars) {
        this.dollars = dollars;
    }

    public void mul(int factor){
        this.dollars*=factor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashIdentityMutabilityChangeVariable that = (CashIdentityMutabilityChangeVariable) o;
        return dollars == that.dollars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dollars);
    }
}
