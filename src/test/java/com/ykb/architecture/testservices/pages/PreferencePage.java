package com.ykb.architecture.testservices.pages;

import com.ykb.architecture.testservices.BaseTest;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PreferencePage extends BaseTest {
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
    WebElement preferenceDependencies;

    AppiumDriver driver;
    String os;

    public PreferencePage(AppiumDriver driver) {
        this.driver = driver;
        os = ThreadLocalDriver.getTlOs();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    public void clickOnPreferenceDependencies(){
        preferenceDependencies.click();
    }

}
