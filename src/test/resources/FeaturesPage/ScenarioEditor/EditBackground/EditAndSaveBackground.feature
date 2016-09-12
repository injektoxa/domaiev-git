@EditAndSaveBackground @ST_505103829
Feature: Edit and save background

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

@REL-847 @SC_529012875
Scenario: Edit + save by Save option
And I select background in the table
And I see scenario is expanded
When I change textbox 'Name' value to "background1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited background

@REL-848 @SC_511556286
Scenario: Edit + Save by Save scenarios pop-up
And I select background in the table
And I see scenario is expanded
When I change textbox 'Name' value to "background1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I see that checkbox "background1" is checked in pop-up "SAVE SCENARIOS"
And I click on button "Save" on pop-up "SAVE SCENARIOS"
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited background

