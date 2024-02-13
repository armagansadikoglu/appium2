package com.ykb.architecture.testservices.utilities;


import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DesiredCapabilitiesUtil {
    public DesiredCapabilities getDesiredCapabilities(String udid, String platformVersion, String os) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        if (os.equalsIgnoreCase("android")){
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("automationName","uiautomator2");
            desiredCapabilities.setCapability("app",System.getProperty("user.dir")+"/src/test/resources/ApiDemos-debug.apk");
        }else{
            desiredCapabilities.setCapability("app",System.getProperty("user.dir")+"/src/test/resources/UIKitCatalog.app");
            // ios için Appium -> WebDriver Agent -> IOS Apps
            desiredCapabilities.setCapability("wdaLaunchTimeout", 20000 );
            desiredCapabilities.setCapability("platformName", "iOS");
            desiredCapabilities.setCapability("automationName", "XCUITest");
        }

       // desiredCapabilities.setCapability("appPackage", "com.isinolsun.app");
        //desiredCapabilities.setCapability("appActivity", "com.isinolsun.app.activities.SplashActivity");
        //desiredCapabilities.setCapability("chromedriver-executable",System.getProperty("user.dir")+"/driver/chromedriver120");
        //desiredCapabilities.setCapability("browserName","chrome");
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");

        return desiredCapabilities;
    }
}


