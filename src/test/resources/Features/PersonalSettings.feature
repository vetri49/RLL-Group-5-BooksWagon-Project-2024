Feature: Bookswagon Personal Settings

  Background: User want to login into account
    Given User navigates to the webpage
    When User try to login in the account
    Then Validate the login is successful

  Scenario: User can be able to update the personal settings
    Given User clicks on Your account
    And User clicks on Personal Settings
    When User add E-mail Id
    And User add Mobile Number
    And User Can Click Captcha for security setting
    Then User click the update button
    And enters generated OTP in the E-mail
    And clicks on verify button

  Scenario: User can not be able update the personal settings without filling mandatory deatils
    Given User clicks on Your account
    And User clicks on Personal Settings
    When User add Mobile Number
    And User Can Click Captcha for security setting
    Then User click the update button
    And User can not update the details
