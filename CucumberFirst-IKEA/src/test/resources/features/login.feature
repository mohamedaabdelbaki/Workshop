
  Feature: User Login
  Scenario: Verify that an existing user can log in
    Given the user is on the login page
    When the user enters the previously registered email and valid password
    And the user clicks the "Login" button
    Then the user should be logged in successfully


    Scenario: Verify that user can't log in with invalid credentials
      Given the user is on the login page
      When the user enters a valid email and an invalid password
      And the user clicks the "Login" button
      Then a login error message should be displayed