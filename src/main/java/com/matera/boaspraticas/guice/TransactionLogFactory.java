package com.matera.boaspraticas.guice;

public class TransactionLogFactory {

    private static TransactionLog instance;

    public static void setInstance(TransactionLog processor) {

        instance = processor;
    }

    public static TransactionLog getInstance() {

        if (instance == null) {
            return new DatabaseTransactionLog();
        }

        return instance;
    }
}
