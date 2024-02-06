package com.ykb.architecture.testservices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class DriverManager {
    AppiumDriver driver;



    public AppiumDriver getDriver() throws MalformedURLException {

        if (Objects.isNull(driver)){
            UiAutomator2Options options = new UiAutomator2Options();
            //options.setDeviceName("Pixel_7_Pro_API_31");
            options.setChromedriverExecutable(System.getProperty("user.dir")+"/driver/chromedriver120");
            //options.setApp(System.getProperty("user.dir")+"/src/test/resources/ApiDemos-debug.apk");
            options.setApp(System.getProperty("user.dir")+"/src/test/resources/ApiDemos-debug.apk");
            String port = System.getProperty("port");
            if (Objects.isNull(port)){
                port = "4723";
            }
            //driver = new AndroidDriver(new URL("http://127.0.0.1:"+port),options);
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
        return driver;
    }

    public void close() {
       driver.quit();

    }


}
