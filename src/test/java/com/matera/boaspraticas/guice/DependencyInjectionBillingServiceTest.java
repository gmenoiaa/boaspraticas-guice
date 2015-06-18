package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.matera.boaspraticas.guice.BillingService;
import com.matera.boaspraticas.guice.CreditCard;
import com.matera.boaspraticas.guice.CreditCardProcessor;
import com.matera.boaspraticas.guice.DependencyInjectionBillingService;
import com.matera.boaspraticas.guice.FakeCreditCardProcessor;
import com.matera.boaspraticas.guice.PizzaOrder;
import com.matera.boaspraticas.guice.Receipt;
import com.matera.boaspraticas.guice.SysoutTransactionLog;
import com.matera.boaspraticas.guice.TransactionLog;

public class DependencyInjectionBillingServiceTest {

    private final PizzaOrder order = new PizzaOrder(BigDecimal.TEN);
    private final CreditCard card = new CreditCard("1234", 11, 2010);

    private final TransactionLog transactionLog = new SysoutTransactionLog();
    private final CreditCardProcessor processorSuccess = FakeCreditCardProcessor.successful();
    private final CreditCardProcessor processorDenied = FakeCreditCardProcessor.denied("some deny message");

    @Test
    public void testSuccessfulCharge() {

        BillingService billingService = new DependencyInjectionBillingService(processorSuccess, transactionLog);
        Receipt receipt = billingService.chargeOrder(order, card);

        Assert.assertEquals("Successful charged $10", receipt.getMessage());
    }

    @Test
    public void testDeniedCharge() {

        BillingService billingService = new DependencyInjectionBillingService(processorDenied, transactionLog);
        Receipt receipt = billingService.chargeOrder(order, card);

        Assert.assertEquals("Payment declined due some deny message", receipt.getMessage());
    }
}
