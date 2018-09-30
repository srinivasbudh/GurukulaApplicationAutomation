package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.HomePage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/23/2018.
 */

public class HomePageActions {

    private HomePage homePage;

    @Step
    public void launch(){
        homePage.open();
    }

    @Step
    public void verifyApplicationIsLaunched(){
        assertEquals("Home Page title displayed assertion",true,homePage.isApplicationLaunched());
    }

    @Step
    public boolean isLoginLinkDisplayed(){
        return homePage.isLoginDisplayed();
    }

    @Step
    public boolean isRegistrationLinkDisplayed(){
        return homePage.isRegistrationDisplayed();
    }

    @Step
    public void navigateToRegistration(){
        homePage.clickRegistrationLink();
    }

    @Step
    public void navigateToLoginPage(){
        if(isLoginLinkDisplayed()) {
            homePage.clickLoginButton();
        }

    }


}
