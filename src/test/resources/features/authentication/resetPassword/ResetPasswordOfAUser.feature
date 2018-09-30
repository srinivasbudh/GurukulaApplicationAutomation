Feature: Reset password of a user and validate other fields

  This feature is to verify the UI validations of Reset Password flow
  Also to validate reset password functions

  @VerifyResetPasswordForAValidEmail @Regression @Smoke
  Scenario: Verify reset password for a valid email is successful
    Given User is accessing the Reset password form
    When User attempts to reset password for admin@localhost
    Then Email sent for password reset message is Displayed

  @VerifyResetPasswordForAInvalidValidEmail @Regression
  Scenario: Verify reset password for a Invalid email is not successful
    Given User is accessing the Reset password form
    When User attempts to reset password for test@test.com
    Then Email doesn't exist message is Displayed

  @ValidateEmailTextFieldOnResetPassword @UI
  Scenario Outline: Verify Email field accepts only valid Registration Formats
    Given User is accessing the Reset password form
    When User enters <E-mailId> into email field
    Then Email value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And Email error field has <ErrorText> Message
  @NoErrorOnEmailOnResetPassword
    Examples:
      | E-mailId     | ValueStatus | ErrorStatus |ErrorText       |
      | test@test.com| is          | is not      | No             |

  @MandatoryFieldErrorOnEmailOnResetPassword
    Examples:
      | E-mailId     | ValueStatus | ErrorStatus |ErrorText       |
      |              | is not       | has been        | Your e-mail is required.|
  @WrongPatternOnEmailOnResetPassword
    Examples:
      | E-mailId     | ValueStatus | ErrorStatus      |ErrorText             |
      | qw,e@123.com | is not      | has been         | Your e-mail is invalid.|
      | admin@admin  | is not      | has been         | Your e-mail is invalid.|
      | admin.com    | is not      | has been         | Your e-mail is invalid.|
  @MaxLengthFieldErrorOnEmailOnResetPassword
    Examples:
      | E-mailId                                                          | ValueStatus | ErrorStatus     |ErrorText             |
      | abcdefghij01234567890123456789abcdefghij0123456789145sfasd@seb.com| is not      | has been        | Your e-mail cannot be longer than 50 characters.|
  @MinLengthFieldErrorOnEmailOnResetPassword
    Examples:
      | E-mailId  | ValueStatus | ErrorStatus     |ErrorText             |
      | a@12      | is not      | has been        | Your e-mail is required to be at least 5 characters.|

