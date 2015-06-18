package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.matera.boaspraticas.guice.BillingService;
import com.matera.boaspraticas.guice.ConstructorBillingService;
import com.matera.boaspraticas.guice.CreditCard;
import com.matera.boaspraticas.guice.CreditCardProcessor;
import com.matera.boaspraticas.guice.CreditCardProcessorFactory;
import com.matera.boaspraticas.guice.FakeCreditCardProcessor;
import com.matera.boaspraticas.guice.PizzaOrder;
import com.matera.boaspraticas.guice.Receipt;
import com.matera.boaspraticas.guice.SysoutTransactionLog;
import com.matera.boaspraticas.guice.TransactionLog;
import com.matera.boaspraticas.guice.TransactionLogFactory;

public class FactoryBillingServiceTest {

    private final PizzaOrder order = new PizzaOrder(BigDecimal.TEN);
    private final CreditCard card = new CreditCard("1234", 11, 2010);

    private final TransactionLog transactionLog = new SysoutTransactionLog();
    private final CreditCardProcessor processor = FakeCreditCardProcessor.successful();

    @Before
    public void setup() {

        TransactionLogFactory.setInstance(transactionLog);
        CreditCardProcessorFactory.setInstance(processor);
    }

    @After
    public void tearDown() {

        TransactionLogFactory.setInstance(null);
        CreditCardProcessorFactory.setInstance(null);
    }

    @Test
    public void testSuccessfulCharge() {

        BillingService billingService = new ConstructorBillingService();
        Receipt receipt = billingService.chargeOrder(order, card);

        Assert.assertEquals("Successful charged $10", receipt.getMessage());
    }

}
