Feature: Manage account settings

  In this feature all the account settings verifications are tested

  @VerifyUserCanUpdateHisDetailsFromAccountSettings @Regression
  Scenario Outline: Verify user can update his details from accountSetting
    Given User is accessing Account settings Page
    When He attempts to change his <FieldName> from <ExistingValue> to <NewValue>
    And Save the changes on Account settings screen
    Then Account settings are saved successfully
    And The <NewValue> is reflected for <FieldName> on user profile
    Examples:
      |FieldName  | ExistingValue  | NewValue |
      |name       | Administrator  | Admin    |
      |email      | admin@localhost| admin@admin.com|

  @VerifyUserDetailsAreNotUpdatedWhenNotSaved @Regression
  Scenario Outline: Verify user details are not updated When save button is not clicked
    Given User is accessing Account settings Page
    When He attempts to change his <FieldName> from <ExistingValue> to <NewValue>
    And Cancel the changes on Account settings screen
    Then The <NewValue> is not updated for <FieldName> on user profile
    Examples:
      |FieldName  | ExistingValue  | NewValue        |
      |name       | Administrator  | Value Change    |


  @VerifyPasswordChangeProcess @Regression @Smoke
  Scenario Outline: Verify user is able to reset his password from change password screen
    Given User is accessing change password screen
    When He attempts to change his password using <Password> and <ConfirmPassword>
    Then Password change <Status> successful
    @PasswordChangeSuccessful
    Examples:
    | Password   |  ConfirmPassword | Status  |
    | PassW0rd@  |  PassW0rd@       | is      |
    @PasswordMismatchAssertion
    Examples:
    | Password   |  ConfirmPassword | Status  |
    | PassW0rd@  |  wrongText       | is not  |
