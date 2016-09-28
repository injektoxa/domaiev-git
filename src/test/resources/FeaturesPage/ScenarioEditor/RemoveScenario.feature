@RemoveScenario @ST_342786041
Feature: Remove scenario

@REL-838 @SC_316514535
Scenario: Remove scenario pop-up
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I select project "default"
And I am in page "Editor"
And I delete feature "fileName_1" if it's present in the tree
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I see that the new feature is selected in the tree
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "Given bo s" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And step" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
When I click option "Delete" under drop-down 'Actions' in scenario accordion
And I click on button "Delete" on pop-up "Delete scenario"
Then I see that the scenario was successfully deleted

