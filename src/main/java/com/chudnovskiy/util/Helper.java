package com.chudnovskiy.util;

public class Helper {
    public static void timeSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
