package com.matera.boaspraticas.guice;

import java.math.BigDecimal;

public class Receipt {

    private final String message;

    private Receipt(String message) {

        this.message = message;
    }

    public static Receipt forSuccessfulCharge(BigDecimal amount) {

        return new Receipt("Successful charged $" + amount);
    }

    public static Receipt forDeclinedCharge(String declineMessage) {

        return new Receipt("Payment declined due " + declineMessage);
    }

    public static Receipt forSystemFailure(String message) {

        return new Receipt("Payment not processed due " + message);
    }

    public String getMessage() {

        return message;
    }

}
