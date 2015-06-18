package com.matera.boaspraticas.guice;

public class ChargeResult {

    private boolean successful;
    private String declineMessage;

    public ChargeResult(boolean successful, String declineMessage) {

        this.successful = successful;
        this.declineMessage = declineMessage;
    }

    public boolean wasSuccessful() {

        return successful;
    }

    public String getDeclineMessage() {

        return declineMessage;
    }

}
