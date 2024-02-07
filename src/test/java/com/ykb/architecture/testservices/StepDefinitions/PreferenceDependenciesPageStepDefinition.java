package com.ykb.architecture.testservices.StepDefinitions;


import com.ykb.architecture.testservices.pages.PreferenceDependenciesPage;
import com.ykb.architecture.testservices.pages.PreferencePage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class PreferenceDependenciesPageStepDefinition {


    PreferenceDependenciesPage preferenceDependenciesPage;


    public PreferenceDependenciesPageStepDefinition() {
        preferenceDependenciesPage = new PreferenceDependenciesPage(ThreadLocalDriver.getTLDriver());
    }


    @When("set wifi name {string} at Preference Dependencies Page")
    public void setWifiNameAtPreferenceDependenciesPage(String arg0) {
        preferenceDependenciesPage.clickOnWifiCheckbox();
        preferenceDependenciesPage.clickOnWifiSettings();
        preferenceDependenciesPage.setWifiName(arg0);
    }
}
