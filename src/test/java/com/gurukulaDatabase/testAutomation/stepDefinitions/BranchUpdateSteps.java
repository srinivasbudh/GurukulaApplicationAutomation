package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.BranchFormActions;
import com.gurukulaDatabase.testAutomation.pageActions.BranchesViewActions;
import com.gurukulaDatabase.testAutomation.pageActions.LoginPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.NavigationBarActions;
import com.gurukulaDatabase.testAutomation.pageObjects.BranchesViewPage;
import com.gurukulaDatabase.testAutomation.pageObjects.NavigationBar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class BranchUpdateSteps {
    @Steps
    LoginPageActions loginPageStep;

    @Steps
    NavigationBarActions navigationBarStep;
    @Steps
    BranchFormActions branchFormStep;

    @Steps
    BranchesViewActions branchesViewStep;

    @Given("^User is trying to create a form$")
    public void navigateToCreateAForm() {
      branchesViewStep.navigateToCreateBranchForm();
      branchFormStep.verifyIDFieldIsDisabled();
    }


    @When("^Users enters (.*) into Name text box$")
    public void enterNameText(String name) {
        if(name.equalsIgnoreCase("")){
            branchFormStep.enterNameAsInput(" ");
        }else {
            branchFormStep.enterNameAsInput(name);
        }
    }

    @Then("^Then Name value (.*) Accepted, Error Message (.*) Displayed$")
    public void validateInputOnNameField(String status,String errorStatus) {
        if (status.equalsIgnoreCase("is")&&errorStatus.equalsIgnoreCase("is not")) {
            assertEquals("Name field error message Assertion",true,branchFormStep.isNameValueNotAnError());
        }else{
            assertEquals("Name field error message Assertion",true,branchFormStep.isNameHasAError());
        }
    }

    @Then("^Name error field has (.*) Message$")
    public void assertErrorMessageOnName(String error) {
        if(error.equalsIgnoreCase("No error")){
            assertEquals("Name field error message Assertion",true,branchFormStep.isNameValueNotAnError());
        }else{
            assertEquals("Name field error message assertion",error,branchFormStep.getNameError());
        }
    }

    @When("^Users enters (.*) into Code text box$")
    public void enterCodeText(String code) {
        if(code.equalsIgnoreCase("")){
            branchFormStep.enterCodeAsInput(" ");
        }else {
            branchFormStep.enterCodeAsInput(code);
        }
    }

    @Then("^Then Code value (.*) Accepted, Error Message (.*) Displayed$")
    public void validateInputOnCodeField(String status,String errorStatus) {
        if (status.equalsIgnoreCase("is")&&errorStatus.equalsIgnoreCase("is not")) {
            assertEquals("Name field error message Assertion",true,branchFormStep.isCodeValueNotAnError());
        }else{
            assertEquals("Name field error message Assertion",true,branchFormStep.isCodeHasAError());
        }
    }

    @Then("^Code error field has (.*) Message$")
    public void assertErrorMessageOnCode(String error) {
        if(error.equalsIgnoreCase("No error")){
            assertEquals("Name field error message Assertion",true,branchFormStep.isCodeValueNotAnError());
        }else{
            assertEquals("Name field error message assertion",error,branchFormStep.getCodeError());
        }
    }

}
