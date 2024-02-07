package com.ykb.architecture.testservices.StepDefinitions;


import com.ykb.architecture.testservices.pages.HomePage;
import com.ykb.architecture.testservices.pages.PreferenceDependenciesPage;
import com.ykb.architecture.testservices.pages.PreferencePage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class PreferencePageStepDefinition {


    PreferencePage preferencePage;


    public PreferencePageStepDefinition() {
        preferencePage = new PreferencePage(ThreadLocalDriver.getTLDriver());
    }

    @And("click on preferences dependencies at Preference Page")
    public void clickOnPreferencesDependenciesAtPreferencePage() {
        preferencePage.clickOnPreferenceDependencies();
    }
}
