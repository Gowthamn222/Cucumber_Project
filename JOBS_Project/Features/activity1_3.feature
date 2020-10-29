
@activity1_3
Feature: Posting a job

Scenario: Post a job using details present in the Feature file 
    Given Open browser with Alchemy Jobs site
    When Navigate to Post a Job page
    Then Enter the "user01@gmail.com", "Automation Tester 01", "Bangalore", "This is test job", "user01@gmail.com", "IBM India Pvt. Ltd." details and click on the Preview button
    Then Click submit
    Then Navigate to the Jobs page
    And Verify job listing "Automation Tester 01" is shown on page
    And Close Browser
