#
#Feature: Do the whole opt-in flow via API and validate the creation of a new prospect with their correct data.
#
#  Scenario: Do the Optin Flow
#    Given I start the flow by sending the Campaign Phrase from a SenderVirtualNumber to ReceiverVirtualNumber
#    And I send the prospect name
#    And I send the major selected
#    And I send the Statements
#    And I accept the terms and conditions
#    And I Log into the BackOffice with a real user
#    And I enter into the Prospects Section
#    Then I should see the new Prospect Created on the Backoffice