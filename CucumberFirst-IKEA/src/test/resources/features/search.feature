Feature: Product Search

  Scenario: Verify that the search bar returns relevant product results
    Given the user is on the IKEA home page
    When the user searches for "bed"
    Then the displayed products should be related to "bed"