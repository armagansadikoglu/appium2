package com.ykb.architecture.testservices.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.ArrayList;
import java.util.List;

public class Hooks {


    @Before
    public void setupLoginSteps(Scenario scenario) {


       // setupScreens(ThreadLocalDriver.getTLDriver());
    }
    @After
    public void teardown(){

    }
}
