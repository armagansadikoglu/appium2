package com.ykb.architecture.testservices.StepDefinitions.android;


import com.ykb.architecture.testservices.pages.android.HomePage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;


public class HomePageStepDefinition  {


    HomePage homePage;


    public HomePageStepDefinition() {
        homePage = new HomePage(ThreadLocalDriver.getTLDriver());
    }


    @Given("deneme")
    public void demo(){
        homePage.demo();
    }

    @Given("longpress")
    public void longpress() {
        homePage.longPress();
    }

    @Given("scroll")
    public void scroll() {
        homePage.scroll();
    }

    @Given("swipe")
    public void swipe() {
        homePage.swipeEnd();
    }

    @Given("browser")
    public void browser() {
        homePage.browser();
    }
}
