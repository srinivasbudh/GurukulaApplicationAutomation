package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.NavigationBar;
import net.thucydides.core.annotations.Step;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class NavigationBarActions {
    private NavigationBar navigationBar;

    @Step
    public void performLogout(){
        navigationBar.clickLogout();
    }

    @Step
    public void navigateToBranches(){
        navigationBar.clickBranch();
    }

    @Step
    public void navigateToStaff(){
        navigationBar.clickStaff();
    }

    @Step
    public void navigateToSettings(){
        navigationBar.clickSettings();
    }

    @Step
    public void navigateToSessions(){
        navigationBar.clickSessions();
    }

    @Step
    public void navigateToChangePassword(){
        navigationBar.clickPassword();
    }
}
