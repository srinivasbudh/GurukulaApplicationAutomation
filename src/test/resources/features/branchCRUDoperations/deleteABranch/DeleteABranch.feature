Feature: Delete a branch from Gurukula database

  In this feature all the possible flows of delete

 @VerifyDeleteBranchIsSuccessful @Regression
 Scenario: Verify branch is deleted upon Clicking Delete button
  Given User is accessing all branches information
  When He attempts to delete a Branch with details Delete, DUM02
  And Delete the record using Delete option
  Then Record details Delete, DUM02, is deleted


 @VerifyDeleteBranchFlowAborted @Regression
 Scenario: Verify branch is not deleted upon Clicking Cancel button
  Given User is accessing all branches information
  When He attempts to delete a Branch with details Santa Clara, HOF1
  And Cancel delete record process using Cancel option
  Then Record details Santa Clara, HOF1, is not deleted

