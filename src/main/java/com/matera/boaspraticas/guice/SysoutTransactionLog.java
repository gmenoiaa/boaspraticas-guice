package com.matera.boaspraticas.guice;

import com.google.inject.Singleton;

@Singleton
public class SysoutTransactionLog implements TransactionLog {

    @Override
    public void logChargeResult(ChargeResult result) {

        System.out.println("Transaction "
            + (result.wasSuccessful() ? "successful" : "declined with message " + result.getDeclineMessage()));
    }

    @Override
    public void logConnectException(Exception e) {

        System.out.println("Error processing with message " + e.getMessage());
    }

}
