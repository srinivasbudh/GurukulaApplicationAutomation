Feature: Delete a Staff from Gurukula database

  In this feature all the possible flows of delete employee are verified

  @VerifyDeleteEmployeeIsSuccessful @Regression @Smoke
  Scenario: Verify employee is deleted upon Clicking Delete button
    Given User is accessing all employees information
    When He attempts to delete a employee with details Resigned Employee, New York
    And Delete the record using Delete option
    Then Record details Resigned Employee, New York, is deleted


  @VerifyDeleteEmployeeFlowAborted @Regression
  Scenario: Verify employee is not deleted upon Clicking Cancel button
    Given User is accessing all employees information
    When He attempts to delete a employee with details First Employee, Amsterdam
    And Cancel delete record process using Cancel option
    Then Record details First Employee, Amsterdam, is not deleted

