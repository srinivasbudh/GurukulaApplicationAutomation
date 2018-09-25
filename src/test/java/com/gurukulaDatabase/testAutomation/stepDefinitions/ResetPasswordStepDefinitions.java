package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class ResetPasswordStepDefinitions {
    @Steps
    LoginPageActions loginPageStep;

    @Steps
    LoginPageStepDefinitions loginPageStepDefinitions;
    @Steps
    RegistrationPageActions registrationPageStep;

    @Steps
    ResetPasswordPageActions resetPasswordStep;

    @Given("^User is accessing the Reset password form$")
    public void accessRegistrationForm() {
        loginPageStep.accessLoginForm();
        loginPageStep.navigateToForgotPassword();
    }

    @When("^User attempts to reset password for (.*)$")
    public void requestPasswordReset(String emailId) {
        registrationPageStep.enterTextIntoEmail(emailId);
        resetPasswordStep.resetPasswordForEmail();

    }

    @Then("^Email sent for password reset message is Displayed$")
    public void emailSentForPasswordReset() {
        assertEquals("Email sent for Reset password",true,resetPasswordStep.isResetSuccessfulMessageIsDisplayed());
    }

    @Then("^Email doesn't exist message is Displayed$")
    public void emailDoesnotExistForPasswordReset() {
        assertEquals("Email already exist assertion",true,resetPasswordStep.isWrongEmailErrorMessageIsDisplayed());
    }

}
