package com.matera.boaspraticas.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GuiceProvidersBillingService implements BillingService {

    private final CreditCardProcessor processor;
    private final Provider<TransactionLog> transactionLog;

    @Inject
    public GuiceProvidersBillingService(CreditCardProcessor processor, Provider<TransactionLog> transactionLog) {

        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {

        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.get().logChargeResult(result);

            return result.wasSuccessful() ? Receipt.forSuccessfulCharge(order.getAmount()) : Receipt
                .forDeclinedCharge(result.getDeclineMessage());
        } catch (Exception e) {
            transactionLog.get().logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}
