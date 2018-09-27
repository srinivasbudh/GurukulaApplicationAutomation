Feature: Validate all the UI fields and interactions of staff creation flow

  In this feature all the fields of staff creation flow are Validated

  Background:
    Given User is trying to create a Employee

  @VerifyNameFieldOnStaffForm @UI
  Scenario Outline: Verify Name field on Staff form accepts only Alphabets
    When Users enters <Name> into Name text box
    Then Employee Name value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And  Employee Name error field has <ErrorText> Message
  @NoErrorOnCreateBranch
    Examples:
      | Name    | ValueStatus | ErrorStatus |ErrorText |
      | testuser| is          | is not      | No error  |
  @MandatoryFieldErrorOnCreateBranch
    Examples:
      | Name    | ValueStatus | ErrorStatus |ErrorText             |
      |         | is not       | has been        | This field is required.|
  @WrongPatternOnCreateBranch
    Examples:
      | Name    | ValueStatus | ErrorStatus    |ErrorText             |
      | TestUser1| is not       | has been        | This field should follow pattern ^[a-zA-Z\s]*$.|

  @MaxLengthFieldErrorOnCreateBranch
    Examples:
      | Name                   | ValueStatus  | ErrorStatus     |ErrorText         |
      | abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijaa | is not       | has been        | This field cannot be longer than 50 characters.|
