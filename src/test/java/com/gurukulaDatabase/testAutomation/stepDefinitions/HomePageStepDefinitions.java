package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.HomePageActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas budha on 9/23/2018.
 */
public class HomePageStepDefinitions {
    @Steps
    HomePageActions homePageStep;

    @Given("^Gurukula Application is Launched$")
    public void accessApplication() {
        homePageStep.launch();
    }

    @When("^Initial home Page is accessible$")
    public void verifyApplicationLaunched() {
       homePageStep.verifyApplicationIsLaunched();
    }

    @Then("^Verify login option is available$")
    public void verifyLoginLinkIsDisplayed() {
        assertEquals("Verification of Login link availability",true,homePageStep.isLoginLinkDisplayed());
    }

    @And("^Verify Registration option is available$")
    public void verifyRegistrationLinkIsDisplayed() {
       assertEquals("Verification of Registration link availability",true,homePageStep.isRegistrationLinkDisplayed());
    }
}
