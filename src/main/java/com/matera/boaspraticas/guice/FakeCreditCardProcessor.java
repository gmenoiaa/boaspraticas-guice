package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

public class FakeCreditCardProcessor implements CreditCardProcessor {

    private final ChargeResult result;

    private FakeCreditCardProcessor(ChargeResult result) {

        this.result = result;
    }

    public static FakeCreditCardProcessor successful() {

        return new FakeCreditCardProcessor(new ChargeResult(true, null));
    }

    public static FakeCreditCardProcessor denied(String deniedMessage) {

        return new FakeCreditCardProcessor(new ChargeResult(false, deniedMessage));
    }

    @Override
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {

        return result;
    }

}
