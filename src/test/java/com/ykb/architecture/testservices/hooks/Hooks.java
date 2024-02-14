package com.ykb.architecture.testservices.hooks;

import com.ykb.architecture.testservices.utilities.ThreadLocalDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;


public class Hooks {


    @Before
    public void setupLoginSteps(Scenario scenario) {


       // setupScreens(ThreadLocalDriver.getTLDriver());
    }
    @After
    public void teardown(Scenario scenario){

        if (scenario.isFailed()){
            takeSsAndAddToReport(scenario);
        }
    }

    private void takeSsAndAddToReport(Scenario scenario){
        byte[] screenshotAs;
        try {
            screenshotAs = ThreadLocalDriver.getTLDriver().getScreenshotAs(OutputType.BYTES);
            File screenshotAs1 = ThreadLocalDriver.getTLDriver().getScreenshotAs(OutputType.FILE);
            File targetFile=new File(System.getProperty("user.dir")+"/demo.jpg");
            FileUtils.copyFile(screenshotAs1,targetFile);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        scenario.attach(screenshotAs,"image/png","screenshot");
    }
}
