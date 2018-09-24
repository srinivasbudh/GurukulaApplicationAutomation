Feature: Gurukula Application accessibility

  In this feature application initial status is verified

  @VerifyApplicationIsLaunchedAndValidate @UI
    Scenario: Verify application is Launched and initial screen is loaded properly
    Given Gurukula Application is Launched
    When Initial home Page is accessible
    Then Verify login option is available
    And  Verify Registration option is available
