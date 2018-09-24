package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.LoginPage;
import com.gurukulaDatabase.testAutomation.pageObjects.ResetPasswordPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class ResetPasswordPageActions {
    private ResetPasswordPage resetPasswordPage;

    @Step
    public boolean verifyResetPageIsLoaded(){
        return resetPasswordPage.isRestPasswordPageLoaded();
    }


}
