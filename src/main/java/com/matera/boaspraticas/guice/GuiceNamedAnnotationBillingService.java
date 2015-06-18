package com.matera.boaspraticas.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class GuiceNamedAnnotationBillingService implements BillingService {

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public GuiceNamedAnnotationBillingService(@Named("Checkout") CreditCardProcessor processor, TransactionLog transactionLog) {

        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {

        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful() ? Receipt.forSuccessfulCharge(order.getAmount()) : Receipt
                .forDeclinedCharge(result.getDeclineMessage());
        } catch (Exception e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}
