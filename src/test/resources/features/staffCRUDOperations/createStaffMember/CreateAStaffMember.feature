Feature: Create a Staff member on Gurukula application

  In this feature all the possibilities of create a staff are verified

  @VerifyCreationOfAStaffMember @Regression @Smoke
  Scenario Outline: Verify creation of staff is successful when valid parameters are provided
    Given User is trying to create a Employee
    When Users creates a employee with details <Name> and <Branch>
    Then Employee <creationStatus> created with details <Name> and <Branch> in database
  @CreationOfBranchWithValidInputs
    Examples:
      | Name              | Branch       |  creationStatus |
      | First Employee    | Amsterdam    | is              |
      | SecondEmployee    | HYDERABAD    | is              |
      | CEO               |              | is              |
      | Resigned Employee | New York  | is              |

  @CreationOfBranchWithInvalidName
    Examples:
      | Name         | Branch    |  creationStatus |
      | Chennai_new  | Amsterdam | is not          |