
@activity1_1
Feature: Create a new user

Scenario: Enter the site’s backend and create a new user
    Given Open a browser
    When Navigate to Alchemy Jobs and log in
    Then Click the menu item Users
    And Click on Add New Button
    Then Fill in the required details
    And Click on Add New User button
    Then Verify that the user is created
    And Close the browser
