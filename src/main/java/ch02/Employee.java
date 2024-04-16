package ch02;

import java.util.ArrayList;

public class Employee {
    private Cash_INF cash;

    public Employee(Cash_INF cash) {
        this.cash = cash;
    }

    public int toCents() {
        return cash.cents();
    }
}
