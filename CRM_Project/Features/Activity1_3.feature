
@activity1_3
Feature: Schedule a meeting 

Scenario Outline: To schedule a meeting and include at least 3 invitees
    Given Open the browser with ​Alchemy CRM​ site and login with the credentials
    Then Navigate to Activities -> Meetings -> Schedule a Meeting
    And Enter meeting details "<meetingSubject>"
    And Include members to the meeting "<member_1>", "<member_2>", "<member_3>"
    And Click Save
    And Navigate to View Meetings page
    And Close the Browser
    
Examples: 
      | meetingSubject | member_1 | member_2 | member_3 |
      | Test_001 | participant_1 | participant_2 | participant_3 |
      