
@activity1_3
Feature: Add multiple employees

Scenario Outline: Add multiple employees
    Given Open the OrangeHRM​ page and login with the given credentials
    When Click on PIM Option
    Then Click the Add button
    And Verify the Create Login Details checkbox is checked
    Then Fill in the "<fName>", "<lName>", "<userName>", "<password>", "<confirmPassword>" and click Save
    Then Verify the employees record creation "<employeeName>"
    And Close Browser
    
Examples: 
      | fName | lName | userName | password | confirmPassword | employeeName | 
      | F001 | L001 | F001L001 | P@ssw0rd | P@ssw0rd | F001 L001 |
      | F002 | L001 | F001L001 | P@ssw0rd | P@ssw0rd | F001 L001 |
    