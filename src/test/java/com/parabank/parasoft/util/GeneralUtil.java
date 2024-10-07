package com.parabank.parasoft.util;

public class GeneralUtil {
    public static final int WAIT_TIME = 30;

    public static void waitForSee() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
