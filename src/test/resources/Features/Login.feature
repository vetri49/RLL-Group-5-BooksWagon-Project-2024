Feature: To test the functionality of Books Wagon page for login page

  @E2E
  Scenario: Login with valid credentials
    Given click on the URL of bookswagon website
    Then user clicks on myaccount option
    When User enters valid credentials from Excel sheet
    And the User press on the login button
    Then the user should be successfully logged in

  @E2E
  Scenario: Login with invalid credentials
    Given click on the URL of bookswagon website
    Then user clicks on myaccount option
    When User enters invalid credentials from Excel sheet
    And the User press on the login button
    Then the user should see an error message for wrong password/wrong username
