package com.matera.boaspraticas.guice;

public class DatabaseTransactionLog implements TransactionLog {

    @Override
    public void logChargeResult(ChargeResult result) {

        // Log into a database table
    }

    @Override
    public void logConnectException(Exception e) {

        // Log into a database table
    }

    public void setJdbcUrl(String string) {

        // TODO Auto-generated method stub

    }

    public void setThreadPoolSize(int i) {

        // TODO Auto-generated method stub

    }

    public void setConnection(Connection connection) {

        // TODO Auto-generated method stub

    }

}
