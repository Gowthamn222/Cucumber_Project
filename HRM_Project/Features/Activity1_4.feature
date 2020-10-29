
@activity1_4
Feature: Creating multiple vacancies

Scenario Outline: Creating multiple vacancies
    Given Open the OrangeHRM​ page and login with given credentials
    When Navigate to Recruitment page
    Then Click on Vacancies menu item
    And Click on Add button
    Then Fill out the required details "<vacancyName>"
    And Click the Save button to save the vacancy
    And Close browser
    
Examples: 
      | vacancyName |
      | DevOps_Vacancy_001 |
      | DevOps_Vacancy_002 |
      