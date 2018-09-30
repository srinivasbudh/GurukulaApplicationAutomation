package com.gurukulaDatabase.testAutomation.pageObjects;

import com.gurukulaDatabase.testAutomation.helper.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class NavigationBar extends BasePage {

    @FindBy(xpath = "//span[@translate='global.menu.home']")
    WebElement homeMenuOption;

    @FindBy(xpath="//span[@translate='global.menu.account.main']")
    WebElement accountOption;

    @FindBy(xpath="//span[@translate='global.menu.entities.main']")
    WebElement entitiesOption;

    @FindBy(xpath="//span[@translate='global.menu.account.settings']")
    WebElement settingsMenuItem;

    @FindBy(xpath="//span[@translate='global.menu.account.password']")
    WebElement passwordMenuItem;

    @FindBy(xpath="//span[@translate='global.menu.account.sessions']")
    WebElement sessionsMenuItem;

    @FindBy(xpath="//span[@translate='global.menu.account.logout']")
    WebElement logoutMenuItem;

    @FindBy(xpath="//span[@translate='global.menu.entities.branch']")
    WebElement branchMenuItem;

    @FindBy(xpath="//span[@translate='global.menu.entities.staff']")
    WebElement staffMenuItem;

    /*
     * This method is to click on Logout item of account meanu
     */
    public void clickLogout(){
        accountOption.click();
        waitForElementToBeDisplayed(logoutMenuItem);
        logoutMenuItem.click();
    }

    /*
     * This method is to click on password item of account meanu
     */
    public void clickPassword(){
        accountOption.click();
        waitForElementToBeDisplayed(passwordMenuItem);
        passwordMenuItem.click();
    }

    /*
     * This method is to click on password item of account meanu
     */
    public void clickHome(){
        homeMenuOption.click();
    }

    /*
     * This method is to click on Settings item of account meanu
     */
    public void clickSettings(){
        accountOption.click();
        waitForElementToBeDisplayed(settingsMenuItem);
        settingsMenuItem.click();
    }

    /*
     * This method is to click on Sessions item of account meanu
     */
    public void clickSessions(){
        accountOption.click();
        waitForElementToBeDisplayed(sessionsMenuItem);
        sessionsMenuItem.click();
    }

    /*
     * This method is to click on Branch item of entities menu
     */
    public void clickBranch(){
        entitiesOption.click();
        waitForElementToBeDisplayed(branchMenuItem);
        branchMenuItem.click();
    }

    /*
     * This method is to click on Branch item of entities menu
     */
    public void clickStaff(){
        entitiesOption.click();
        waitForElementToBeDisplayed(staffMenuItem);
        staffMenuItem.click();
    }
}
