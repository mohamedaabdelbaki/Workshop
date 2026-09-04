Feature: Home Page

  Scenario: Verify that clicking on a product opens the product details page
    Given the user is on the home page
    When the user stores the selected product name
    And the user clicks on the selected product
    Then the product name should match the selected product

  Scenario: Verify that a product can be added to the shopping cart
    Given the user is on the home page
    When the user clicks on the Lighting category
    And the user opens the Lamps category
    And the user adds the product to the bag
    And the user adds the same product to the bag again
    And the user opens the shopping bag
    Then the quantity displayed in the bag should be 2