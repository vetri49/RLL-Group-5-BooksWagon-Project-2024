#Author: prajwal.diwakar@bookswagon.com
Feature: Award winners/sort By
  I want to Navigate to Award winners page of the application and test the sorting.

  Background: Launching of the chrome browser and entering the url
    Given User launches the chrome browser
    When User enters the URL "https://www.bookswagon.com/"
    And User clicks on the Award winners field

  @Bookswagon
  Scenario: Navigate to the Award winners page and sorting operation
    Then User validates the Page
    When User clicks on the checkbox of Paper Back
    Then User validates the sorted page after clicking to Paper Back
    When User unchecks the Paper Back
    And User clicks on Dropdown
    And User clicks on Low to High
    Then User validates the sorted page after clicking to Low to High

  @BookswagonAddToCart
  Scenario Outline: Sorting Award winners page and adding the product to cart
    When User clicks on Dropdown
    And User clicks on High to Low
    Then User validates the "<title1>" of the page
    When User clicks on Dropdown
    And User clicks on Discount
    And User clicks on the checkbox of Paper Back
    And User clicks the product and adds to cart
    Then User validates the add to cart "<title2>" of the page

    Examples: 
      | title1                                                                           | title2                                                                         |
      | Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com | Buy How to Write a Mystery Books By Lee Child at Bookswagon & Get Upto 50% Off |
