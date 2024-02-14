package com.ykb.architecture.testservices;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public void iosTouchAndHold(WebElement element, AppiumDriver driver){

            Map<String, Object> params = new HashMap<>();
            params.put("element",((RemoteWebElement)element).getId());
            params.put("duration", 5);
            driver.executeScript("mobile:touchAndHold",params);

    }

    public void longPressAction(WebElement element, AppiumDriver driver){
        //https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        // duration defaultta 500
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration",2000
                ));
    }

    public void scrollToEndAction(AppiumDriver driver){
//https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        boolean canScrollMore;
        do{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction","down",
                    "percent", 3.0
            ));

        }while (canScrollMore);

    }
    public void swipe(WebElement element,AppiumDriver driver){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
               "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    public void dragAndDrop(WebElement element,int x, int y,AppiumDriver driver){
// Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y,
                "speed", 250
        ));
    }


}
