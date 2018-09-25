Feature: Delete a branch from Gurukula database

  In this feature all the possible flows of delete

 @VerifyDeleteBranchIsSuccessful @Second
 Scenario: Verify branch is deleted upon Clicking Delete button
  Given User is accessing all the branches
  When He attempts to delete a Branch with details Amsterdam, AMS001
  And Delete the record using Delete option
  Then Record details Amsterdam, AMS001, is not deleted

 @VerifyDeleteBranchFlowAborted
 Scenario: Verify branch is not deleted upon Clicking Cancel button
  Given User is accessing all the branches
  When He attempts to delete a Branch with details Santa Clara, HOF1
  And Cancel delete record process using Cancel option
  Then Record details Santa Clara, HOF1, is deleted

