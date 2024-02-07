package com.ykb.architecture.testservices.pages;

import com.ykb.architecture.testservices.BaseTest;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class PreferenceDependenciesPage extends BaseTest {

    @AndroidFindBy(id = "android:id/checkbox")
    WebElement wifiCheckbox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WiFi settings']")
    WebElement wifiSettings;

    @AndroidFindBy(id = "android:id/edit")
            WebElement wifiNameEditBox;

    @AndroidFindBy(id = "android:id/alertTitle")
            WebElement alertTitle;
    @AndroidFindBy(xpath = "//*[@text='OK']")
            WebElement okButton;


    AppiumDriver driver;
    String os;

    public PreferenceDependenciesPage(AppiumDriver driver) {
        this.driver = driver;
        os = ThreadLocalDriver.getTlOs();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    public void clickOnWifiCheckbox(){
        wifiCheckbox.click();
    }
    public void clickOnWifiSettings(){
        wifiSettings.click();
    }

    public void setWifiName(String wifiName){
        wifiNameEditBox.sendKeys(wifiName);
        String alertTitleText = alertTitle.getText();
        Assert.assertEquals(alertTitleText,"WiFi settings");
        okButton.click();
    }



}
