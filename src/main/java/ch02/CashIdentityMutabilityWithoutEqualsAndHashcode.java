package ch02;

public class CashIdentityMutabilityWithoutEqualsAndHashcode {
    private int dollars;

    public CashIdentityMutabilityWithoutEqualsAndHashcode(int dollars) {
        this.dollars = dollars;
    }

    public void mul(int factor){
        this.dollars*=factor;
    }
}
