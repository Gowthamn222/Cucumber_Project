
@activity1_1
Feature: Create a job vacancy

Scenario: To create a job vacancy for “DevOps Engineer”
    Given Open the OrangeHRM​ page and login with credentials
    When Navigate to the Recruitment page
    Then Click on the Vacancies menu item
    And Click on the Add button
    Then Fill out the required details
    And Click the “Save” button 
    And Close the browser