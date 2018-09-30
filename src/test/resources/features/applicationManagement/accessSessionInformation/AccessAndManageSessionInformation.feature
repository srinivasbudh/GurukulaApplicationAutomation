Feature: Verify session information is accessible

  In this feature user all the session related scenarios are verified

  @VerifyActiveSessionInformationIsAccessible
  Scenario: Verify active section information is displayed
    Given User is accessing session management view
    When He invalidate all the active sessions
    Then Session invalidated message is displayed
    And User is logged out successfully