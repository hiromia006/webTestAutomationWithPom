package com.parabank.parasoft.util;

public class General {
    final public static int WAIT_TIME = 30;

    public static void waitForDomStable(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
