package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

public interface CreditCardProcessor {

	ChargeResult charge(CreditCard creditCard, BigDecimal amount);

}
