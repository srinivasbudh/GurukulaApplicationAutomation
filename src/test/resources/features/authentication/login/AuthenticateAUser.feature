Feature:  Authenticate valid users into the application

  In this feature all the valid users are authernticated into appication

  @verifyValidUserAuthenticationFailure @Regression @Smoke
  Scenario: Verify user with Invalid credentials is not authenticated into the application
    Given User is accessing the Login page
    When User authenticate with admin as login, password as password and Remember Login option
    Then user is not authenticated into the application

  @verifyValidUserIsAuthenticatedIntoSystem @Regression
  Scenario: Verify user with valid credentials is authenticated into the application
    Given User is accessing the Login page
    When User authenticate with admin as login, admin as password and don't Remember Login option
    Then user is authenticated into the application

  @VerifyLogoutFromApplication @Regression @Smoke
  Scenario: Verify Logout from the application and Database is not accessible
    Given User is Logged in into the application
    When Users Logout of the application
    Then User is logged out successfully

