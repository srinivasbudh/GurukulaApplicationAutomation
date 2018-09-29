package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */

public class DatabaseUpdateForm extends BasePage {

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

    @FindBy(xpath="//button[@type='submit']//span[@translate='entity.action.save']")
    WebElement saveButtonText;

    @FindBy(xpath="//span[@translate='entity.action.cancel']")
    WebElement cancelButton;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='gurukulaApp.branch.code']")
    WebElement codeLabelWithOutError;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='gurukulaApp.branch.name']")
    WebElement nameLabelWithOutErrorOnBranch;

    @FindBy(xpath="//div[@class='form-group']//*[@translate='gurukulaApp.staff.name']")
    WebElement nameLabelWithOutErrorOnStaff;

    @FindBy(xpath = "//select[@name='related_branch']")
    WebElement branchDropDown;

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
    public boolean noNameErrorIsDisplayedOnBranch(){
        return nameLabelWithOutErrorOnBranch.isDisplayed();
    }

    /*
    * This method return NoName error is Displayed
    */
    public boolean noNameErrorIsDisplayedOnStaff(){
        return nameLabelWithOutErrorOnStaff.isDisplayed();
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
        if(isSaveButtonEnabled()){
            saveButtonText.click();
        }
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

    /*
     * This method selects Value From Dropdown
     */
    public void selectValue(String branchName){
        Select dropDown = new Select(branchDropDown);
        dropDown.selectByVisibleText(branchName);
    }
}
