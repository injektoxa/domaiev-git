@BackgroundAccordion @ST_505178162
Feature: Background accordion

@REL-850 @SC_523007897
Scenario: Background accordion
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
And I select background in the table
And I see scenario is expanded
And I see that background 'Name' label is visible
And I see that background 'Description' field with label is visible
And I see that background steps editor with label is visible
And I see that background tags editor with label is not visible
And I change textbox 'Name' value to "anything" in scenario accordion
And I change textbox 'Name' value to "" in scenario accordion
And I change textbox 'Description' value to "anything" in scenario accordion
And I change textbox 'Description' value to "" in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited background
And I select step "2" in Ace Editor in scenario accordion
And I type "And what is with <examples>" into string "3" in Scenario Editor in scenario accordion
And I see that example table is not displayed for background

