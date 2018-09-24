package com.gurukulaDatabase.testAutomation.runner;

import cucumber.api.CucumberOptions;
import helper.launchApplication.GurukulaApplication;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.IOException;

/**
 * Created by Srinivas budha on 9/23/2018.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.gurukulaDatabase.testAutomation.stepDefinitions")

public class RunFeaturesTest {
    @BeforeClass
    public static void launchGurukula() throws IOException, InterruptedException {
        System.out.println("Launching Gurukula application for test execution .. Please wait... ");
        GurukulaApplication.launch();
    }
}
