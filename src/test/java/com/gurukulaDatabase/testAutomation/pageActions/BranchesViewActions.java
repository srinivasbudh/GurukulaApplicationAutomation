package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.BranchesViewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

/**
 * Created by Srinivas Budha on 9/25/2018.
 */
public class BranchesViewActions {
    private BranchesViewPage branchesViewPage;
    @Steps
    LoginPageActions loginPageStep;

    @Steps
    NavigationBarActions navigationBarStep;


    @Step
    public void navigateToCreateBranchForm(){
        loginPageStep.authenticateUser();
        navigationBarStep.navigateToBranches();
        branchesViewPage.clickCreateNewBranch();
    }
}
