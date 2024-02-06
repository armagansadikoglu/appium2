package com.ykb.architecture.testservices.pages.android;

import com.ykb.architecture.testservices.BaseTest;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;


public class HomePage extends BaseTest {
    AppiumDriver driver;


    public HomePage(AppiumDriver driver) {
        this.driver = driver;

    }

    public void demo() {
        String os = ThreadLocalDriver.getTlOs();
        if (os.equalsIgnoreCase("android")){

        }
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Armağan");
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }

    public void longPress() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        longPressAction(element,driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(text,"Sample menu");
        text = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]")).getText();
        Assert.assertEquals(text,"Sample action");

    }

    public void scroll() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        // androidUIAutomator ile
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        // diğer yöntem, elementId de destekliyor ama element gözükmüyorsa patlıyor. Yukarıdaki yöntem daha iyi
        // Bu yöntem thread.sleep() koyunca çalıştı sadece. O da stabil çalışmadı. Kullanmaya gerek yok, kod olarak dursun
        //scrollToEndAction();
    }

    public void swipeEnd() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(By.xpath("//android.widget.ImageView"));
        String focusable = element.getAttribute("focusable");
        Assert.assertEquals(focusable,"true");
        swipe(element,driver);

        // UiAutomator ile
        // https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable
        // 1 defa scroll yapma

        /*
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).resourceId(\"io.appium.android.apis:id/gallery\"))" +
                        ".setAsHorizontalList()" +
                        ".scrollForward(1);"
        ));
         */

        focusable = driver.findElement(By.xpath("//android.widget.ImageView")).getAttribute("focusable");
        Assert.assertEquals(focusable,"false");
    }

    public void browser() {
        String os = ThreadLocalDriver.getTlOs();
        if (os.equalsIgnoreCase("android")){
            driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
            WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
            searchBox.sendKeys("Hello");
            searchBox.sendKeys(Keys.ENTER);
            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
        }

    }
}
