package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/23/2018.
 */

public class HomePage extends BasePage {

    @FindBy(xpath="//h1[@translate='main.title']")
    WebElement welcomeMessage;

    @FindBy(xpath="//div[@translate='global.messages.info.authenticated']/a")
    WebElement loginLink;

    @FindBy(xpath="//div[@translate='global.messages.info.register']/a")
    WebElement registrationLink;

    @FindBy(xpath="//div[@translate='main.logged.message']")
    WebElement loginSuccessfulMessage;

    /*
     * This method verifies if home page is Loaded
     */
    public boolean isApplicationLaunched(){
        return welcomeMessage.getText().contains("Welcome to Gurukula!");
    }

    /*
     * This method verify's if login link is displayed
     */
    public boolean isLoginDisplayed(){
        return loginLink.isDisplayed();
    }

    /*
     * This method verify's if registration link is displayed
     */

    public boolean isRegistrationDisplayed(){
        return registrationLink.isDisplayed();
    }

    /*
     * This method clicks on Login Button of HomePage
     */
    public void clickLoginButton(){
        loginLink.click();
    }

    /*
     * This method clicks on Registration button of HomePage
     */
    public void clickRegistrationLink(){
        registrationLink.click();
    }

}
