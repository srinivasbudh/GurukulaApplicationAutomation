Feature: Validate the View of Login form and other components

  In this feature we validate Login UI and its features

  @VerifyRegistrationFromNavigation @UI
  Scenario: Verify navigation to Registration is possible from Login screen
    Given User is accessing the Login page
    When User clicks on Registration Link
    Then Registration form is accessible

  @VerifyResetPasswordFormNavigation @UI
  Scenario: Verify navigation to Reset password is possible from Login screen
    Given User is accessing the Login page
    When User clicks on Reset password Link
    Then Reset password form is accessible

