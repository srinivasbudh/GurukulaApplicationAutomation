package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/23/2018.
 */

public class RegistrationPage extends BasePage {

    @FindBy(xpath="//h1[@translate='register.title']")
    WebElement headerMessage;

    @FindBy(xpath="//input[@name='login']")
    WebElement loginTextField;

    @FindBy(xpath="//input[@name='email']")
    WebElement emailTextField;

    @FindBy(xpath="//input[@name='password']")
    WebElement newPasswordField;

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath="//button[@translate='register.form.button']")
    WebElement registrationButton;

    @FindBy(xpath="//div[@class='form-group has-error']//div[@ng-show='form.login.$dirty && form.login.$invalid']")
    WebElement loginErrorField;

    @FindBy(xpath = "//div[@class='form-group has-error']//div[@ng-show='form.email.$dirty && form.email.$invalid']")
    WebElement emailErrorField;

    @FindBy(xpath = "//div[@class='form-group has-error']//div[@ng-show='form.password.$dirty && form.password.$invalid']")
    WebElement newPasswordErrorField;

    @FindBy(xpath="//div[@class='form-group has-error']//div[@ng-show='form.confirmPassword.$dirty && form.confirmPassword.$invalid']")
    WebElement confirmPasswordTextField;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='global.form.username']")
    WebElement loginLabelField;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='global.form.email']")
    WebElement emailLabelField;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='global.form.newpassword']")
    WebElement newPasswordLabelField;

    @FindBy(xpath="//div[@translate='register.messages.success']")
    WebElement registrationSuccessfulMessage;

    @FindBy(xpath="//div[@translate='register.messages.error.fail']")
    WebElement registrationFailureMessage;

    @FindBy(xpath="//div[@translate='register.messages.error.userexists']")
    WebElement registrationUserExistMessage;

    @FindBy(xpath="//div[@translate='register.messages.error.emailexists']")
    WebElement registrationEmailExistsMessage;

    @FindBy(xpath="//div[@translate='global.messages.error.dontmatch']")
    WebElement registrationPasswordMismatch;

    /*
     * This method returns if Header message is Loaded correctly or Not
     */
    public boolean isRegistrationPageLoaded(){
        return headerMessage.getText().contains("Registration");
    }

    /*
     * This method enters text in Login field on Registration Form
     */
    public void enterTextInLogin(String loginName){
        enterTextInto(loginTextField,loginName);
    }

    /*
     * This method verify's if error message is displayed or nor
     */
    public boolean isLoginErrorDisplayed(){
        return loginErrorField.isDisplayed();
    }

    /*
     * This method verify's No error message is displayed on Login Field
     */
    public boolean noLoginErrorDisplayed(){
        return loginLabelField.isDisplayed();
    }


    /*
     * This method returnsErrorMessage of Login Text field
     */
    public String getLoginErrorMessage(){
        if(loginErrorField.isDisplayed()){
            return loginErrorField.getText();
        }
        return "No Error";
    }

    /*
     * This method enters text in Email field on Registration Form
     */
    public void enterTextInEmail(String emailId){
        enterTextInto(emailTextField,emailId);
    }

    /*
     * This method verify's if error message is displayed or nor
     */
    public boolean isEmailErrorDisplayed(){
        return emailErrorField.isDisplayed();
    }

    /*
     * This method verify's No error message is displayed on Email Field
     */
    public boolean noEmailErrorDisplayed(){
        return emailLabelField.isDisplayed();
    }


    /*
     * This method returnsErrorMessage of Email textfield
     */
    public String getEmailErrorMessage(){
        if(emailErrorField.isDisplayed()){
            return emailErrorField.getText();
        }
        return "No Error";
    }

    /*
     * This method enters text in Password field on Registration Form
     */
    public void enterTextInPassword(String password){
        enterTextInto(newPasswordField,password);
    }

    /*
     * This method verify's if error message is displayed or not
     */
    public boolean isPasswordErrorDisplayed(){
        return newPasswordErrorField.isDisplayed();
    }

    /*
     * This method verify's No error message is displayed on Password Field
     */
    public boolean noPasswordErrorDisplayed(){
        return newPasswordLabelField.isDisplayed();
    }


    /*
     * This method returnsErrorMessage of Email textfield
     */
    public String getPasswordErrorMessage(){
        if(newPasswordErrorField.isDisplayed()){
            return newPasswordErrorField.getText();
        }
        return "No Error";
    }

    /*
     * This method enters text in confirm Password field on Registration Form
     */
    public void enterTextInConfirmPassword(String password){
        enterTextInto(confirmPasswordField,password);
    }

    /*
     * This method return if Registration button is enabled
     */
    public boolean isRegistrationButtonEnabled(){
        return registrationButton.isEnabled();
    }

    /*
     * This method clicks on Registartion Button
     */
    public void clickRegistrationButton(){
        registrationButton.click();
    }

    /*
     * This Method Verifies Registration is successful
     */
    public boolean isRegistrationSuccessful() {
        waitForElementToBeDisplayed(registrationSuccessfulMessage);
      return registrationSuccessfulMessage.isDisplayed();
    }

    /*
     * This Method Verifies if Registration is failure
     */
    public boolean isRegistrationUnSuccessful(){
        waitForElementToBeDisplayed(registrationFailureMessage);
        return registrationFailureMessage.isDisplayed();
    }

    /*
     * This Method Verifies if user trying to register already exist
     */
    public boolean isUserAlreadyRegistered(){
        waitForElementToBeDisplayed(registrationUserExistMessage);
        return registrationUserExistMessage.isDisplayed();
    }

    /*
     * This Method Verifies if email trying to register already exist
     */
    public boolean isEmailAlreadyRegistered(){
        waitForElementToBeDisplayed(registrationEmailExistsMessage);
        return registrationEmailExistsMessage.isDisplayed();
    }

    /*
     * This Method Verifies if password mismatch occured
     */
    public boolean isPasswordMismatchOccured(){
        waitForElementToBeDisplayed(registrationPasswordMismatch);
        return registrationPasswordMismatch.isDisplayed();
    }
}
