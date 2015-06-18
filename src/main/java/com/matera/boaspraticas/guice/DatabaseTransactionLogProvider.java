package com.matera.boaspraticas.guice;

import com.google.inject.Provider;

public class DatabaseTransactionLogProvider implements Provider<TransactionLog> {

    public TransactionLog get() {

        return new DatabaseTransactionLog();
    }
}
