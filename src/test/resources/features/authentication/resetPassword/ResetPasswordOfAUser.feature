Feature: Reset password of a user and validate other fields

  This feature is to verify the UI validations of Reset Password flow
  Also to validate reset password functions

  @VerifyResetPasswordForAValidEmail
  Scenario: Verify reset password for a valid email is successful
    Given User is accessing the Reset password form
    When User attempts to reset password for admin@localhost
    Then Email sent for password reset message is Displayed

  @VerifyResetPasswordForAInvalidValidEmail
  Scenario: Verify reset password for a Invalid email is not successful
    Given User is accessing the Reset password form
    When User attempts to reset password for test@test.com
    Then Email doesn't exist message is Displayed
