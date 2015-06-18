package com.matera.boaspraticas.guice;

public class DependencyInjectionMain {

    public static void main(String[] args) {

        CreditCardProcessor processor = new PaypalCreditCardProcessor();
        TransactionLog transactionLog = new DatabaseTransactionLog();
        BillingService billingService = new DependencyInjectionBillingService(processor, transactionLog);
        // ...

    }
}
