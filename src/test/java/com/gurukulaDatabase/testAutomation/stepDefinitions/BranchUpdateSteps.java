package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.BranchFormActions;
import com.gurukulaDatabase.testAutomation.pageActions.BranchesViewActions;
import com.gurukulaDatabase.testAutomation.pageActions.LoginPageActions;
import com.gurukulaDatabase.testAutomation.pageActions.NavigationBarActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;

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

    @When("^Users creates a branch with details (.*) and (.*)$")
    public void createUser(String name,String code) {
        branchFormStep.inputBranchData(name,code);
        branchFormStep.saveBranchData();
        branchesViewStep.searchForARecord(name);
    }

    @Then("^User (.*) created with details (.*) and (.*) in database$")
    public void verifyBranchCreated(String status, String name,String code) {
        if(status.equalsIgnoreCase("is")){
            assertEquals("Branch created assertion",true,branchesViewStep.isBranchViewLoaded());
            assertEquals("Branch created assertion",true,branchesViewStep.verifyRecordFound(name,code));
        }else{
            assertEquals("Branch creation failure assertion",false,branchFormStep.isSaveButtonEnabled());
        }

    }

    @Given("^User is accessing all the branches$")
    public void navigateToBranchesview() {
        branchesViewStep.navigateToBranchesView();
        branchesViewStep.verifyBranchViewIsLoaded();
    }

    @When("^he search for a branch with existing (.*), (.*)$")
    public void searchABranch(String fieldType,String searchQuery) {
        branchesViewStep.searchForARecord(searchQuery);
    }

    @Then("^Branch with (.*), (.*) is Retrieved$")
    public void verifyBranchSearchSuccessful(String fieldType,String searchQuery) {
        if(fieldType.equalsIgnoreCase("Name")){
            branchesViewStep.verifyRecordFound(searchQuery,"");
        }else if(fieldType.equalsIgnoreCase("Code")){
            branchesViewStep.verifyRecordFound("",searchQuery);
        }

    }

    @Then("^No Branches are found$")
    public void verifyBranchSearchIsAFailure() {
        assertEquals("No Branches Found Assertion",true,branchesViewStep.getNumberOfBranches()==0);
    }

    @When("^he attempts to change the (.*) to (.*), (.*) to (.*)$")
    public void updateARecord(String name,String newName,String code,String newCode) {
        branchesViewStep.searchForARecord(name);
        WebElement branchDetails = branchesViewStep.getBranchDetails(name, code);
        branchesViewStep.editABranch(branchDetails);
        branchFormStep.inputBranchData(newName,newCode);
    }

    @When("^Save the changes on Branch details form$")
    public void saveBranchDetails() {
        branchFormStep.saveBranchData();
    }
    @When("^Cancel the changes on Branch details form without saving$")
    public void cancelBranchChanges() {
        branchFormStep.cancelBranchData();
    }


    @Then("^Branch (.*) updated with (.*), (.*)$")
    public void verifybranchFound(String status,String newName,String newCode) {
        if(status.equalsIgnoreCase("is")){

            assertEquals("Branch details updated assertion",true,branchesViewStep.verifyRecordFound(newName,newCode));
        }else{
            branchesViewStep.searchForARecord(newName);
            assertEquals("Branch details NOT updated assertion",false,branchesViewStep.verifyRecordFound(newName,newCode));
        }

    }

}
