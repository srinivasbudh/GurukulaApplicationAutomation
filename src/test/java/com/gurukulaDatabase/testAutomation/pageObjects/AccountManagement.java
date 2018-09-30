package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Created by Srinivas Budha on 9/29/2018.
 */
public class AccountManagement extends BasePage {

    @FindBy(xpath="//table[@class='table table-striped']/tbody")
    WebElement activeSessionsTable;

    @FindBy(xpath="//input[@ng-model='settingsAccount.firstName']")
    WebElement nameOnAccountManagement;

    @FindBy(xpath="//input[@ng-model='settingsAccount.lastName']")
    WebElement lastNameOnAccountManagement;

    @FindBy(xpath="//input[@ng-model='settingsAccount.email']")
    WebElement emailOnAccountManagement;

    @FindBy(xpath="//button[@translate='settings.form.button']")
    WebElement saveButtonOnAccountSettings;

    @FindBy(xpath="//input[@ng-model='password']")
    WebElement passwordTextField;

    @FindBy(xpath="//input[@ng-model='confirmPassword']")
    WebElement confirmPasswordTextField;

    @FindBy(xpath="//button[@translate='password.form.button']")
    WebElement savePasswordButton;

    @FindBy(xpath = "//div[@translate='settings.messages.success']")
    WebElement settingsSaveSuccessMessage;

    @FindBy(xpath = "//div[@translate='settings.messages.error.fail']")
    WebElement settingsSaveFailureMessage;

    @FindBy(xpath = "//div[@translate='global.messages.error.dontmatch']")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[@translate='password.messages.success']")
    WebElement passwordChangedMessage;

    @FindBy(xpath="//div[@translate='sessions.messages.success']")
    WebElement sessionInvalidatedMessage;

    /*
     * This Method returns the number rows in the table
     */
    public int getActiveSessionsCount(){
        return activeSessionsTable.findElements(By.tagName("tr")).size();
    }

    /*
     * This Method returns list of active session
     */
    public List<WebElement> getActiveSessions(){
        return activeSessionsTable.findElements(By.tagName("tr"));
    }

    /*
     * This method clicks on Invalidate button of a session
     */
    public void clickOnInvalidateSession(WebElement webElement){
        waitForElementToBeDisplayed(webElement);
        webElement.findElement(By.tagName("button")).click();
    }

    /*
     * This method returns if session invalidated message is Displayed
     */
    public boolean isSessionInvalidated(){
        return sessionInvalidatedMessage.isDisplayed();
    }

    /*
     * This method Add or Update name into  first name Field
     */
    public void enterTextIntoFirstName(String firstName){
       nameOnAccountManagement.clear();
        enterTextInto(nameOnAccountManagement,firstName);
    }

    /*
     * This method Add or Update name into  last name Field
     */
    public void enterTextIntoLastName(String lastName){
        lastNameOnAccountManagement.clear();
        enterTextInto(lastNameOnAccountManagement,lastName);
    }

    /*
     * This method Add or Update email
     */
    public void enterTextIntoEmail(String email){
        emailOnAccountManagement.clear();
        enterTextInto(emailOnAccountManagement,email);
    }

    /*
     * This method clicks On save button
     */
    public void clickOnSaveButton(){
        saveButtonOnAccountSettings.click();
    }

    /*
     * This Method enters Text into Password field
     */
    public void enterTextIntoPasswordField(String password){
        enterTextInto(passwordTextField,password);
    }

    /*
     * This Method enters Text into confirm Password field
     */
    public void enterTextIntoConfirmPasswordField(String password){
        enterTextInto(confirmPasswordTextField,password);
    }

    /*
     * This method clicks On save button
     */
    public void clickOnSavePasswordButton(){
        savePasswordButton.click();
    }

    /*
     * This method verify if settings saved successful message is displayed or not
     */
    public boolean isSettingSuccessfulMessageDisplayed(){
        return settingsSaveSuccessMessage.isDisplayed();
    }

    /*
     * This method verify if settings saved failure message is displayed or not
     */
    public boolean isSettingFailureMessageDisplayed(){
        return settingsSaveFailureMessage.isDisplayed();
    }

    /*
     * This method returns the name Text from account setting
     */
    public String getName(){
        return nameOnAccountManagement.getText();
    }

    /*
     * This method returns the last name Text from account setting
     */
    public String getLastName(){
        return lastNameOnAccountManagement.getText();
    }

    /*
     * This method returns the email Text from account setting
     */
    public String getEmail(){
        return emailOnAccountManagement.getText();
    }

    /*
     * This method returns if password change successful message is displayed
     */
    public boolean isPasswordChangeSuccessful(){
        return passwordChangedMessage.isDisplayed();
    }

    /*
     * This method returns if password mismatch message is displayed
     */
    public boolean isPasswordMisMatchDisplayed(){
        return passwordErrorMessage.isDisplayed();
    }
}
