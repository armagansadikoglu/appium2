package com.ykb.architecture.testservices.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setupLoginSteps() {
       // setupScreens(ThreadLocalDriver.getTLDriver());
    }
    @After
    public void teardown(){

    }
}
