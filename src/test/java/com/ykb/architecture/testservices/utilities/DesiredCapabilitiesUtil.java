package com.ykb.architecture.testservices.utilities;


import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesUtil {
    public DesiredCapabilities getDesiredCapabilities(String udid, String platformVersion) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
       // desiredCapabilities.setCapability("appPackage", "com.isinolsun.app");
        //desiredCapabilities.setCapability("appActivity", "com.isinolsun.app.activities.SplashActivity");
        desiredCapabilities.setCapability("app",System.getProperty("user.dir")+"/src/test/resources/ApiDemos-debug.apk");
        //desiredCapabilities.setCapability("chromedriver-executable",System.getProperty("user.dir")+"/driver/chromedriver120");
        //desiredCapabilities.setCapability("browserName","chrome");
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");
        desiredCapabilities.setCapability("automationName","uiautomator2");
        return desiredCapabilities;
    }
}


