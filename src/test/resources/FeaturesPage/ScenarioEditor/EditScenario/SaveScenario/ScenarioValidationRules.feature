@ScenarioValidationRules @ST_335191236
Feature: Scenario validation rules

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
And I select background in the table
When I click option "Delete" under drop-down 'Actions' in scenario accordion
And I click on button "Delete" on pop-up "Delete scenario"
Then I see that background was successfully deleted

@REL-855 @SC_328865983
Scenario: BDD rules validation
    #without given in feature having no background
    #without keywords in the beginning each strings
    #less then 2 lines
    #having keywords only
When I select "4" scenario in the table
And I see scenario is expanded
And I delete keyword from step "1" in Ace Editor in scenario accordion
And I type "When" in the current string in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete keyword from step "1" in Ace Editor in scenario accordion
And I type "When" in the current string in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I see pop up "SAVE SCENARIOS" is opened
And I see that checkbox "4" is disabled in pop-up "SAVE SCENARIOS"
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on pop-up "SAVE SCENARIOS"
And I click on button "Cancel" on pop-up "SAVE SCENARIOS"
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete keyword from step "1" in Ace Editor in scenario accordion
And I delete keyword from step "2" in Ace Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on Editor page
And I see a notification message "" under "2" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete keyword from step "1" in Ace Editor in scenario accordion
And I delete keyword from step "2" in Ace Editor in scenario accordion
And I click button 'Save scenarios'
And I see pop up "SAVE SCENARIOS" is opened
And I see that checkbox "4" is disabled in pop-up "SAVE SCENARIOS"
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on pop-up "SAVE SCENARIOS"
And I see a notification message "" under "2" required fields on pop-up "SAVE SCENARIOS"
And I click on button "Cancel" on pop-up "SAVE SCENARIOS"
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on Editor page
And I see a notification message "" under "2" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete step "2" in Ace Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
And I see a notification message "Scenario must contain at least two steps" under "1" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete step "2" in Ace Editor in scenario accordion
And I click button 'Save scenarios'
And I see pop up "SAVE SCENARIOS" is opened
And I see that checkbox "4" is disabled in pop-up "SAVE SCENARIOS"
And I see a notification message "Scenario must contain at least two steps" under "1" required fields on pop-up "SAVE SCENARIOS"
And I click on button "Cancel" on pop-up "SAVE SCENARIOS"
And I see a notification message "Scenario must contain at least two steps" under "1" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete step "2" in Ace Editor in scenario accordion
And I delete step "1" in Ace Editor in scenario accordion
And I type "Given" in the current string in Scenario Editor in scenario accordion
And I type "And" into string "2" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
And I see a notification message "Steps. Line 1: Can't contain a keyword only" under "1" required fields on Editor page
And I see a notification message "Steps. Line 2: Can't contain a keyword only" under "1" required fields on Editor page
And I see scenario "4" is modified
And I click option "Rollback" under drop-down 'Actions' in scenario accordion
And I see success notification ""
And I delete step "2" in Ace Editor in scenario accordion
And I delete step "1" in Ace Editor in scenario accordion
And I type "Given" in the current string in Scenario Editor in scenario accordion
And I type "And" into string "2" in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I see pop up "SAVE SCENARIOS" is opened
And I see that checkbox "4" is disabled in pop-up "SAVE SCENARIOS"
And I see a notification message "Steps. Line 1: Can't contain a keyword only" under "1" required fields on pop-up "SAVE SCENARIOS"
And I see a notification message "Steps. Line 2: Can't contain a keyword only" under "1" required fields on pop-up "SAVE SCENARIOS"
And I click on button "Cancel" on pop-up "SAVE SCENARIOS"
And I see a notification message "Steps. Line 1: Can't contain a keyword only" under "1" required fields on Editor page
And I see a notification message "Steps. Line 2: Can't contain a keyword only" under "1" required fields on Editor page
And I see scenario "4" is modified

