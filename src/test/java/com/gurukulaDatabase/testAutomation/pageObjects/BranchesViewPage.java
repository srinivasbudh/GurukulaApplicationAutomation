package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */

public class BranchesViewPage extends BasePage {

    @FindBy(xpath="//span[@translate='gurukulaApp.branch.home.createLabel']")
    WebElement createNewBranchButton;

    @FindBy(id="searchQuery")
    WebElement searchBranchBox;

    @FindBy(xpath="//button[@ng-click='search()']")
    WebElement searchBranchButton;

    @FindBy(xpath="//table[@class='table table-striped']/tbody")
    WebElement branchesTable;

    @FindBy(xpath="//button[@class='btn btn-danger']//span[@translate='entity.action.delete']")
    WebElement deleteRecordButton;

    @FindBy(xpath="//form[@name='deleteForm']//span[@translate='entity.action.cancel']")
    WebElement abortDeleteButton;

    private int deleteBranchButton=2;

    private int viewBranchButton=0;


    private int editBranchButton=1;

    /*
     * This method click's on create new Branch button
     */
    public void clickCreateNewBranch(){
        createNewBranchButton.click();
    }

    /*
     * This method verifies if createbranch Button is Displayed
     */
    public boolean isCreateNewBranchDisplayed(){
        waitForElementToBeDisplayed(createNewBranchButton);
        return createNewBranchButton.isDisplayed();
    }

    /*
     * This method enters data into search query Box
     */
    public void enterSearchData(String searchValue){
        waitForElementToBeDisplayed(searchBranchBox);
        searchBranchBox.clear();
        enterTextInto(searchBranchBox,searchValue);
    }

    /*
     * This method click on search Query Button
     */
    public void clickSearch(){
        searchBranchButton.click();
    }

    /*
     * This method clicks on view Button
     */
    public void clickViewBranchButton(WebElement webElement) {
        List<WebElement> buttons =webElement.findElements(By.tagName("button"));
        buttons.get(viewBranchButton).click();
    }

    /*
     * This method clicks on Edit Button
     */
    public void clickEditBranchButton(WebElement webElement){
        List<WebElement> buttons =webElement.findElements(By.tagName("button"));
        buttons.get(editBranchButton).click();
    }

    /*
     * This method clicks on Delete Button
     */
    public void clickDeleteBranchButton(WebElement webElement){
        List<WebElement> buttons =webElement.findElements(By.tagName("button"));
        buttons.get(deleteBranchButton).click();
    }

    /*
     * This method returns the List of branches
     */
    public List<WebElement> getBranchesDatabase(){
        return branchesTable.findElements(By.tagName("tr"));
    }

    /*
     * This method return the number of records on database
     */
    public int getRowsCountInDatabase(){
        return getBranchesDatabase().size();
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