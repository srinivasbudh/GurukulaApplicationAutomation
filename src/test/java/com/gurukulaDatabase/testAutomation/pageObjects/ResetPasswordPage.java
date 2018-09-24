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

    /*
    * This method returns if Header message is Loaded correctly or Not
    */
    public boolean isRestPasswordPageLoaded(){
        return headerMessage.getText().contains("Reset your password");
    }
}
