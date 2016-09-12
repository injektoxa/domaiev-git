@PaginationFunctionality @ST_493523315
Feature: Pagination Functionality

@REL-837 @SC_535769971
Scenario: Pagination functionality
    #pagination bar should not be displayed when scenario list has less than or exactly 10 scenarios
    #pagination bar should be displayed when scenario list has more than 10 scenarios
    #scenario changes should be retained when navigate through scenarios by pagination bar
    #new scenario should be placed at the new page when there is tenfold number of scenarios
    #behavior when delete the only scenario in the last page
    #new scenario should be placed at the last page when there is pagination in the feature
    #behavior when delete a scenario in a feature having pagination bar
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I select project "default"
And I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
And I click on 'Select All' checkbox on pop-up "UPDATE DATA FROM GIT"
And I click on button "Update" on pop-up "UPDATE DATA FROM GIT"
Then I see success notification ""
When I select feature "NineScenarios" in the tree
And I see that background is displayed in separated control in the first position in Scenario Editor
And I see that pagination element didn't appear
When I select feature "TenScenarios" in the tree
And I see that background is displayed in separated control in the first position in Scenario Editor
And I see that pagination element didn't appear
When I select feature "ElevenScenarios" in the tree
Then I see that pagination element appeared
And I see that background is displayed in separated control in the first position in Scenario Editor
When I click on button "2" on scenarios pagination panel
Then I see that background is displayed in separated control in the first position in Scenario Editor
When I click on button "1" on scenarios pagination panel
And I select "1" scenario in the table
And I change textbox 'Description' value to "desc" in scenario accordion
And I click on button "2" on scenarios pagination panel
And I click on button "1" on scenarios pagination panel
Then I see scenario "1" is expanded
And I see scenario "1" is modified
When I select feature "TenScenarios" in the tree
And I click on button "Leave" on pop-up "SAVE SCENARIOS"
And I see pop up "SAVE SCENARIOS" was closed
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New scenario"
Then I see that the new scenario is expanded
And I see that pagination element appeared
And I am on the "last" page on scenarios pagination panel
When I click option "Delete" under drop-down 'Actions' in scenario accordion
And I click on button "Delete" on pop-up "Delete scenario"
Then I see that the scenario "scenarioName" was successfully deleted
And I see that pagination element didn't appear
And I see that the scenario is collapsed
When I select feature "ElevenScenarios" in the tree
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New scenario"
Then I see that the new scenario is expanded
And I see that pagination element appeared
And I am on the "last" page on scenarios pagination panel
When I click on button "1" on scenarios pagination panel
And I select "5" scenario in the table
And I see scenario "5" is expanded
When I click option 'Delete' under drop-down 'Actions' for scenario "5" in scenario accordion
And I click on button "Delete" on pop-up "Delete scenario"
Then I see that the scenario "5" was successfully deleted
And I see that 10 scenarios are displayed
And I see that the scenario is collapsed
And I see scenario "11" is displayed

