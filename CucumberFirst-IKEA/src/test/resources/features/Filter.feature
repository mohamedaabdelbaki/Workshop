Feature: Sort Products

  Scenario: Verify Filtering by Category
    Given the user is on the home page
    When the user searches for "Living room"
    And the user clicks the search button
    And the user opens the filter
    And the user selects Price Low to High
    Then the products should be sorted from low to high