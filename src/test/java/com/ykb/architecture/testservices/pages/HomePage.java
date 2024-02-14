package com.ykb.architecture.testservices.pages;

import com.ykb.architecture.testservices.BaseTest;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;


public class HomePage extends BaseTest {

    @AndroidFindBy(accessibility = "Preference")
    WebElement preferences;

    @AndroidFindBy(accessibility = "Views")
    WebElement views;

    @iOSXCUITFindBy(accessibility = "Alert Views")
            WebElement alertViews;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    WebElement typeTextField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"OK\"`]")
    WebElement buttonOK;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
            WebElement textEntry;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == \"Confirm / Cancel\" ")
            WebElement confirmCancelButton;

    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'A message' and type == 'XCUIElementTypeStaticText' ")
    WebElement message;

    @iOSXCUITFindBy(accessibility = "Confirm")
            WebElement confirmButton;
    AppiumDriver driver;
    String os;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        os = ThreadLocalDriver.getTlOs();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    public void clickOnPreference() {

        if (os.equalsIgnoreCase("android")){
            preferences.click();

        }

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

        if (os.equalsIgnoreCase("android")){
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
            searchBox.sendKeys("Hello");
            searchBox.sendKeys(Keys.ENTER);
            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
        }

    }

    public void clickOnViews() {
        views.click();
    }

    public void iosDeneme() {
       alertViews.click();
        // Xpath slow on iOS, use iOSClassChain or iOSnSPredicateString
        textEntry.click();
        typeTextField.sendKeys("Hello World");
        // rahul driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        buttonOK.click();

        // iosPredicateString
confirmCancelButton.click();
        // diğer yazım şekilleri [c] -> case sensitive
        // driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm' ")).click();
        // driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel' ")).click();
        String text = message.getText();
        Assert.assertEquals(text,"A message should be a short, complete sentence.");
        confirmButton.click();
    }

    public void iosTouchAndHold() {
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement thirdIncrementButton = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][3]"));
        // long press
        iosTouchAndHold(thirdIncrementButton,driver);
    }

    public void iosSlide() {
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        // send keys ile 1 gönderirsen sona gider,0 ile başa, 0.25 ile de çeyrek
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider")).sendKeys("1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider")).sendKeys("0");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider")).sendKeys("0.25");
    }
}
