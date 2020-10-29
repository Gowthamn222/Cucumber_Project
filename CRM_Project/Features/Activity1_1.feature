@activity1_1
Feature: CRM Dashlets Count

Scenario: Open the homepage and count the number of the dashlets on the page
    Given User Open the browser with ​Alchemy CRM​ site and login
    Then Count the number of Dashlets on the page
    And Print the number and title of each Dashlet
    And Close browser