package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

public class PizzaOrder {

    private final BigDecimal amount;

    public PizzaOrder(BigDecimal amount) {

        this.amount = amount;

    }

    public BigDecimal getAmount() {

        return amount;
    }

}
