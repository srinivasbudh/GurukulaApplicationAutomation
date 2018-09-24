package com.gurukulaDatabase.testAutomation.pageActions;

import com.gurukulaDatabase.testAutomation.pageObjects.BranchForm;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;

/**
 * Created by x000810 on 9/24/2018.
 */
public class BranchFormActions {

    private BranchForm branchForm;

    @Step
    public void verifyIDFieldIsDisabled(){
        assertEquals("ID field is Not Editable assertion",true,branchForm.isIDFieldIsDisabled());
    }

    @Step
    public void enterNameAsInput(String name){
        branchForm.enterName(name);
    }

    @Step
    public void enterCodeAsInput(String code){
        branchForm.enterCode(code);
    }

    @Step
    public boolean isNameHasAError(){
        return branchForm.isNameFieldErrorDisplayed();
    }

    @Step
    public boolean isCodeHasAError(){
        return branchForm.isCodeFieldErrorDisplayed();
    }

    @Step
    public boolean isNameValueNotAnError(){
        return branchForm.noNameErrorIsDisplayed();
    }

    @Step
    public boolean isCodeValueNotAnError(){
        return branchForm.noCodeErrorIsDisplayed();
    }
    @Step
    public String getNameError(){
        return branchForm.getNameErrorMessage();
    }

    @Step
    public String getCodeError(){
        return branchForm.getCodeErrorMessage();
    }

    @Step
    public void inputBranchData(String name,String code){
        enterNameAsInput(name);
        enterCodeAsInput(code);
    }

    @Step
    public void saveBranchData(){
        branchForm.clickSaveButton();
    }

    @Step
    public void cancelBranchData(){
        branchForm.clickCancelButton();
    }

}
