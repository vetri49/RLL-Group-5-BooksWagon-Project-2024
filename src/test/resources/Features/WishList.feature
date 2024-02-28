Feature: to test the Books Wagon page on chrome browser

  Background: to test the Login page
    Given the URL of bookswagon website
    Then click on myaccount option
    When the User enters phone no
    When the User enters password
    And the User clicked on the login button

  Scenario Outline: to test the My Wishlist page
    When User click on My Wishlist
    When User search for a book titled '<samplebook>'
    And User click on the Add to Wishlist button
    When User click on My Wishlist
    Then User should see the list of books in my wishlist
    And User can remove a book from my wishlist
    Then User should see a message indicating that my wishlist is empty '<Result>'

    Examples: 
      | samplebook | Result                                  |
      | Ikigai     | You do not have any item(s) in Wishlist |
