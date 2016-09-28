@EditAndSaveScenario @ST_342469491
Feature: Edit and save scenario

Background: 

Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I select project "default"
And I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
And I click on 'Select All' checkbox on pop-up "UPDATE DATA FROM GIT"
And I click on button "Update" on pop-up "UPDATE DATA FROM GIT"
Then I see success notification ""
When I select feature "ElevenScenarios" in the tree

@REL-852 @SC_292771943
Scenario: Edit + save by Save option
#    And I edit example table description in Scenario Editor
#    And I edit example table data cell in Scenario Editor
#    And I add an example table data row in Scenario Editor
#    And I delete example table row in Scenario Editor
#    And I toggle example table row in Scenario Editor
And I select "1" scenario in the table
And I see scenario "1" is expanded
When I change textbox 'Name' value to "scenarioName1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario

@REL-853 @SC_360615784
Scenario: Edit + Save by Save scenarios pop-up
#    And I edit example table description in Scenario Editor
#    And I edit example table data cell in Scenario Editor
#    And I add an example table data row in Scenario Editor
#    And I delete example table row in Scenario Editor
#    And I toggle example table row in Scenario Editor
And I select "1" scenario in the table
And I see scenario "1" is expanded
When I change textbox 'Name' value to "scenarioName1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I click on button "Save" on pop-up "SAVE SCENARIOS"
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario

@REL-854 @SC_299653880
Scenario: Edit + Save several scenarios by Save scenarios pop-up
#    And I edit example table description in Scenario Editor
#    And I edit example table data cell in Scenario Editor
#    And I add an example table data row in Scenario Editor
#    And I delete example table row in Scenario Editor
#    And I toggle example table row in Scenario Editor
#    And I edit example table description in Scenario Editor
#    And I edit example table data cell in Scenario Editor
#    And I add an example table data row in Scenario Editor
#    And I delete example table row in Scenario Editor
#    And I toggle example table row in Scenario Editor
#    And I edit example table description in Scenario Editor
#    And I edit example table data cell in Scenario Editor
#    And I add an example table data row in Scenario Editor
#    And I delete example table row in Scenario Editor
#    And I toggle example table row in Scenario Editor
And I select "1" scenario in the table
And I see scenario "1" is expanded
When I change textbox 'Name' value to "scenarioName1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I select "10" scenario in the table
And I see scenario "10" is expanded
When I change textbox 'Name' value to "scenarioName2" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription3" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I click on button "2" on scenarios pagination panel
And I select "11" scenario in the table
And I see scenario "11" is expanded
When I change textbox 'Name' value to "scenarioName3" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription3" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I click checkbox "scenarioName1" in pop-up "SAVE SCENARIOS"
And I see that checkbox "scenarioName1" is unchecked in pop-up "SAVE SCENARIOS"
And I click checkbox "scenarioName2" in pop-up "SAVE SCENARIOS"
And I see that checkbox "scenarioName2" is unchecked in pop-up "SAVE SCENARIOS"
And I click checkbox "scenarioName2" in pop-up "SAVE SCENARIOS"
And I see that checkbox "scenarioName2" is checked in pop-up "SAVE SCENARIOS"
And I see that checkbox "scenarioName3" is checked in pop-up "SAVE SCENARIOS"
And I click on button "Save" on pop-up "SAVE SCENARIOS"
And I see success notification "2 of 2 selected scenarios were successfully saved"
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario

@REL-857 @SC_302235961
Scenario: Empty lines should be skipped
#    And I edit example table description in Scenario Editor
#    And I edit example table data cell in Scenario Editor
#    And I add an example table data row in Scenario Editor
#    And I delete example table row in Scenario Editor
#    And I toggle example table row in Scenario Editor
And I select "1" scenario in the table
And I see scenario "1" is expanded
When I change textbox 'Name' value to "scenarioName1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "" into string "3" in Scenario Editor in scenario accordion
And I type "" into string "4" in Scenario Editor in scenario accordion
And I type "And one more step" into string "5" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario
And I see that created scenario contains no empty lines

