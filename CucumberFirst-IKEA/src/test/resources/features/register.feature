Feature: Registration

  Scenario: Verify that a new user can register successfully
    Given the user is on the IKEA home page
    When the user navigates to the Create Account page
    And the user enters valid registration details
    And the user accepts the terms
    And the user clicks the Create Account button
    Then the account should be created successfully


  Scenario: Verify that a user can't register with the same email again
    Given the user is on the IKEA home page
    When the user navigates to the Create Account page
    And the user enters an existing email
    And the user accepts the terms
    And the user clicks the Create Account button
    Then an email already exists error should be displayed