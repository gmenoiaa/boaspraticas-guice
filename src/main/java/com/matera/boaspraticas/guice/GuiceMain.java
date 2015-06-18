package com.matera.boaspraticas.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class GuiceMain {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {

                //bind(TransactionLog.class).to(DatabaseTransactionLog.class);
                bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);

                bind(MySqlDatabaseTransactionLog.class).toProvider(new Provider<MySqlDatabaseTransactionLog>() {

                    @Override
                    public MySqlDatabaseTransactionLog get() {

                        return new MySqlDatabaseTransactionLog();
                    }
                });

                bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
                bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PaypalCreditCardProcessor.class);
                bind(CreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(
                    CheckoutCreditCardProcessor.class);

                bind(String.class).annotatedWith(Names.named("JDBC URL")).toInstance("jdbc:mysql://localhost/pizza");

                //bind(GuiceBillingService.class);
                //bind(GuiceBillingService.class).in(Singleton.class);
                
                // bind(TransactionLog.class).to(SysoutTransactionLog.class).in(Singleton.class);
                
                bind(TransactionLog.class).to(SysoutTransactionLog.class).asEagerSingleton();
                
            }

            /*
             * @Provides TransactionLog provideTransactionLog() {
             * DatabaseTransactionLog transactionLog = new
             * DatabaseTransactionLog();
             * transactionLog.setJdbcUrl("jdbc:mysql://localhost/pizza");
             * transactionLog.setThreadPoolSize(30); return transactionLog; }
             */
        });

        BillingService billingService = injector.getInstance(GuiceBillingService.class);

    }
}
