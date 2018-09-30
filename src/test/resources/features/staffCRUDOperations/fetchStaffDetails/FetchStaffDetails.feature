Feature: Fetch a Employee from Gurukula Database

  In this feature we verify all the possible flows of fetch a record

  @VerifyIfAUserCanFetchAEmployeeWithExistingData @Regression @Smoke
  Scenario Outline: : Verify user can fetch a Employee when search with a Exact value
    Given User is accessing all employees information
    When he search for a branch with existing <NameOrBranch>, <Value>
    Then Employee with <NameOrBranch>, <Value>,<Value2> is Retrieved
  @SearchForAEmployeeUsingName
    Examples:
      | NameOrBranch | Value          | Value2    |
      | Name         | First Employee | Amsterdam |
  @SearchForAEmployeeUsingCode
    Examples:
      | NameOrBranch | Value     | Value2         |
      | Branch       | HYDERABAD | SecondEmployee |

  @VerifyEmployeeIsNotFoundWhenUserDoesAPartialSearch @Regression
  Scenario Outline: : Verify user can't fetch a record when search with a Partial value
    Given User is accessing all employees information
    When he search for a branch with existing <NameOrCode>, <Value>
    Then No Employees are found
  @SearchForABranchUsingPartialName
    Examples:
      | NameOrCode | Value     |
      | Name       | Amste     |
  @SearchForABranchUsingPartailCode
    Examples:
      | NameOrCode | Value     |
      | Code       | EUH       |
