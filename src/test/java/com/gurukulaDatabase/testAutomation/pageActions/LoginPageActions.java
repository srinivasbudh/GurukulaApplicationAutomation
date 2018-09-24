package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class LoginPageActions {
    private LoginPage loginPage;

    @Step
    public boolean verifyLoginPageIsLoaded(){
        return loginPage.isLoginPageLoaded();
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
    public boolean loginSuccessful(){
        return loginPage.isAuthenticationSuccessful();
    }

    @Step
    public boolean loginFailure(){
        return loginPage.isAuthenticationFailure();
    }

}
