Feature: Verify search functionality
  Background:
    Given Navigate to BH home page



  @SearchBox
  Scenario: Verify search Box On Homepage
    When Click on search icon on top right corner
    Then Verify if search field is visible on the page
    And Enter "Employee Education in 2018: Strategies to Watch" in search field
    And click on Search button under Search Bright Horizons
    Then Verify if the first search result is exact match to provided search key

  @FindCenter
  Scenario: Verify if center name and address are the same (on the list and on the popup)
    When Click on Find a Center option on top header
    And Verify page contains "/child-care-locator" as a part of its URL
    And Type "New York" into search box and press Enter
    And verify if a number of found centers is the same as a number of centers displayed in list
    And Click on the first center on the list
    Then Verify if center name and address are the same (on the list and on the popup)