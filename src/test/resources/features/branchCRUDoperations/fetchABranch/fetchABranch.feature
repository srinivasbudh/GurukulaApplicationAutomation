Feature: Fetch a Branch from Gurukula Database

  In this feature we verify all the possible flows of fetch a record

  @VerifyIfAUserCanFetchARecordWithExistingData @Regression
  Scenario Outline: : Verify user can fetch a record when search with a Exact value
    Given User is accessing all branches information
    When he search for a branch with existing <NameOrCode>, <Value>
    Then Branch with <NameOrCode>, <Value>,<Value2>  is Retrieved
   @SearchForABranchUsingName
    Examples:
    | NameOrCode | Value     | Value2 |
    | Name       | HYDERABAD | INDOF1 |
  @SearchForABranchUsingCode
    Examples:
      | NameOrCode | Value     | Value2     |
      | Code       | INDOF1    | HYDERABAD  |

  @VerifyBranchIsNotFoundWhenUserDoesAPartialSearch @Regression
  Scenario Outline: : Verify user can't fetch a record when search with a Partial value
    Given User is accessing all branches information
    When he search for a branch with existing <NameOrCode>, <Value>
    Then No Branches are found
  @SearchForABranchUsingPartialName
    Examples:
      | NameOrCode | Value     |
      | Name       | Amste     |
  @SearchForABranchUsingPartailCode
    Examples:
      | NameOrCode | Value     |
      | Code       | EUH       |
