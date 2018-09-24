package com.gurukulaDatabase.testAutomation.helper;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Created by Srinivas Budha on 9/23/2018.
 */
public class BasePage extends PageObject {

    /*
     * This Method enters data into Text field
     */
    public void enterTextInto(WebElement webElement,String text){
        webElement.click();
        webElement.sendKeys(text+Keys.TAB);
    }

    /*
     * This Method makes element to wait for till element is Displayed
     */
    public void waitForElementToBeDisplayed(WebElement webElement){
        for(int waitCount=1;waitCount<3;waitCount++){
            try{
                waitFor(webElement);
            }catch(Exception e){
                //just created a wait loop where an element will be searched for 30 seconds after page is renderred
            }

        }
    }
}
