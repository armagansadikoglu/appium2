package com.ykb.architecture.testservices.runner;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        monochrome = true,
        tags = "@android",
        features = "src/test/resources/features",
        glue = "com.ykb.architecture.testservices",
        plugin = {"pretty","json:target/test-report/${artifactId}-${env.code}-${pkg.version.buildNumber}.json"}
)

public class AndroidRunner extends BaseRunner {
    private TestNGCucumberRunner testNGCucumberRunner;


    @Before
    public void beforeScenario(Scenario scenario){
        /*
        String os = ThreadLocalDriver.getTlOs();
        List<String> tags = new ArrayList<>();
        switch (os){
            case "android":
                tags.add("@android");
                break;
            case "ios":
                tags.add("@ios");
                break;
            default:
                tags.add("@ios");
                tags.add("@android");
        }
        List<String> scenarioTags = new ArrayList<>(scenario.getSourceTagNames());
        scenarioTags.retainAll(tags);
        if (scenarioTags.isEmpty()){
            throw new SkipException("Skipping this exception");
        }
*/
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}