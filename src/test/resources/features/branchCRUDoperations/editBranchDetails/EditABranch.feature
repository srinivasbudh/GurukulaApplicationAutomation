Feature: Edit a branch on Gurukula Application

  In this feature we verify the if user can edit existing record

  @VerifyUserCanEditAnExistingRecord
  Scenario Outline: verify user can edit an existing record
    Given User is accessing all the branches
    When he attempts to change the <Name> to <NewName>, <Code> to <NewCode>
    And Save the changes on Branch details form
    Then Branch is updated with <NewName>, <NewCode>
    Examples:
    | Name        |  NewName      | Code   | NewCode |
    | AmsterDam   | Rotterdam     | EUHOF1 | EUHF02  |

  @VerifyUserRecordsAreNotUpdatedWhenChangesNotSaved
  Scenario Outline: verify user A record is not Updated when Changes are not Saved
    Given User is accessing all the branches
    When he attempts to change the <Name> to <NewName>, <Code> to <NewCode>
    And Cancel the changes on Branch details form without saving
    Then Branch is not updated with <NewName>, <NewCode>
    Examples:
      | Name          |  NewName      | Code    | NewCode |
      | HYDERABAD     | SECUNDERABAD  | INDOF1  | HYDOF01 |