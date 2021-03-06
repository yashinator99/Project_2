package com.project2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;


@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber.html"},
    features = {"src/test/resources/features/login.feature",
    "src/test/resources/features/home.feature",
    "src/test/resources/features/register.feature"},
    glue = {"com/project2/StepDefinitions"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

    // private TestNGCucumberRunner testNGCucumberRunner;

    // @BeforeClass( alwaysRun = true)
    // public void setupClass(){
    //     testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    // }

    // @Test(dataProvider = "features")
    // public void feature( PickleWrapper pickleWrapper, FeatureWrapper feature){
    //     testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    // }


    // @DataProvider
    // public Object[][] features(){
    //     return testNGCucumberRunner.provideScenarios();
    // }

    // @AfterClass( alwaysRun = true)
    // public void tearDownClass(){
    //     testNGCucumberRunner.finish();
    // }
}
