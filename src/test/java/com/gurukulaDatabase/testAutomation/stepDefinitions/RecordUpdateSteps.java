package com.gurukulaDatabase.testAutomation.stepDefinitions;

import com.gurukulaDatabase.testAutomation.pageActions.DataBaseUpdateActions;
import com.gurukulaDatabase.testAutomation.pageActions.DatabaseDetailsActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/**
 * Created by Srinivas Budha on 9/24/2018.
 */
public class RecordUpdateSteps {
    @Steps
    DataBaseUpdateActions databaseUpdateStep;

    @Steps
    DatabaseDetailsActions databaseDetailsStep;

    @Given("^User is trying to create a (.*)$")
    public void navigateToCreateAForm(String recordType) {
      databaseDetailsStep.navigateToCreateRecordForm(recordType);
      databaseUpdateStep.verifyIDFieldIsDisabled();
    }

    @When("^Users enters (.*) into Name text box$")
    public void enterNameText(String name) {
        if(name.equalsIgnoreCase("")){
            databaseUpdateStep.enterNameAsInput(" ");
        }else {
            databaseUpdateStep.enterNameAsInput(name);
        }
    }

    @Then("^(.*) Name value (.*) Accepted, Error Message (.*) Displayed$")
    public void validateInputOnNameField(String recordType,String status,String errorStatus) {
        if (status.equalsIgnoreCase("is")&&errorStatus.equalsIgnoreCase("is not")) {
            assertEquals("Name field error message Assertion",true, databaseUpdateStep.isNameValueNotAnError(recordType));
        }else{
            assertEquals("Name field error message Assertion",true, databaseUpdateStep.isNameHasAError());
        }
    }

    @Then("^(.*) Name error field has (.*) Message$")
    public void assertErrorMessageOnName(String recordType,String error) {
        if(error.equalsIgnoreCase("No error")){
            assertEquals("Name field error message Assertion",true, databaseUpdateStep.isNameValueNotAnError(recordType));
        }else{
            assertEquals("Name field error message assertion",error, databaseUpdateStep.getNameError());
        }
    }

    @When("^Users enters (.*) into Code text box$")
    public void enterCodeText(String code) {
        if(code.equalsIgnoreCase("")){
            databaseUpdateStep.enterCodeAsInput(" ");
        }else {
            databaseUpdateStep.enterCodeAsInput(code);
        }
    }

    @Then("^Then Code value (.*) Accepted, Error Message (.*) Displayed$")
    public void validateInputOnCodeField(String status,String errorStatus) {
        if (status.equalsIgnoreCase("is")&&errorStatus.equalsIgnoreCase("is not")) {
            assertEquals("Name field error message Assertion",true, databaseUpdateStep.isCodeValueNotAnError());
        }else{
            assertEquals("Name field error message Assertion",true, databaseUpdateStep.isCodeHasAError());
        }
    }

    @Then("^Code error field has (.*) Message$")
    public void assertErrorMessageOnCode(String error) {
        if(error.equalsIgnoreCase("No error")){
            assertEquals("Name field error message Assertion",true, databaseUpdateStep.isCodeValueNotAnError());
        }else{
            assertEquals("Name field error message assertion",error, databaseUpdateStep.getCodeError());
        }
    }

    @When("^Users creates a (.*) with details (.*) and (.*)$")
    public void createUser(String recordType,String name,String code) {
        if(recordType.equalsIgnoreCase("Branch")){
            databaseUpdateStep.inputBranchData(name,code);
        }else{
            databaseUpdateStep.inputEmployeeData(name,code);
        }

    }

    @Then("^Branch (.*) created with details (.*) and (.*) in database$")
    public void verifyBranchCreated(String status, String name,String code) {
        if(status.equalsIgnoreCase("is")){
            databaseUpdateStep.saveDataToDB();
            assertEquals("branches view page loaded Assertion",true, databaseDetailsStep.isBranchViewLoaded());
            databaseDetailsStep.searchForARecord(name);
            assertEquals("Branch created assertion",true, databaseDetailsStep.verifyRecordFound(name,code));
        }else{
            assertEquals("Branch creation failure assertion",false, databaseUpdateStep.isSaveButtonEnabled());
        }
    }

    @Then("^Employee (.*) created with details (.*) and (.*) in database$")
    public void verifyEmployeeCreated(String status, String name,String code) {
        if(status.equalsIgnoreCase("is")){
            databaseUpdateStep.saveDataToDB();
            assertEquals("Employee view page loaded Assertion",true, databaseDetailsStep.isEmployeeViewLoaded());
            assertEquals("Employee created assertion",true, databaseDetailsStep.verifyRecordFound(name,code));
        }else{
            assertEquals("Employee creation failure assertion",false, databaseUpdateStep.isSaveButtonEnabled());
        }
    }

