Feature: Edit Staff details on Gurukula Application

  In this feature we verify the if user can edit existing record

  @VerifyUserCanEditAnExistingEmployeeDetails @Regression @Smoke
  Scenario Outline: verify user can edit an existing EmployeeDetails
    Given User is accessing all employees information
    When he attempts to change the <Name> to <NewName>, <Branch> to <NewBranch> of a employee
    And Save the changes on Branch details form
    Then Employee is updated with <NewName>, <NewBranch>
    Examples:
      | Name          |  NewName          | Branch   | NewBranch |
      | SecondEmployee| Testuser          | HYDERABAD| Amsterdam  |


  @VerifyUserRecordsAreNotUpdatedWhenChangesNotSaved @Regression
  Scenario Outline: verify user A record is not Updated when Changes are not Saved
    Given User is accessing all employees information
    When he attempts to change the <Name> to <NewName>, <Branch> to <NewBranch> of a employee
    And Cancel the changes on Branch details form without saving
    Then Employee is not updated with <NewName>, <NewBranch>
    Examples:
      | Name          |  NewName      | Branch    | NewBranch|
      | First Employee| Random        | Amsterdam  | HYDERABAD |