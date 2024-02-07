package com.ykb.architecture.testservices.StepDefinitions;


import com.ykb.architecture.testservices.pages.ExpendablesPage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.en.And;


public class ExpendablesPageStepDefinition {


    ExpendablesPage expendablesPage;

    public ExpendablesPageStepDefinition() {
        expendablesPage = new ExpendablesPage(ThreadLocalDriver.getTLDriver());
    }

    @And("click on custom adapter at Expendable Lists Page")
    public void clickOnCustomAdapterAtExpendableListsPage() {
        expendablesPage.clickOnCustomAdapter();
    }
}
