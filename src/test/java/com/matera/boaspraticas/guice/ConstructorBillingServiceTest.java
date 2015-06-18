package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.matera.boaspraticas.guice.BillingService;
import com.matera.boaspraticas.guice.ConstructorBillingService;
import com.matera.boaspraticas.guice.CreditCard;
import com.matera.boaspraticas.guice.PizzaOrder;
import com.matera.boaspraticas.guice.Receipt;

public class ConstructorBillingServiceTest {

    private final PizzaOrder order = new PizzaOrder(BigDecimal.TEN);
    private final CreditCard card = new CreditCard("1234", 11, 2010);

    @Test
    public void testSuccessful() {

        BillingService billingService = new ConstructorBillingService();
        Receipt receipt = billingService.chargeOrder(order, card);

        Assert.assertEquals("Successful charged $10", receipt.getMessage());
    }

}
