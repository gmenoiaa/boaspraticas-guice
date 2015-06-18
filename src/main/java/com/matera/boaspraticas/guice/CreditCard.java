package com.matera.boaspraticas.guice;

public class CreditCard {

    private final String last4digits;
    private final int month;
    private final int year;

    public CreditCard(String last4digits, int month, int year) {

        this.last4digits = last4digits;
        this.month = month;
        this.year = year;
    }

    public String getLast4digits() {

        return last4digits;
    }

    public int getMonth() {

        return month;
    }

    public int getYear() {

        return year;
    }
}
