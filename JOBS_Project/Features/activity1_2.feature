
@activity1_2
Feature: Searc for jobs

Scenario: Searchfor jobs and applying to them using XPath
    Given Open browser with Alchemy Jobs site​ and navigate to Jobs page
    And Find the search input field
    Then Type in keywords to search for jobs and change Job type
    And Filter job type to show only Full Time jobs
    Then Find a job listing using XPath
    And Find the title of the job and print it to the console
    Then Click on the Apply for job button
    And Close the Browser