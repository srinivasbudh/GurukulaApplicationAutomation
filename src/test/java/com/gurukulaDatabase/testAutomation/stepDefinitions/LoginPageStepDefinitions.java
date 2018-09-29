package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.HomePageActions;
import com.gurukulaDatabase.testAutomation.pageActions.NavigationBarActions;
import com.gurukulaDatabase.testAutomation.pageActions.LoginPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.ResetPasswordPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.RegistrationPageActions;
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

    @Steps
    NavigationBarActions navigationBarStep;

    @Given("^User is accessing the Login page$")
    public void accessLoginForm() {
        loginPageStep.accessLoginForm();
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

    @Given("^User is Logged in into the application$")
    public void authenticateUser() {
        loginPageStep.authenticateUser();
    }

    @When("^Users Logout of the application$")
    public void users_Logout_of_the_application() {
        navigationBarStep.performLogout();
    }

    @Then("^User is logged out successfully$")
    public void user_is_logged_out_successfully() {
        homePagestep.verifyApplicationIsLaunched();
    }


}
