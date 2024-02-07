package com.ykb.architecture.testservices.StepDefinitions;


import com.ykb.architecture.testservices.pages.ViewsPage;
import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.en.And;


public class ViewsPageStepDefinition {


    ViewsPage viewsPage;


    public ViewsPageStepDefinition() {
        viewsPage = new ViewsPage(ThreadLocalDriver.getTLDriver());
    }


    @And("click on expendable lists at Views Page")
    public void clickOnExpendableListsAtViewsPage() {
        viewsPage.clickOnExpendableLists();
    }
}
