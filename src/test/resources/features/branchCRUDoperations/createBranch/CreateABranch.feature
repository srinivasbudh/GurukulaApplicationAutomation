Feature: Create a Branch on Gurukula application

  In this feature all the possibilities of create a branch are verified

  @VerifyCreationOfBranch @Regression
  Scenario Outline: Verify creation of branch is successful when valid parameters are provided
    Given User is trying to create a Branch
    When Users creates a branch with details <Name> and <Code>
    Then Branch <creationStatus> created with details <Name> and <Code> in database
  @CreationOfBranchWithValidInputs
    Examples:
      | Name         | Code    |  creationStatus |
      | Santa Clara  | HOF1    | is              |
      | Amsterdam    | EUHOF1  | is              |
      | HYDERABAD    | INDOF1  | is              |
      | Delete       | DUM02   | is              |

  @CreationOfBranchWithInvalidName
    Examples:
      | Name         | Code    |  creationStatus |
      | Chennai_new  | MAA     | is not          |

  @CreationOfBranchWithInvalidCode
    Examples:
      | Name         | Code    |  creationStatus |
      | Los Angels   | LAnew   | is not          |

  @CreationOfDuplicateBranch
    Examples:
      | Name         | Code    |  creationStatus |
      | Santa Clara  | HOF1    | is not          |
