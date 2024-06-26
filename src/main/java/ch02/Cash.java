package ch02;

import ch02.mock08.NYSE;

import java.util.Objects;

public class Cash {
    private Integer digits;
    private Integer cents;
    private String currency;

    public Cash(Integer digits, Integer cents, String currency) {
        this.digits = digits;
        this.cents = cents;
        this.currency = currency;
    }

    public Cash plus(Cash cash){
        return new Cash(
          this.digits+cash.digits,
          this.cents+cash.cents,
          this.currency
        );
    }

    public Cash mul(final int mul){
        return new Cash(
                this.digits*mul,
                this.cents*mul,
                this.currency
        );
    }

    public Integer getDigits() {
        return digits;
    }

    public Integer getCents() {
        return cents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return Objects.equals(digits, cash.digits) && Objects.equals(cents, cash.cents) && Objects.equals(currency, cash.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digits, cents, currency);
    }
}
