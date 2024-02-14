package com.ykb.architecture.testservices.runner;

import com.ykb.architecture.testservices.config.SutConfiguration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.ykb.architecture.testservices.utilities.DesiredCapabilitiesUtil;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;

public class BaseRunner {
    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();

    @BeforeMethod
    @Parameters({ "udid", "platformVersion","os" })
    public void setup(@Optional() String udid, @Optional()String platformVersion, @Optional(value = "android") String os) throws IOException {
        DesiredCapabilities caps;
        if (Objects.isNull(udid) && Objects.isNull(platformVersion)){
            caps = desiredCapabilitiesUtil.getDesiredCapabilities(os);
        } else if (Objects.isNull(udid)) {
            caps = desiredCapabilitiesUtil.getDesiredCapabilities(platformVersion,os);
        } else  {
            caps = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion, os);

        }
       //ThreadLocalDriver.setTLDriver(new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps));
        if (os.equalsIgnoreCase("android")){
            ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL(SutConfiguration.getProps().getProperty("appium.url")), caps),os);
        }else{
            ThreadLocalDriver.setTLDriver(new IOSDriver(new URL(SutConfiguration.getProps().getProperty("appium.url")), caps),os);
        }

    }

    @AfterMethod
    public synchronized void teardown() {
        ((AppiumDriver)(ThreadLocalDriver.getTLDriver())).quit();
    }
}
