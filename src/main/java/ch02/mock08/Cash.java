package ch02.mock08;

import java.util.Objects;

public class Cash {
    private final Exchange exchange;
    private final int cents;

    public Cash(Exchange exchange, int cents) {
        this.exchange = exchange;
        this.cents = cents;
    }

    public Cash in(String currency) {
        return new Cash(
                this.exchange,
                (int) (this.cents * this.exchange.rate("USD", currency))
        );
    }

    public Cash in() {
        return new Cash(
                this.exchange,
                (int) (this.cents * this.exchange.rate("USD"))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return cents == cash.cents && Objects.equals(exchange, cash.exchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchange, cents);
    }

    public int getCents() {
        return cents;
    }
}