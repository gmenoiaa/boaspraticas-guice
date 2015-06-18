package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

    @Override
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {

        // Do some process at PayPal and return
        return new ChargeResult(true, null);
    }
}
