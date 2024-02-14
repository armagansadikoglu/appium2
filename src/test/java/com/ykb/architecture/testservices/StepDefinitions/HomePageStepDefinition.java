package com.ykb.architecture.testservices.StepDefinitions;


import com.ykb.architecture.testservices.pages.HomePage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.en.Given;


public class HomePageStepDefinition  {


    HomePage homePage;

    public HomePageStepDefinition() {
        homePage = new HomePage(ThreadLocalDriver.getTLDriver());
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

    @Given("click on preference at Home Page")
    public void clickOnPreferenceAtHomePage() {
        homePage.clickOnPreference();
    }

    @Given("click on views at Home Page")
    public void clickOnViewsAtHomePage() {
        homePage.clickOnViews();
    }

    @Given("ios")
    public void ios() {
        homePage.iosDeneme();
    }

    @Given("ios touch and hold")
    public void iosTouchAndHold() {
        homePage.iosTouchAndHold();
    }

    @Given("ios slide")
    public void iosSlide() {
        homePage.iosSlide();
    }
}
