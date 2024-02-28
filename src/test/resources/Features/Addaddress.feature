Feature: Bookswagon Personal Settings

  Background: to test the Login page
    Given the URL bookswagon website
    Then User clicks myaccount
    When User enters phone no 
    When User enters password 
    And the User clicks login button

  Scenario: User can add/edit and remove the Address
    When User clicks on My Address
    Then User clicks on remove address
    And User Confirms the removal of address
    Then User clicks on Add Address
    And User enters the FullName
    When User enters the StreetAddress
    Then User clicks the country dropdown
    And User clicks the state dropdown
    Then User clicks the City dropdown
    And User enters the Pin code
    Then User enters the Phone
    Then User clicks Update Option
    Then User clicks on Edit Address
    When User modifies the StreetAddress
    And User modifies the Pin code
    Then User clicks Update Option
    

    

    
