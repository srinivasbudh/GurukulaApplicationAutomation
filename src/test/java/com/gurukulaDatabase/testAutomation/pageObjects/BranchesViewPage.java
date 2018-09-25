package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */

public class BranchesViewPage extends BasePage {

    @FindBy(xpath="//span[@translate='gurukulaApp.branch.home.createLabel']")
    WebElement createNewBranchButton;

    /*
     * This method click's on create new Branch button
     */
    public void clickCreateNewBranch(){
        createNewBranchButton.click();
    }
}
