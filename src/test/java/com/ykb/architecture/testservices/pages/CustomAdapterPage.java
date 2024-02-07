package com.ykb.architecture.testservices.pages;

import com.ykb.architecture.testservices.BaseTest;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class CustomAdapterPage extends BaseTest {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"People Names\"]")
    WebElement peopleNames;
    @AndroidFindBy(id = "android:id/title")
            WebElement longPressTitle;
    AppiumDriver driver;
    String os;

    public CustomAdapterPage(AppiumDriver driver) {
        this.driver = driver;
        os = ThreadLocalDriver.getTlOs();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }


    public void longPressOnPeopleNames() {
        longPressAction(peopleNames,driver);
    }

    public void longPressTitleEquals(String arg0) {
        Assert.assertEquals(longPressTitle.getText(),arg0);
    }

    public void longPressTextEquals(String arg0) {
        String text = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\""+arg0+"\"]")).getText();
        Assert.assertEquals(text,arg0);
    }
}
