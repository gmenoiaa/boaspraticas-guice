package com.matera.boaspraticas.guice;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {

    protected void configure() {

        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(GuiceBillingService.class);
    };
}
