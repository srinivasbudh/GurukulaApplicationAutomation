package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class LoginPage extends BasePage {

    @FindBy(xpath="//h1[@translate='login.title']")
    WebElement headerMessage;

    @FindBy(id="username")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="rememberMe")
    WebElement automaticLoginCheckBox;

    @FindBy(xpath="//button[@translate='login.form.button']")
    WebElement authenticateButton;

    @FindBy(xpath="//a[@translate='login.password.forgot']")
    WebElement forgotPasswordLink;

    @FindBy(xpath="//a[contains(text(), 'Register a new account')]")
    WebElement registrationLink;

    @FindBy(xpath="//div[@translate='login.messages.error.authentication']")
    WebElement authenticationFailureMessage;

    @FindBy(xpath="//div[@translate='main.logged.message']")
    WebElement authenticationSuccessfulMessage;

    /*
    * This method returns if Header message is Loaded correctly or Not
    */
    public boolean isLoginPageLoaded(){
        return headerMessage.getText().contains("Authentication");
    }

    /*
     * This Method enters authenticates user into application
     * @param userNameText
     * @param passwordText
     */
    public void fillUserDetails(String userNameText,String passwordText){
        enterTextInto(userName,userNameText);
        enterTextInto(password,passwordText);
    }

    /*
     * This method select or unselect check box Remember me
     */
    public void inputAutomaticLogin(boolean automaticLogin){
        if(automaticLogin){
            isAutomaticLoginRequired(true);
        }else{
            isAutomaticLoginRequired(false);
        }
    }

    /*
     * click Authenticate Button
     */
    public void clickLoginButton(){
        authenticateButton.click();
    }

    /*
     * This Method helps in automatic Login
     * @param status Automatic Login required parameter
     */
    public void isAutomaticLoginRequired(boolean status){
        if(status){
            if(!automaticLoginCheckBox.isSelected()){
                automaticLoginCheckBox.click();
            }
        }else {
            if(automaticLoginCheckBox.isSelected()){
                automaticLoginCheckBox.click();
            }
        }
    }

    /*
     * This method helps in navigating to forgot password page
     */
    public void clickOnForgotPassword(){
        forgotPasswordLink.click();
    }

    /*
     * This method helps in clicking register User
     */
    public void clickOnRegistrationLink(){
        registrationLink.click();
    }

    /*
     * This method returns if authentication is successful
     */
    public boolean isAuthenticationSuccessful(){
        return authenticationSuccessfulMessage.isDisplayed();
    }

    /*
     * This method returns if authentication is a failure
     */
    public boolean isAuthenticationFailure(){
        return authenticationFailureMessage.isDisplayed();
    }
}
