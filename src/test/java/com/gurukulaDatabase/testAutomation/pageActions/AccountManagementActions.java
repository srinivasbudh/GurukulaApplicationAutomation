package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.AccountManagement;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Srinivas Budha on 9/29/2018.
 */
public class AccountManagementActions {

    private AccountManagement accountManagement;

    @Step
    public void inputAccountDetails(String name, String lastName, String email){
        accountManagement.enterTextIntoFirstName(name);
        accountManagement.enterTextIntoLastName(lastName);
        accountManagement.enterTextIntoEmail(email);
    }

    @Step
    public void inputNameDetails(String name){
        accountManagement.enterTextIntoFirstName(name);
    }


    @Step
    public void inputLastNameDetails(String lastName){
        accountManagement.enterTextIntoLastName(lastName);
    }


    @Step
    public void inputEmailDetails(String email){
        accountManagement.enterTextIntoEmail(email);
    }

    @Step
    public void saveAccountSettings(){
        accountManagement.clickOnSaveButton();
    }

    @Step
    public boolean isSuccessfulMessageDisplayed(){
        return accountManagement.isSettingSuccessfulMessageDisplayed();
    }

    @Step
    public boolean isFailureMessageDisplayed(){
        return accountManagement.isSettingFailureMessageDisplayed();
    }

    @Step
    public String getAccountSettingsName(){
        return accountManagement.getName();
    }

    @Step
    public String getAccountSettingsLastName(){
        return accountManagement.getLastName();
    }

    @Step
    public String getAccountSettingsEmail(){
        return accountManagement.getEmail();
    }

    @Step
    public void changeFieldValue(String fieldType,String value){
        switch (fieldType){
            case "name":
                inputNameDetails(value);
                break;
            case "lastname":
                inputLastNameDetails(value);
                break;
            case "email":
                inputEmailDetails(value);
                break;
            default:
                throw new IllegalIcuArgumentException("Verify the input name of the field is in small letters without any space"+value);
        }
    }

    @Step
    public boolean isFieldUpdated(String value,String fieldType){
        switch (fieldType){
            case "name":
                return value.equalsIgnoreCase(getAccountSettingsName());
            case "lastname":
                return value.equalsIgnoreCase(getAccountSettingsLastName());
            case "email":
                return value.equalsIgnoreCase(getAccountSettingsLastName());
            default:
                throw new IllegalIcuArgumentException("verify the input name of the field is in small letters"+fieldType);
        }
    }

    @Step
    public void changePassword(String password, String confirmPassword){
        accountManagement.enterTextIntoPasswordField(password);
        accountManagement.enterTextIntoConfirmPasswordField(confirmPassword);
        accountManagement.clickOnSavePasswordButton();
    }

    @Step
    public boolean isPasswordChangeSuccessful(){
        return accountManagement.isPasswordChangeSuccessful();
    }

    @Step
    public boolean isPasswordMismatchErrorDisplayed(){
        return accountManagement.isPasswordMisMatchDisplayed();
    }

    @Step
    public void invalidateAllActiveSessions(){
        int count=0;
        int numberOfSessions= accountManagement.getActiveSessionsCount();
        while(count<numberOfSessions){
            List<WebElement> activeSessions = accountManagement.getActiveSessions();
            Iterator<WebElement> sessions = activeSessions.iterator();
            WebElement session=sessions.next();
            accountManagement.clickOnInvalidateSession(session);
            count=count+1;
        }
    }

    @Step
    public boolean isSessionInvalidatedMessageDisplayed(){
        return accountManagement.isSessionInvalidated();
    }
}
