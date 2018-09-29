Feature: Validate all the UI fields and interactions of staff creation flow

  In this feature all the fields of staff creation flow are Validated


  @VerifyNameFieldOnStaffForm @UI
  Scenario Outline: Verify Name field on Staff form accepts only Alphabets
    Given User is trying to create a Employee
    When Users enters <Name> into Name text box
    Then Employee Name value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And  Employee Name error field has <ErrorText> Message
  @NoErrorOnCreateEmployee
    Examples:
      | Name    | ValueStatus | ErrorStatus |ErrorText |
      | testuser| is          | is not      | No error  |
  @MandatoryFieldErrorOnCreateEmployee
    Examples:
      | Name    | ValueStatus | ErrorStatus |ErrorText             |
      |         | is not       | has been        | This field is required.|
  @WrongPatternOnCreateEmployee
    Examples:
      | Name    | ValueStatus | ErrorStatus    |ErrorText             |
      | TestUser1| is not       | has been        | This field should follow pattern ^[a-zA-Z\s]*$.|

  @MaxLengthFieldErrorOnCreateEmployee
    Examples:
      | Name                   | ValueStatus  | ErrorStatus     |ErrorText         |
      | abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijaa | is not       | has been        | This field cannot be longer than 50 characters.|

  @VerifyPageNavigationButtonsAreNotEnabledWhenEmployeesAreNotFound @UI
  Scenario: Verify user can not access page navigation buttons when there are no buttons
    Given User is accessing all employees information
    When he search for a branch with existing Name, NoRecord
    Then No Employees are found
    And Page navigation buttons are disabled
