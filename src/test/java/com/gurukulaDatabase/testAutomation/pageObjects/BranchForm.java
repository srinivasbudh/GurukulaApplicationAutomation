package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */

public class BranchForm extends BasePage {

    @FindBy(xpath="//input[@name='id']")
    WebElement idInputField;

    @FindBy(xpath="//input[@name='name']")
    WebElement nameInputField;

    @FindBy(xpath="//input[@name='code']")
    WebElement codeInputField;

    @FindBy(xpath="//div[@ng-show='editForm.code.$invalid']")
    WebElement codeErrorMessage;

    @FindBy(xpath="//div[@ng-show='editForm.name.$invalid']")
    WebElement nameErrorMessage;

    @FindBy(xpath="//button[@type='submit' and @class='btn btn-primary']")
    WebElement saveButton;

    @FindBy(xpath="//span[@translate='entity.action.cancel']")
    WebElement cancelButton;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='gurukulaApp.branch.code']")
    WebElement codeLabelWithOutError;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='gurukulaApp.branch.name']")
    WebElement nameLabelWithOutError;

    /*
     * This method enters text into name field
     */
    public void enterName(String name){
        nameInputField.clear();
        enterTextInto(nameInputField,name);
    }

    /*
     * This method enters text into code field
     */
    public void enterCode(String code){
        codeInputField.clear();
        enterTextInto(codeInputField,code);
    }

    /*
     * This method validates if ID field is disabled
     */
    public boolean isIDFieldIsDisabled(){
        return idInputField.isEnabled();
    }

    /*
     * This Method returns if Name field has a error message
     */
    public boolean isNameFieldErrorDisplayed(){
        return nameErrorMessage.isDisplayed();
    }

    /*
     * This Method returns error message of Name field
     */
    public String getNameErrorMessage(){
        return nameErrorMessage.getText();
    }

    /*
     * This Method returns if Code field has a error message
     */
    public boolean isCodeFieldErrorDisplayed(){
        return codeErrorMessage.isDisplayed();
    }

    /*
     * This Method returns error message of Code field
     */
    public String getCodeErrorMessage(){
        return codeErrorMessage.getText();
    }

    /*
     * This method return NoName error is Displayed
     */
    public boolean noNameErrorIsDisplayed(){
        return nameLabelWithOutError.isDisplayed();
    }

    /*
     * This method return No Code error is Displayed
     */
    public boolean noCodeErrorIsDisplayed(){
        return codeLabelWithOutError.isDisplayed();
    }

    /*
     * This method clicks on save button
     */
    public void clickSaveButton(){
        saveButton.click();
    }

    /*
     * This method verify if saveButton is enabled
     */
    public boolean isSaveButtonEnabled(){
        return saveButton.isEnabled();
    }

    /*
     * This method clicks on cancel button
     */
    public void clickCancelButton(){
        cancelButton.click();
    }
}
