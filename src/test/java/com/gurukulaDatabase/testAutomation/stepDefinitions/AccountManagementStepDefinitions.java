package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.AccountManagementActions;
import com.gurukulaDatabase.testAutomation.pageActions.LoginPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.NavigationBarActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/29/2018.
 */
public class AccountManagementStepDefinitions {

    @Steps
    AccountManagementActions accountManagementStep;

    @Steps
    NavigationBarActions navigationStep;

    @Steps
    LoginPageActions loginPageStep;

    @Given("^User is accessing Account settings Page$")
    public void accessAccountSettings() {
        loginPageStep.authenticateUser();
        navigationStep.navigateToSettings();
    }

    @When("^He attempts to change his (.*) from (.*) to (.*)$")
    public void changeAccountProfile(String fieldValue,String existingValue, String newValue) {
        accountManagementStep.changeFieldValue(fieldValue,newValue);
    }

    @When("^(.*) the changes on Account settings screen$")
    public void saveAccountSettings(String action) {
        if(action.equalsIgnoreCase("Save")){
            accountManagementStep.saveAccountSettings();
        }else{
            navigationStep.navigateToSessions();
            navigationStep.navigateToSettings();
        }
    }

    @Then("^Account settings are saved successfully$")
    public void verifyChangeSuccessfulMessage() {
        assertEquals("Verify successful message is Displayed",true,accountManagementStep.isSuccessfulMessageDisplayed());
        navigationStep.navigateToSessions();
        navigationStep.navigateToSettings();
    }

    @Then("^The (.*) is reflected for (.*) on user profile$")
    public void verifyChangesAreSuccessful(String value,String fieldValue) {
        assertEquals("Verify field value updated assertion",true,accountManagementStep.isFieldUpdated(value,fieldValue));
    }

    @Then("^The (.*) is not updated for (.*) on user profile$")
    public void verifyChangesAreNotUpdated(String value,String fieldValue) {
        assertEquals("Verify field value updated assertion",false,accountManagementStep.isFieldUpdated(value,fieldValue));
    }

    @Given("^User is accessing change password screen$")
    public void navigateToPasswordChangeScreen() {
        loginPageStep.authenticateUser();
        navigationStep.navigateToChangePassword();
    }

    @When("^He attempts to change his password using (.*) and (.*)$")
    public void changePassword(String password, String confirmPassword) {
        accountManagementStep.changePassword(password,confirmPassword);
    }

    @Then("^Password change (.*) successful$")
    public void verifyPasswordChangeStatus(String status) {
        if(status.equalsIgnoreCase("is")){
            assertEquals("Password Change Successful assertion",true,accountManagementStep.isPasswordChangeSuccessful());
        }else{
            assertEquals("Password mismatch assertion",true,accountManagementStep.isPasswordMismatchErrorDisplayed());
        }
    }

    @Given("^User is accessing session management view$")
    public void navigateToSessionsView() {
       loginPageStep.authenticateUser();
        navigationStep.navigateToSessions();
    }

    @When("^He invalidate all the active sessions$")
    public void invalidateAllActiveSessions() {
        accountManagementStep.invalidateAllActiveSessions();
    }

    @Then("^Session invalidated message is displayed$")
    public void verifySessionInvalidatedMessage() {
        assertEquals("Assert session Invalidation message",true,accountManagementStep.isSessionInvalidatedMessageDisplayed());
        navigationStep.navigateToStaff();
    }
}
