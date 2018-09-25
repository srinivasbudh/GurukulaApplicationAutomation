package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.BranchesViewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
    public boolean isBranchViewLoaded(){
        return branchesViewPage.isCreateNewBranchDisplayed();
    }

    @Step
    public void verifyBranchViewIsLoaded(){
        assertEquals("Assert if branches page is loaded",true,branchesViewPage.isCreateNewBranchDisplayed());
    }

    @Step
    public void navigateToCreateBranchForm(){
        loginPageStep.authenticateUser();
        navigationBarStep.navigateToBranches();
        branchesViewPage.clickCreateNewBranch();
    }

    @Step
    public void navigateToBranchesView(){
        loginPageStep.authenticateUser();
        navigationBarStep.navigateToBranches();
    }

    @Step
    public void searchForARecord(String searchQuery){
        branchesViewPage.enterSearchData(searchQuery);
        branchesViewPage.clickSearch();
    }

    @Step
    public WebElement getBranchDetails(String name, String code){
        WebElement branchFound = null;
        List<WebElement> allBranches= branchesViewPage.getBranchesDatabase();
        if(allBranches.size()!=0){
            Iterator<WebElement> branches = allBranches.iterator();
            while(branches.hasNext()){
                WebElement branch = branches.next();
                System.out.println("this is the value of branch"+branch.getText());
                if(branch.getText().contains(name)){
                    if(branch.getText().contains(code)){
                        branchFound=branch;
                        break;
                    }
                }
            }
        }
        return branchFound;
    }

    @Step
    public int getNumberOfBranches(){
        return branchesViewPage.getRowsCountInDatabase();
    }

    @Step
    public boolean verifyRecordFound(String name, String code){
        boolean branchFound = false;
        List<WebElement> allBranches= branchesViewPage.getBranchesDatabase();
        if(allBranches.size()!=0){
            Iterator<WebElement> branches = allBranches.iterator();
            while(branches.hasNext()){
                WebElement branch = branches.next();
                System.out.println("this is the value of branch"+branch.getText());
                if(branch.getText().contains(name)){
                    if(branch.getText().contains(code)){
                        branchFound=true;
                        break;
                    }
                }
            }
        }
        return branchFound;
    }

    @Step
    public void editABranch(WebElement webElement){
        branchesViewPage.clickEditBranchButton(webElement);
    }

    @Step
    public void viewABranch(WebElement webElement){
        branchesViewPage.clickViewBranchButton(webElement);
    }

    @Step
    public void deleteABranch(WebElement webElement){
        branchesViewPage.clickDeleteBranchButton(webElement);
    }

}
