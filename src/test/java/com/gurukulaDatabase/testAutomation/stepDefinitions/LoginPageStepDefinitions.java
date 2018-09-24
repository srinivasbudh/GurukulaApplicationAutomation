package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.HomePageActions;
import com.gurukulaDatabase.testAutomation.pageActions.LoginPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.RegistrationPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.ResetPasswordPageActions;
import com.gurukulaDatabase.testAutomation.pageObjects.ResetPasswordPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertEquals;
/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class LoginPageStepDefinitions {
    @Steps
    LoginPageActions loginPageStep;

    @Steps
    HomePageActions homePagestep;

    @Steps
    RegistrationPageActions registrationPageStep;

    @Steps
    ResetPasswordPageActions resetPasswordStep;

    @Given("^User is accessing the Login page$")
    public void accessLoginForm() {
        homePagestep.launch();
        homePagestep.navigateToLoginPage();
        assertEquals("Login page assertion",true,loginPageStep.verifyLoginPageIsLoaded());
    }

    @When("^User clicks on Registration Link$")
    public void navigateToRegistration() {
       loginPageStep.navigateToRegistration();
    }

    @Then("^Registration form is accessible$")
    public void verifyRegistrationForm() {
        assertEquals("Registration page loading assertion",true,registrationPageStep.verifyRegistrationPageIsLoaded());
    }

    @When("^User clicks on Reset password Link$")
    public void navigateToResetPassword() {
        loginPageStep.navigateToForgotPassword();
    }

    @Then("^Reset password form is accessible$")
    public void verifyResetPasswordForm() {
        assertEquals("Reset password page loading assertion",true,resetPasswordStep.verifyResetPageIsLoaded());
    }

    @When("^User authenticate with (.*) as login, (.*) as password and (.*) Login option$")
    public void userAuthentication(String userName,String password,String rememberOption) {
        if(rememberOption.contains("don't")){
            loginPageStep.authenticateUser(userName,password,false);
        }else{
            loginPageStep.authenticateUser(userName,password,true);
        }
    }

    @Then("^user (.*) authenticated into the application$")
    public void verificationOfUserAuthentication(String statusOfAuthentication) {
        if(statusOfAuthentication.contains("not")){
            assertEquals("login successful assertion",true,loginPageStep.loginFailure());
        }else{
            assertEquals("login failure assertion",true,loginPageStep.loginSuccessful());
        }
    }


}
