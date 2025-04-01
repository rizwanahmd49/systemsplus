Feature: Search product in Flipkart


  @FlipkartSearch
  Scenario: Search product in Flipkart and verify if the first search result is exact match to provided search key

    Given I am on Flipkart "plus" home page
    When I enter "Macbook" in search field
    And click on Search button on top right to search  box
    Then Verify if the first search result contains "Macbook" in results


  @SelectFromSuggestion
  Scenario: Verify autocomplete functionality in Flipkart search box
    Given I am on Flipkart "plus" home page
    When I enter "Macbook" in search field
    And I select "mackbook air m4 bag" from suggestion

