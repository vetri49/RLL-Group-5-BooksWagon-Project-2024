@tag
Feature: Test the functionality of requesting book
  I want to test the functionality of requesting book from BooksWagon website

  @tag1
  Scenario Outline: Requesting a book which is unavailable one
    Given I want to Open a website in browser
    And clicks on request book
    When enter a ISBN13 number '<isbn>'
    And enter a book title '<title>'
    And enter and verify your mailid
    Then submit the request
    And check the results

    Examples: 
      | isbn           | title                                                                      |
      | 978-1934356807 | The Cucumber Book: Behaviour-Driven Development for Testers and Developers |

  @tag2
  Scenario Outline: Requesting a book with invalid ISBN13 number
    Given I want to Open a website in browser
    And clicks on request book
    When enter a ISBN13 number '<ISBN>'
    And enter a book title '<Title>'
    And enter and verify your mailid
    Then submit the request
    And check the results

    Examples: 
      | ISBN       | Title                  |
      | 9724y29529 | Computer Applications  |
      | 387o225849 | Network of thinking    |
      | 7836782c27 | Pragramatic programmer |
