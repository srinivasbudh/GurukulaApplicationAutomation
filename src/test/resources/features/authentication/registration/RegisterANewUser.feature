Feature: Register a new user

  In this feature all the possible flows of Registration are verified

  Background:
    Given Gurukula Application is accessible
    And  User is accessing Registration form

 @VerifyRegistrationIsNotPossibleIfAllMandatoryFieldsAreFilled
  Scenario Outline: Verify user registration is not possible when one of the mandatory fields are not supplied
    When User enters the <Name>, <E-mailId>, <newPassword>, <confirmPassword>
    Then Register option is not Enabled as Mandatory fields are missing
    Examples:
    | Name    | E-mailId      |  newPassword    | confirmPassword |
    | testuser| test@test.com |                 |                 |

 @ValidRegistrationOfAUser
  Scenario Outline: register a user on gurukula application with Valid parameters
    When User registers with <Name>, <E-mailId>, <newPassword>, <confirmPassword>
    Then Registration is <RegistrationStatus> with <Reason>
    Examples:
      | Name    | E-mailId      |  newPassword    | confirmPassword | RegistrationStatus| Reason         |
      | testuser| test1@test.com | Password123     | Password123    | Successful        | ValidParameters|

 @RegisterUserWithDifferentPasswords
 Scenario Outline: register a user on gurukula application with password mismatch
   When User registers with <Name>, <E-mailId>, <newPassword>, <confirmPassword>
   Then Registration is <RegistrationStatus> with <Reason>
   Examples:
      | Name      | E-mailId      |  newPassword    | confirmPassword | RegistrationStatus | Reason         |
      | seconduser| test2@test.com | Password123     | Password124     |     failed       | passwordMismatch|

 @RegisterWithExistingLoginName
 Scenario Outline: register a user on gurukula application with Existing userName
   When User registers with <Name>, <E-mailId>, <newPassword>, <confirmPassword>
   Then Registration is <RegistrationStatus> with <Reason>
   Examples:
      | Name    | E-mailId       |  newPassword    | confirmPassword | RegistrationStatus |Reason         |
      | admin   | test3@test.com | Password123     | Password123     |     failed         |userExist      |

 @RegisterWithExistingEmailId
 Scenario Outline: register a user on gurukula application with existing Email
   When User registers with <Name>, <E-mailId>, <newPassword>, <confirmPassword>
   Then Registration is <RegistrationStatus> with <Reason>
   Examples:
      | Name    | E-mailId         |  newPassword    | confirmPassword | RegistrationStatus |Reason         |
      | emailuser| admin@localhost | Password123     | Password123     |     failed         |emailExist     |
