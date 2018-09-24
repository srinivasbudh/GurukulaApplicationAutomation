package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class LoginPageActions {
    private LoginPage loginPage;

    @Step
    public boolean isLoginPageLoaded(){
        return loginPage.isLoginPageLoaded();
    }

    @Step
    public void verifyLoginSuccessful(){
        assertEquals("Login successful assertion",true,loginPage.isAuthenticationSuccessful());
    }

    @Step
    public void navigateToForgotPassword(){
        loginPage.clickOnForgotPassword();
    }

    @Step
    public void navigateToRegistration(){
        loginPage.clickOnRegistrationLink();
    }

    @Step
    public void rememberUserLogin(boolean status){
        loginPage.inputAutomaticLogin(status);
    }

    @Step
    public void authenticateUser(String userName,String password,boolean saveLogin){
        loginPage.fillUserDetails(userName,password);
        rememberUserLogin(saveLogin);
        loginPage.clickLoginButton();
    }

    @Step
    public void performValidLogin(){
        authenticateUser("admin","admin",true);
    }

    @Step
    public boolean loginSuccessful(){
        return loginPage.isAuthenticationSuccessful();
    }

    @Step
    public boolean loginFailure(){
        return loginPage.isAuthenticationFailure();
    }

}
