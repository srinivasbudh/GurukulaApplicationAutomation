package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.HomePageActions;
import com.gurukulaDatabase.testAutomation.pageActions.RegistrationPageActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/23/2018.
 */
public class RegistrationPageStepDefinitions {

    @Steps
    HomePageActions homePageStep;
    @Steps
    RegistrationPageActions registrationStep;

    @Given("^Gurukula Application is accessible$")
    public void accessApplication() {
        homePageStep.launch();
        homePageStep.verifyApplicationIsLaunched();
    }

    @Given("^User is accessing Registration form$")
    public void navigateToRegistration() {
        homePageStep.navigateToRegistration();
        registrationStep.verifyRegistrationPageIsLoaded();
    }

    @When("^User enters (.*) into Login field$")
    public void enterLoginName(String loginName) {
        if(loginName.equalsIgnoreCase("")){
            registrationStep.enterTextIntoLogin(" ");
        }else{
            registrationStep.enterTextIntoLogin(loginName);
        }

    }

    @Then("^Login value (.*) Accepted, Error Message (.*) Displayed$")
    public void assertIfErrorDisplayed(String status, String errorStatus) {
        if (status.equalsIgnoreCase("is")&&errorStatus.equalsIgnoreCase("is not")) {
            assertEquals("Login field error message Assertion",true,registrationStep.noLoginErrorMessageIsDisplayed());
        }else{
            assertEquals("Login field error message Assertion",true,registrationStep.isLoginErrorMessageIsDisplayed());
        }
    }

    @And("^Login error field has (.*) Message$")
    public void assertErrorMessage(String error) {
        if(error.equalsIgnoreCase("no")){
            assertEquals("Login field error message Assertion",true,registrationStep.noLoginErrorMessageIsDisplayed());
        }else{
            assertEquals("Login field error message",error,registrationStep.getLoginFieldErrorMessage());
        }
    }

    @When("^User enters (.*) into email field$")
    public void enterEmail(String emailId) {
        if(emailId.equalsIgnoreCase("")){
            registrationStep.enterTextIntoEmail(" ");
        }else{
            registrationStep.enterTextIntoEmail(emailId);
        }

    }

    @Then("^Email value (.*) Accepted, Error Message (.*) Displayed$")
    public void emailValueAssertion(String status, String errorText) {
        if (status.equalsIgnoreCase("is")&&errorText.equalsIgnoreCase("is not")) {
            assertEquals("Email field error message Assertion",true,registrationStep.noEmailErrorMessageIsDisplayed());
        }else{
            assertEquals("Email field error message Assertion",true,registrationStep.isEmailErrorMessageIsDisplayed());
        }
    }

    @And("^Email error field has (.*) Message$")
    public void verifyEmailErrorMessage(String error) {
        if(error.equalsIgnoreCase("no")){
            assertEquals("Email field error message Assertion",true,registrationStep.noEmailErrorMessageIsDisplayed());
        }else{
            assertEquals("Email field error message",error,registrationStep.getEmailFieldErrorMessage());
        }
    }

    @When("^User enters (.*) into Password field$")
    public void enterPassword(String password) {
        if(password.equalsIgnoreCase("")){
            registrationStep.enterTextIntoPassword(" ");
        }else{
            registrationStep.enterTextIntoPassword(password);
        }
    }

    @Then("^Password value (.*) Accepted, Error Message (.*) Displayed$")
    public void passwordAccepted(String status, String errorText) {
        if (status.equalsIgnoreCase("is")&&errorText.equalsIgnoreCase("is not")) {
            assertEquals("Password field error message Assertion",true,registrationStep.noPasswordErrorMessageIsDisplayed());
        }else{
            assertEquals("Password field error message Assertion",true,registrationStep.isPasswordErrorMessageIsDisplayed());
        }
    }

    @And("^Password error field has (.*) Message$")
    public void verifyPasswordMessage(String error) {
        if(error.equalsIgnoreCase("no")){
            assertEquals("Password field error message Assertion",true,registrationStep.noPasswordErrorMessageIsDisplayed());
        }else{
            assertEquals("Password field error message",error,registrationStep.getPasswordFieldErrorMessage());
        }
    }

    @When("^User registers with (.*), (.*), (.*), (.*)$")
    public void registerUser(String loginName,String emailID, String password, String confirmPassword) {
        registrationStep.enterInputsToRegistrationForm(loginName,emailID,password,confirmPassword);
        registrationStep.registerTheUser();
    }

    @Then("^Register option is not Enabled as Mandatory fields are missing$")
    public void verifyRegistrationIsNotAvailable() {
     assertEquals("Registartion button should not be enabled",false,registrationStep.isRegistrationPossible());
    }

    @When("^User enters the (.*), (.*), (.*), (.*)$")
    public void inputToRegistrationForm(String loginName,String emailID, String password, String confirmPassword) {
        registrationStep.enterInputsToRegistrationForm(loginName,emailID,password,confirmPassword);
    }

    @Then("^Registration is (.*) with (.*)$")
    public void verifyRegistrationStatus(String status, String reason) {
        if(status.equalsIgnoreCase("Successful")) {
            assertEquals("Registration successful assertion",true,registrationStep.registrationSuccessful());
        }
        if(reason.equalsIgnoreCase("passwordMismatch")) {
            assertEquals("Password Mismatch assertion",true,registrationStep.bothPasswordDoesNotMatch());
        }
        if(reason.equalsIgnoreCase("userExist")) {
            assertEquals("Registered user assertion",true,registrationStep.userAlreadyExist());
        }
        if(reason.equalsIgnoreCase("emailExist")) {
            assertEquals("Registered email assertion",true,registrationStep.emailsAlreadyExist());
        }
    }

}
