Feature: Favorites

  Scenario: Verify Add to Favorite Functionality
    Given the user is on the home page
    When the user adds a product to favorites
    And the user opens the favorites page
    Then the favorites page should contain products
    When the user removes the product from favorites
    Then the favorites page should be empty