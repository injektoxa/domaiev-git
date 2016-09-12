@BackgroundValidation @ST_488724007
Feature: Background validation

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

@REL-844 @SC_551166595
Scenario: Save by Save option
And I select background in the table
And I see scenario is expanded
And I select step "2" in Ace Editor in scenario accordion
And I type "And" into string "3" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
And I see a notification message "Steps. Line 3: Can't contain a keyword only" under "1" required fields on Editor page
And I see that background is modified
And I select step "3" in Ace Editor in scenario accordion
And I type " something" in the current string in Scenario Editor in scenario accordion
And I delete keyword from step "1" in Ace Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
And I see a notification message "Background must start with 'Given'" under "1" required fields on Editor page
And I see that background is modified

@REL-845 @SC_544434775
Scenario: Save by Save scenarios pop-up
And I select background in the table
And I see scenario is expanded
And I select step "2" in Ace Editor in scenario accordion
And I type "And" into string "3" in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I see a notification message "Steps. Line 3: Can't contain a keyword only" under "1" required fields on pop-up "SAVE SCENARIOS"
And I click on button "Cancel" on pop-up "SAVE SCENARIOS"
And I see a notification message "Steps. Line 3: Can't contain a keyword only" under "1" required fields on Editor page
And I see that background is modified
And I select step "3" in Ace Editor in scenario accordion
And I type " something" in the current string in Scenario Editor in scenario accordion
And I delete keyword from step "1" in Ace Editor in scenario accordion
And I click button 'Save scenarios'
And I see a notification message "Background must start with 'Given'" under "1" required fields on pop-up "SAVE SCENARIOS"
And I click on button "Cancel" on pop-up "SAVE SCENARIOS"
And I see a notification message "Background must start with 'Given'" under "1" required fields on Editor page
And I see that background is modified

