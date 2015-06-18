package com.matera.boaspraticas.guice;

public interface BillingService {
	
	Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
