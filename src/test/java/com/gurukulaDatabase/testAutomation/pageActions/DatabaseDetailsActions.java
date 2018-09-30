package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.DatabaseDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/25/2018.
 */
public class DatabaseDetailsActions {
    private DatabaseDetailsPage databaseDetailsPage;
    @Steps
    LoginPageActions loginPageStep;

    @Steps
    NavigationBarActions navigationBarStep;

    @Step
    public boolean isBranchViewLoaded(){
        return databaseDetailsPage.isCreateNewBranchDisplayed();
    }

    @Step
    public boolean isEmployeeViewLoaded(){
        return databaseDetailsPage.isCreateNewEmployeeDisplayed();
    }

    @Step
    public void verifyRecordViewIsLoaded(String recordType){
        if(recordType.contains("branch")){
            verifyBranchViewIsLoaded();
        }else{
            verifyStaffViewIsLoaded();
        }

    }

    @Step
    public void verifyBranchViewIsLoaded(){
        assertEquals("Branches page loading assertion",true, databaseDetailsPage.isCreateNewBranchDisplayed());
    }
    @Step
    public void verifyStaffViewIsLoaded(){
        assertEquals("Staff page loading assertion",true, databaseDetailsPage.isCreateNewEmployeeDisplayed());
    }

    @Step
    public void navigateToCreateRecordForm(String recordType){
        loginPageStep.authenticateUser();
        if(recordType.equalsIgnoreCase("Branch")){
            navigationBarStep.navigateToBranches();
            databaseDetailsPage.clickCreateNewBranch();
        }else{
            navigationBarStep.navigateToStaff();
            databaseDetailsPage.clickCreateNewStaff();
        }

    }

    @Step
    public void navigateToRecordsView(String recordType){
        loginPageStep.authenticateUser();
        if(recordType.equalsIgnoreCase("Branches")){
            navigationBarStep.navigateToBranches();
        }else{
            navigationBarStep.navigateToStaff();
        }
    }

    @Step
    public void searchForARecord(String searchQuery){
        databaseDetailsPage.enterSearchData(searchQuery);
        databaseDetailsPage.clickSearch();
    }

    @Step
    public WebElement getRecordDetails(String name, String code){
        WebElement branchFound = null;
        List<WebElement> allBranches= databaseDetailsPage.getDatabaseRecords();
        if(allBranches.size()!=0){
            Iterator<WebElement> branches = allBranches.iterator();
            while(branches.hasNext()){
                WebElement branch = branches.next();
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
    public int getNumberOfRecords(){
        return databaseDetailsPage.getRowsCountInDatabase();
    }

    @Step
    public boolean verifyRecordFound(String name, String code){
        boolean branchFound = false;
        List<WebElement> allBranches= databaseDetailsPage.getDatabaseRecords();
        if(allBranches.size()!=0){
            Iterator<WebElement> branches = allBranches.iterator();
            while(branches.hasNext()){
                WebElement branch = branches.next();
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
    public void editARecord(WebElement webElement){
        databaseDetailsPage.clickEditButtonOnRecord(webElement);
    }

    @Step
    public void viewARecord(WebElement webElement){
        databaseDetailsPage.clickViewButtonOnRecord(webElement);
    }

    @Step
    public void deleteARecord(WebElement webElement){
        databaseDetailsPage.clickDeleteButtonOnRecord(webElement);
    }

    @Step
    public void abortDeleteRecordProcess(){
        databaseDetailsPage.clickAbortDelete();
    }

    @Step
    public void deleteRecordProcess(){
        databaseDetailsPage.clickDeleteRecord();
    }

    @Step
    public boolean arePageNavigationButtonsEnabled(){
        boolean returnValue = false;
            if(databaseDetailsPage.isNextButtonEnabled())
                returnValue =true;
            if(databaseDetailsPage.isPreviousButtonEnabled())
                returnValue=true;
        return returnValue;
    }
}
