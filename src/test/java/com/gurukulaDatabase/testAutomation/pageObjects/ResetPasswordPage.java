package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class ResetPasswordPage extends BasePage {

    @FindBy(xpath="//h1[@translate='reset.request.title']")
    WebElement headerMessage;

    @FindBy(xpath="//button[@translate='reset.request.form.button']")
    WebElement resetPasswordButton;

    @FindBy(xpath="//p[@translate='reset.request.messages.success']")
    WebElement resetPasswordSuccess;

    @FindBy(xpath="//div[@translate='reset.request.messages.notfound']")
    WebElement resetPasswordFailure;

    /*
    * This method returns if Header message is Loaded correctly or Not
    */
    public boolean isRestPasswordPageLoaded(){
        return headerMessage.getText().contains("Reset your password");
    }

    /*
    * This method returns if reset button is enabled
    */
    public boolean isResetButtonEnabled(){
         return resetPasswordButton.isEnabled();
    }

    /*
    * This method clicks on reset button
    */
    public void clickResetButton(){
        resetPasswordButton.click();
    }

    /*
    * This method returns if reset password successful message was displayed
    */
    public boolean isResetPasswordSuccessful(){
        return resetPasswordSuccess.isDisplayed();
    }

    /*
    * This method returns if reset password failure message was displayed
    */
    public boolean isResetPasswordFailure(){
        return resetPasswordFailure.isDisplayed();
    }

}
