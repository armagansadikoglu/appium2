package com.ykb.architecture.testservices.StepDefinitions;


import com.ykb.architecture.testservices.pages.CustomAdapterPage;
import com.ykb.architecture.testservices.pages.ViewsPage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CustomAdapterPageStepDefinition {


    CustomAdapterPage customAdapterPage;


    public CustomAdapterPageStepDefinition() {
        customAdapterPage = new CustomAdapterPage(ThreadLocalDriver.getTLDriver());
    }



    @When("longpress on people names at Custom Adapter Page")
    public void longpressOnPeopleNamesAtCustomAdapterPage() {
        customAdapterPage.longPressOnPeopleNames();
    }

    @Then("assert that title {string} is seen on long press at Custom Adapter Page")
    public void assertThatTitleIsSeenOnLongPressAtCustomAdapterPage(String arg0) {
        customAdapterPage.longPressTitleEquals(arg0);
    }

    @Then("assert that text {string} is seen on long press at Custom Adapter Page")
    public void assertThatTextIsSeenOnLongPressAtCustomAdapterPage(String arg0) {
        customAdapterPage.longPressTextEquals(arg0);
    }
}
