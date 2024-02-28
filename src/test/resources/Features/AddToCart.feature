Feature: To test the bookswagon page for shopping cart

  Scenario Outline: Shopping cart functionality
    Given user navigates home page
    When user enters '<ProductName>'
    And user clicks on add to cart
    And user clicks on Go to cart
    Then user adds the quantity
    And user reduce the quantity
    Then message should be displayed

    Examples: 
      | ProductName                 |
      | when No One Is Watching     |
      
