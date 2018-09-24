Feature:  Authenticate valid users into the application

  In this feature all the valid users are authernticated into appication

  @verifyValidUserAuthenticationFailure
  Scenario: Verify user with Invalid credentials is not authenticated into the application
    Given User is accessing the Login page
    When User authenticate with admin as login, password as password and Remember Login option
    Then user is not authenticated into the application

  @verifyValidUserIsAuthenticatedIntoSystem
  Scenario: Verify user with valid credentials is authenticated into the application
    Given User is accessing the Login page
    When User authenticate with admin as login, admin as password and don't Remember Login option
    Then user is authenticated into the application



