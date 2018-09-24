Feature: Validate Input fields of Registration

  In this feature all the Ui validations on Registration screen are performed

  Background:
    Given Gurukula Application is accessible
    And  User is accessing Registration form


  @ValidateLoginTextFieldOnRegistration @UI
  Scenario Outline: Verify Login field on registration is only lower-case letters and digits
    When User enters <LoginName> into Login field
    Then Login value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And Login error field has <ErrorText> Message
  @NoErrorOnLogin
    Examples:
      | LoginName    | ValueStatus | ErrorStatus |ErrorText       |
      | testuser     | is          | is not      | No         |
  @MandatoryFieldErrorOnLogin
    Examples:
      | LoginName    | ValueStatus | ErrorStatus |ErrorText             |
      |              | is not       | has been        | Your login is required.|
  @WrongPatternOnLogin
    Examples:
      | LoginName    | ValueStatus | ErrorStatus    |ErrorText             |
      | Abc          | is not       | has been        | Your login can only contain lower-case letters and digits.|
      | abc A        | is not       | has been        | Your login can only contain lower-case letters and digits.|
      | A123         | is not       | has been        | Your login can only contain lower-case letters and digits.|
  @MaxLengthFieldErrorOnLogin
    Examples:
      | LoginName                                                 | ValueStatus  | ErrorStatus     |ErrorText             |
      | abcdefghij01234567890123456789abcdefghij0123456789145sfasd| is not       | has been        | Your login cannot be longer than 50 characters.|

  @ValidateEmailTextFieldOnRegistration @UI
  Scenario Outline: Verify Email field accepts only valid Registration Formats
    When User enters <E-mailId> into email field
    Then Email value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And Email error field has <ErrorText> Message
  @NoErrorOnEmail
    Examples:
      | E-mailId     | ValueStatus | ErrorStatus |ErrorText       |
      | test@test.com| is          | is not      | No             |

  @MandatoryFieldErrorOnEmail
    Examples:
      | E-mailId     | ValueStatus | ErrorStatus |ErrorText       |
      |              | is not       | has been        | Your e-mail is required.|
  @WrongPatternOnEmail
    Examples:
      | E-mailId     | ValueStatus | ErrorStatus      |ErrorText             |
      | qw,e@123.com | is not      | has been         | Your e-mail is invalid.|
      | admin@admin  | is not      | has been         | Your e-mail is invalid.|
      | admin.com    | is not      | has been         | Your e-mail is invalid.|
  @MaxLengthFieldErrorOnEmail
    Examples:
      | E-mailId                                                          | ValueStatus | ErrorStatus     |ErrorText             |
      | abcdefghij01234567890123456789abcdefghij0123456789145sfasd@seb.com| is not      | has been        | Your e-mail cannot be longer than 50 characters.|
  @MinLengthFieldErrorOnEmail
    Examples:
      | E-mailId  | ValueStatus | ErrorStatus     |ErrorText             |
      | a@12      | is not      | has been        | Your e-mail is required to be at least 5 characters.|

  @ValidatePasswordTextFieldOnRegistration @UI
  Scenario Outline: Verify password field accepts only valid Registration Formats
    When User enters <Password> into Password field
    Then Password value <ValueStatus> Accepted, Error Message <ErrorStatus> Displayed
    And Password error field has <ErrorText> Message
  @NoErrorOnPassword
    Examples:
      | Password     | ValueStatus | ErrorStatus |ErrorText       |
      | Pwd@123      | is          | is not      | No             |
  @WrongPatternOnPassword
    Examples:
      | Password     | ValueStatus | ErrorStatus      |ErrorText             |
      | password     | is not      | has been         | Password should begin with a alphabet and should contain a number and a special character.|

  @MaxLengthFieldErrorOnPassword
    Examples:
      |Password                                                   | ValueStatus| ErrorStatus     |ErrorText           |
      | abcdefghij01234567890123456789abcdefghij0123456789145sfasd| is not      | has been        | Your password cannot be longer than 50 characters.|
  @MinLengthFieldErrorOnPassword
    Examples:
      | Password  | ValueStatus | ErrorStatus     |ErrorText             |
      | a@12      | is not      | has been        | Your password is required to be at least 5 characters.|
