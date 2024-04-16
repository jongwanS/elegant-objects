package ch02;

public class CashWithoutEqualsAndHashCode {
    private Integer digits;
    private Integer cents;
    private String currency;

    public CashWithoutEqualsAndHashCode(Integer digits, Integer cents, String currency) {
        this.digits = digits;
        this.cents = cents;
        this.currency = currency;
    }
}
