package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.ResetPasswordPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class ResetPasswordPageActions {
    private ResetPasswordPage resetPasswordPage;

    @Step
    public boolean verifyResetPageIsLoaded(){
        assertEquals("Reset password Button is Enabled Assertion",false,resetPasswordPage.isResetButtonEnabled());
        return resetPasswordPage.isRestPasswordPageLoaded();
    }

    @Step
    public void resetPasswordForEmail(){
        resetPasswordPage.clickResetButton();
    }
    @Step
    public boolean isResetSuccessfulMessageIsDisplayed(){
        return resetPasswordPage.isResetPasswordSuccessful();
    }

    @Step
    public boolean isWrongEmailErrorMessageIsDisplayed(){
        return resetPasswordPage.isResetPasswordFailure();
    }
}