    @Then("^Employee (.*) updated with (.*), (.*)$")
    public void verifyEmployeeDetails(String status, String name,String branch) {
        if(status.equalsIgnoreCase("is")){
            assertEquals("Employee view page loaded Assertion",true, databaseDetailsStep.isEmployeeViewLoaded());
            assertEquals("Employee updated assertion",true, databaseDetailsStep.verifyRecordFound(name,branch));
        }else{
            assertEquals("Employee updated assertion",false, databaseDetailsStep.verifyRecordFound(name,branch));
        }
    }

    @Given("^User is accessing all (.*) information$")
    public void navigateToBranchesView(String recordType) {
        databaseDetailsStep.navigateToRecordsView(recordType);
        databaseDetailsStep.verifyRecordViewIsLoaded(recordType);
    }

    @When("^he search for a branch with existing (.*), (.*)$")
    public void searchABranch(String fieldType,String searchQuery) {
        databaseDetailsStep.searchForARecord(searchQuery);
    }

    @Then("^(.*) with (.*), (.*),(.*) is Retrieved$")
    public void verifyBranchSearchSuccessful(String recordType,String fieldType,String searchQuery,String extraItem) {
        if(fieldType.equalsIgnoreCase("Name")){
            assertEquals("asserrtion if record Found",true,databaseDetailsStep.verifyRecordFound(searchQuery,extraItem));
        }else if(fieldType.equalsIgnoreCase("Code")||fieldType.equalsIgnoreCase("Branch")){
            assertEquals("asserrtion if record Found",true,databaseDetailsStep.verifyRecordFound(extraItem,searchQuery));
        }

    }

    @Then("^No (.*) are found$")
    public void verifyBranchSearchIsAFailure(String recordType) {
        assertEquals("No Records Found Assertion",true, databaseDetailsStep.getNumberOfRecords()==0);
    }

    @Then("^Page navigation buttons are disabled$")
    public void verifypagenNavigationButtons() {
        assertEquals("Page Navigation Buttons Are Disabled assertions",false, databaseDetailsStep.arePageNavigationButtonsEnabled());
    }

    @When("^he attempts to change the (.*) to (.*), (.*) to (.*) of a Branch$")
    public void updateARecord(String name,String newName,String code,String newCode) {
        databaseDetailsStep.searchForARecord(name);
        WebElement branchDetails = databaseDetailsStep.getRecordDetails(name, code);
        databaseDetailsStep.editARecord(branchDetails);
        databaseUpdateStep.inputBranchData(newName,newCode);
    }

    @When("^he attempts to change the (.*) to (.*), (.*) to (.*) of a employee$")
    public void updateAEmployeeInformation(String name,String newName,String branch,String newBranch) {
        WebElement branchDetails = databaseDetailsStep.getRecordDetails(name, branch);
        databaseDetailsStep.editARecord(branchDetails);
        databaseUpdateStep.inputEmployeeData(newName,newBranch);
    }

    @When("^Save the changes on Branch details form$")
    public void saveBranchDetails() {
        databaseUpdateStep.saveDataToDB();
    }
    @When("^Cancel the changes on Branch details form without saving$")
    public void cancelBranchChanges() {
        databaseUpdateStep.cancelSavingData();
    }


    @Then("^Branch (.*) updated with (.*), (.*)$")
    public void verifyBranchFound(String status,String newName,String newCode) {
        if(status.equalsIgnoreCase("is")){
            assertEquals("Branch details updated assertion",true, databaseDetailsStep.verifyRecordFound(newName,newCode));
        }else{
            databaseDetailsStep.searchForARecord(newName);
            assertEquals("Branch details NOT updated assertion",false, databaseDetailsStep.verifyRecordFound(newName,newCode));
        }
    }

    @When("^He attempts to delete a (.*) with details (.*), (.*)$")
    public void updateARecord(String recordType,String name,String code) {
        WebElement branchDetails = databaseDetailsStep.getRecordDetails(name, code);
        databaseDetailsStep.deleteARecord(branchDetails);
    }

    @When("^Delete the record using Delete option$")
    public void deleteBranchDetails() {
        databaseDetailsStep.deleteRecordProcess();
    }

    @When("^Cancel delete record process using Cancel option$")
    public void abortDeleteBranchProcess() {
        databaseDetailsStep.abortDeleteRecordProcess();
    }

    @When("^Record details (.*), (.*), (.*) deleted$")
    public void verifyIfRecordExist(String name,String code,String status) {
        if(status.equalsIgnoreCase("is")){
            assertEquals("Branch Deleted Verification",false, databaseDetailsStep.verifyRecordFound(name, code));
        }else{
            assertEquals("Branch Deleted Verification",true, databaseDetailsStep.verifyRecordFound(name, code));
        }
    }

}
