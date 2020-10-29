
@activity1_2
Feature: Adding a candidate for recruitment

Scenario: Add information about a candidate for recruitment
    Given Open the OrangeHRM​ page and login with the credentials
    When Navigate to the Recruitment page and click on the Add button
    Then On the next page update the details of candidate
    And Upload a resume doc or pdf    
    And Click Save
    And Close the Browser