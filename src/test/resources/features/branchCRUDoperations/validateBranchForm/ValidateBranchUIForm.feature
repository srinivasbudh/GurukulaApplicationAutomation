Feature: Validate UI fields of Branch creation form

  In this feature all the UI fields of Branch creation form are validated

  Background:
    Given User is trying to create a Branch

  @VerifyNameFieldOnBranchForm @UI
    Scenario Outline: Verify Name field on Branch form accepts only Alphabets
      When Users enters <Name> into Name text box
      Then Branch Name value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
      And  Branch Name error field has <ErrorText> Message
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
      | abcdefghijabcdefghijaa | is not       | has been        | This field cannot be longer than 20 characters.|
  @MinLengthFieldErrorOnCreateBranch
    Examples:
      | Name    | ValueStatus  | ErrorStatus     |ErrorText         |
      | abc     | is not       | has been        | This field is required to be at least 5 characters.|


  @VerifyCodeFieldOnBranchForm @UI
  Scenario Outline: Verify Code field on Branch form accepts only Alphanumeric values
    When Users enters <Code> into Code text box
    Then Then Code value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And  Code error field has <ErrorText> Message
  @NoErrorOnCreateBranch
    Examples:
      | Code    | ValueStatus | ErrorStatus |ErrorText |
      | AMS01   | is          | is not      | No error  |
  @MandatoryFieldErrorOnCreateBranch
    Examples:
      | Code    | ValueStatus | ErrorStatus |ErrorText             |
      |         | is not       | has been        | This field is required.|
  @WrongPatternOnCreateBranch
    Examples:
      | Code    | ValueStatus | ErrorStatus    |ErrorText             |
      | Ams01   | is not       | has been       | This field should follow pattern ^[A-Z0-9]*$.|

  @MaxLengthFieldErrorOnCreateBranch
    Examples:
      | Code                   | ValueStatus  | ErrorStatus     |ErrorText         |
      | AMS001001011           | is not       | has been        | This field cannot be longer than 10 characters.|
  @MinLengthFieldErrorOnCreateBranch
    Examples:
      | Code    | ValueStatus  | ErrorStatus     |ErrorText         |
      | A     | is not       | has been        | This field is required to be at least 2 characters.|
