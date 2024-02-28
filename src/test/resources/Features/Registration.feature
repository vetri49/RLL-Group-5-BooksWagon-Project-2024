Feature: to test the Books Wagon for register page

  @Register
  Scenario Outline: to test the Login page
    Given hit the URL of bookswagon website
    Then user open the myaccount option
    And user clicks on new user option
    When user enters full name as '<name>'
    When user enters phone no as '<phone>'
    Then user clicks on continue button
    When user enter password as '<password>'
    And user enter confirm-password as '<confirm-password>'
    And the User press on the register button

    Examples: 
      | name | phone      | password | confirm-password |
      | Jaya | 8310226624 | Jaya@111 | Jaya@111         |
