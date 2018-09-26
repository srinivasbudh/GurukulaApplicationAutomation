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
    public boolean isRecordViewLoaded(){
        return databaseDetailsPage.isCreateNewRecordDisplayed();
    }

    @Step
    public void verifyBranchViewIsLoaded(){
        assertEquals("Assert if branches page is loaded",true, databaseDetailsPage.isCreateNewRecordDisplayed());
    }

    @Step
    public void navigateToCreateRecordForm(){
        loginPageStep.authenticateUser();
        navigationBarStep.navigateToBranches();
        databaseDetailsPage.clickCreateNewRecord();
    }

    @Step
    public void navigateToRecordsView(){
        loginPageStep.authenticateUser();
        navigationBarStep.navigateToBranches();
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
}
