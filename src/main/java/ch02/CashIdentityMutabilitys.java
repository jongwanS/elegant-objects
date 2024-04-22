package ch02;


import java.util.List;


public class CashIdentityMutabilitys {
    private final List<CashIdentityMutability> cashIdentityMutability;

    public CashIdentityMutabilitys(List<CashIdentityMutability> cashIdentityMutability) {
        this.cashIdentityMutability = cashIdentityMutability;
    }

    public List<CashIdentityMutability> getCashIdentityMutability() {
        return cashIdentityMutability;
    }
}
