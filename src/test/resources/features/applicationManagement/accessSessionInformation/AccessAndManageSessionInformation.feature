Feature: Verify session information is accessible

  In this feature user all the session related scenarios are verified

  @VerifyActiveSessionCanBeTerminated @Regression @Smoke
  Scenario: Verify active session can be Invalidated and user access is revoked
    Given User is accessing session management view
    When He invalidate all the active sessions
    Then Session invalidated message is displayed
    And User is logged out successfully