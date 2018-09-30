package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.DatabaseUpdateForm;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class DataBaseUpdateActions {

    private DatabaseUpdateForm databaseUpdateForm;

    @Step
    public void verifyIDFieldIsDisabled(){
        assertEquals("ID field is Not Editable assertion",true, databaseUpdateForm.isIDFieldIsDisabled());
    }

    @Step
    public void enterNameAsInput(String name){
        databaseUpdateForm.enterName(name);
    }

    @Step
    public void enterCodeAsInput(String code){
        databaseUpdateForm.enterCode(code);
    }

    @Step
    public void selectBranchOfEmployee(String branch){
        databaseUpdateForm.selectValue(branch);
    }

    @Step
    public boolean isNameHasAError(){
        return databaseUpdateForm.isNameFieldErrorDisplayed();
    }

    @Step
    public boolean isCodeHasAError(){
        return databaseUpdateForm.isCodeFieldErrorDisplayed();
    }

    @Step
    public boolean isNameValueNotAnError(String recordType){
        if(recordType.equalsIgnoreCase("Branch")){
            return databaseUpdateForm.noNameErrorIsDisplayedOnBranch();
        }else{
            return databaseUpdateForm.noNameErrorIsDisplayedOnStaff();
        }

    }

    @Step
    public boolean isCodeValueNotAnError(){
        return databaseUpdateForm.noCodeErrorIsDisplayed();
    }
    @Step
    public String getNameError(){
        return databaseUpdateForm.getNameErrorMessage();
    }

    @Step
    public String getCodeError(){
        return databaseUpdateForm.getCodeErrorMessage();
    }

    @Step
    public void inputBranchData(String name,String code){
        enterNameAsInput(name);
        enterCodeAsInput(code);
    }

    @Step
    public void inputEmployeeData(String name,String branch){
        enterNameAsInput(name);
        selectBranchOfEmployee(branch);
    }

    @Step
    public void saveDataToDB(){
        databaseUpdateForm.clickSaveButton();
    }

    @Step
    public void cancelSavingData(){
        databaseUpdateForm.clickCancelButton();
    }

    @Step
    public boolean isSaveButtonEnabled(){
        return databaseUpdateForm.isSaveButtonEnabled();
    }
}
