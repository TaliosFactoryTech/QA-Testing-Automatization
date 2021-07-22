Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given I enter the following for Login
      | username | password      |
      | admin    | password      |
    And I click login button
    And I wait for 3000 miliseconds
    Then I should see the Guides page
    And I click logout link

