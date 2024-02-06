package com.ykb.architecture.testservices.utilities;

import io.appium.java_client.AppiumDriver;


public class ThreadLocalDriver {
    private static final ThreadLocal<AppiumDriver> tlDriver = new ThreadLocal<>();
    private static final ThreadLocal<String> tlOs = new ThreadLocal<>();

    public static synchronized void setTLDriver(AppiumDriver driver, String os) {
        tlDriver.set(driver);
        tlOs.set(os);
    }

    public static synchronized AppiumDriver getTLDriver() {
        return tlDriver.get();
    }

    public static synchronized String getTlOs() {
        return tlOs.get();
    }
}