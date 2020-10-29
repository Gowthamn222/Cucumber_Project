
@activity1_2
Feature: Create leads

Scenario: Open the Leads page and add multiple lead accounts
    Given Open the browser with ​Alchemy CRM​ site and login
    Then Navigate to Sales -> Leads -> Create Lead
    And Fill in "STest_001", "LTest_001" details to create lead accounts
    Then Click Save Leads
    And Navigate to the View Leads page for results
    And Close Browser