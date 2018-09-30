package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */

public class DatabaseDetailsPage extends BasePage {

    @FindBy(xpath="//span[@translate='gurukulaApp.branch.home.createLabel']")
    WebElement createNewBranchButton;

    @FindBy(xpath="//span[@translate='gurukulaApp.staff.home.createLabel']")
    WebElement createNewEmployeeButton;

    @FindBy(id="searchQuery")
    WebElement searchRecordBox;

    @FindBy(xpath="//button[@ng-click='search()']")
    WebElement searchRecordButton;

    @FindBy(xpath="//table[@class='table table-striped']/tbody")
    WebElement dbRecordsTable;

    @FindBy(xpath="//button[@class='btn btn-danger']//span[@translate='entity.action.delete']")
    WebElement deleteRecordButton;

    @FindBy(xpath="//form[@name='deleteForm']//span[@translate='entity.action.cancel']")
    WebElement abortDeleteButton;

    @FindBy(xpath="//li[@ng-show=\"links['last']\"]")
    WebElement nextButtonForPagenavigation;

    @FindBy(xpath="//li[@ng-show=\"links['first']\"]")
    WebElement previousButtonForPagenavigation;

    private int deleteDataButton =2;

    private int viewdataButton =0;

    private int editDataButton =1;

    /*
     * This method click's on create new Branch button
     */
    public void clickCreateNewBranch(){
        createNewBranchButton.click();
    }


    /*
     * This method click's on create new Staff button
     */
    public void clickCreateNewStaff(){
        createNewEmployeeButton.click();
    }

    /*
     * This method verifies if createbranch Button is Displayed
     */
    public boolean isCreateNewBranchDisplayed(){
        waitForElementToBeDisplayed(createNewBranchButton);
        return createNewBranchButton.isDisplayed();
    }

    /*
     * This Method verifies if next button is enabled
     */
    public boolean isNextButtonEnabled(){
        return nextButtonForPagenavigation.isEnabled();
    }

    /*
     * This method Clicks on Next button for Page navigation
     */
    public  void clickNextButton(){
        nextButtonForPagenavigation.click();
    }

    /*
     * This Method verifies if previous button is enabled
     */
    public boolean isPreviousButtonEnabled(){
        return previousButtonForPagenavigation.isEnabled();
    }

    /*
     * This method Clicks on previous button for Page navigation
     */
    public  void clickPreviousButton(){
        previousButtonForPagenavigation.click();
    }

    /*
     * This method verifies if createEmployee Button is Displayed
     */
    public boolean isCreateNewEmployeeDisplayed(){
        waitForElementToBeDisplayed(createNewEmployeeButton);
        return createNewEmployeeButton.isDisplayed();
    }

    /*
     * This method enters data into search query Box
     */
    public void enterSearchData(String searchValue){
        waitForElementToBeDisplayed(searchRecordBox);
        searchRecordBox.clear();
        enterTextInto(searchRecordBox,searchValue);
    }

    /*
     * This method click on search Query Button
     */
    public void clickSearch(){
        searchRecordButton.click();
    }

    /*
     * This method clicks on view Button
     */
    public void clickViewButtonOnRecord(WebElement webElement) {
        List<WebElement> buttons =webElement.findElements(By.tagName("button"));
        buttons.get(viewdataButton).click();
    }

    /*
     * This method clicks on Edit Button
     */
    public void clickEditButtonOnRecord(WebElement webElement){
        List<WebElement> buttons =webElement.findElements(By.tagName("button"));
        buttons.get(editDataButton).click();
    }

    /*
     * This method clicks on Delete Button
     */
    public void clickDeleteButtonOnRecord(WebElement webElement){
        List<WebElement> buttons =webElement.findElements(By.tagName("button"));
        buttons.get(deleteDataButton).click();
    }

    /*
     * This method returns the List of branches
     */
    public List<WebElement> getDatabaseRecords(){
        return dbRecordsTable.findElements(By.tagName("tr"));
    }

    /*
     * This method return the number of records on database
     */
    public int getRowsCountInDatabase(){
        return getDatabaseRecords().size();
    }

    /*
     * This methods clicks on delete button of Delete Record popup
     */
    public void clickDeleteRecord(){
        waitForElementToBeDisplayed(deleteRecordButton);
        deleteRecordButton.click();
    }

    /*
     * This methods clicks on cancel button of Delete Record popup
     */
    public void clickAbortDelete(){
        waitForElementToBeDisplayed(abortDeleteButton);
        abortDeleteButton.click();
    }
}