package com.gurukulaDatabase.testAutomation.pageActions;


import com.gurukulaDatabase.testAutomation.pageObjects.RegistrationPage;
import net.thucydides.core.annotations.Step;


/**
 * Created by Srinivas Budha on 9/23/2018.
 */

public class RegistrationPageActions {

    private RegistrationPage registrationPage;

    @Step
    public boolean verifyRegistrationPageIsLoaded(){
        return registrationPage.isRegistrationPageLoaded();
    }

    @Step
    public void enterTextIntoLogin(String loginName){
        registrationPage.enterTextInLogin(loginName);
    }

    @Step
    public boolean isLoginErrorMessageIsDisplayed(){
        return registrationPage.isLoginErrorDisplayed();
    }

    @Step
    public boolean noLoginErrorMessageIsDisplayed(){
        return registrationPage.noLoginErrorDisplayed();
    }

    @Step
    public String getLoginFieldErrorMessage(){
        return registrationPage.getLoginErrorMessage();
    }

    @Step
    public void enterTextIntoEmail(String emailId){
        registrationPage.enterTextInEmail(emailId);
    }
    @Step
    public boolean isEmailErrorMessageIsDisplayed(){
        return registrationPage.isEmailErrorDisplayed();
    }

    @Step
    public boolean noEmailErrorMessageIsDisplayed(){
        return registrationPage.noEmailErrorDisplayed();
    }

    @Step
    public String getEmailFieldErrorMessage(){
        return registrationPage.getEmailErrorMessage();
    }

    @Step
    public String getPasswordFieldErrorMessage(){
        return registrationPage.getPasswordErrorMessage();
    }

    @Step
    public void enterTextIntoPassword(String password){
        registrationPage.enterTextInPassword(password);
    }
    @Step
    public boolean isPasswordErrorMessageIsDisplayed(){
        return registrationPage.isPasswordErrorDisplayed();
    }

    @Step
    public boolean noPasswordErrorMessageIsDisplayed(){
        return registrationPage.noPasswordErrorDisplayed();
    }

    @Step
    public void enterTextIntoConfirmPassword(String confirmPassword){
        registrationPage.enterTextInConfirmPassword(confirmPassword);
    }

    @Step
    public boolean isRegistrationPossible(){
        return registrationPage.isRegistrationButtonEnabled();
    }

    @Step
    public void enterInputsToRegistrationForm(String loginName,String emailID, String password, String confirmPassword){
        enterTextIntoLogin(loginName);
        enterTextIntoEmail(emailID);
        enterTextIntoPassword(password);
        enterTextIntoConfirmPassword(confirmPassword);
    }

    @Step
    public void registerTheUser(){
        registrationPage.clickRegistrationButton();
    }

    @Step
    public boolean registrationSuccessful(){
       return registrationPage.isRegistrationSuccessful();
    }

    @Step
    public boolean registrationUnSuccessful(){
        return registrationPage.isRegistrationUnSuccessful();
    }

    @Step
    public boolean userAlreadyExist(){
        return registrationPage.isUserAlreadyRegistered();
    }

    @Step
    public boolean emailsAlreadyExist(){
        return registrationPage.isEmailAlreadyRegistered();
    }

    @Step
    public boolean bothPasswordDoesNotMatch(){
        return registrationPage.isPasswordMismatchOccured();
    }


}
