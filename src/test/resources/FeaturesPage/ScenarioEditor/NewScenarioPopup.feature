@NewScenarioPopup @ST_480706632
Feature: New Scenario Popup

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

@REL-804 @SC_483600556
Scenario: Tags functionality
  #user cannot start feature tags with "ST_" or "SC_"
  #spaces should be replaced with hyphens
  #user cannot add duplicate tags
  #adding feature to insure autocomplete
  #tags autocomplete should be displayed when required
  #tag length should not exceed 128 symbols limitation
  #error message should not be displayed in tags field when edit the input
  #delete a tag / type several valid tags before performing the following steps
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I type "S" into tags input textbox in pop-up 'New Scenario'
And I see that autocomplete for tags doesn't contains elements that match RegEx "ST_[a-z,A-Z,0-9]+"
And I see that autocomplete for tags doesn't contains elements that match RegEx "SC_[a-z,A-Z,0-9]+"
And I type "SC_" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on pop-up "New feature"
And I type "SC_," into tags input textbox in pop-up 'New Scenario'
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on pop-up "New feature"
And I type "ST_" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on pop-up "New feature"
And I type "ST_," into tags input textbox in pop-up 'New Scenario'
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on pop-up "New feature"
And I type "tag 1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I see that tag "tag-1" is added on popup
And I type "tag 2," into tags input textbox in pop-up 'New Scenario'
And I see that tag "tag-2" is added on popup
And I type "tag 1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I see a notification message "This tag has already been entered" under "1" required fields on pop-up "New feature"
And I type "tag-2," into tags input textbox in pop-up 'New Scenario'
And I see a notification message "This tag has already been entered" under "1" required fields on pop-up "New feature"
And I type " " into tags input textbox in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New scenario"
Then I see that the new scenario is expanded
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
And I type "tag-1" into tags input textbox in pop-up 'New Scenario'
And I see that autocomplete contains elements that match RegEx "tag-1"
And I type "wrongtag" into tags input textbox in pop-up 'New Scenario'
And I see that autocomplete for tags doesn't contains elements that match RegEx "wrongtag"
And I type "xFS3EnqxjVawBoZY4KsekZ3koCllngBVWIof4aHDrUwZC8tAcYLH0oJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4NoJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4N" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see a notification message "The length must be up to 128 characters" under "1" required fields on pop-up "New feature"
And I type "xFS3EnqxjVawBoZY4KsekZ3koCllngBVWIof4aHDrUwZC8tAcYLH0oJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4NoJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4N," into tags input textbox in pop-up 'New feature'
And I see a notification message "The length must be up to 128 characters" under "1" required fields on pop-up "New feature"
And I type "ST_" into tags input textbox in pop-up 'New feature'
And I see a notification message "Tag name must not start with 'ST_'" under "0" required fields on pop-up "New feature"
And I type "ST_1" into tags input textbox in pop-up 'New feature'
And I see a notification message "Tag name must not start with 'ST_'" under "0" required fields on pop-up "New feature"
And I type "tag 1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see that tag "tag-1" is added on popup
And I type "tag 2," into tags input textbox in pop-up 'New feature'
And I see that tag "tag-2" is added on popup
And I click button 'Backspace' for tags input on Pop Up
And I click button 'Backspace' for tags input on Pop Up
And I see that tag "tag-2" is absent on popup
And I click button 'Delete' for tag "tag-1" on Pop Up
And I see that tag "tag-1" is absent on popup

@REL-805 @SC_471494512
Scenario: Valid symbols for tags
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I see that tag "tag1" is added on popup
And I type "tag2," into tags input textbox in pop-up 'New Scenario'
And I see that tag "tag2" is added on popup

@REL-806 @SC_469287833
Scenario: Invalid symbols for tags
And I type "@tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I see a notification message "@ is invalid for a tag name" under "1" required fields on pop-up "New feature"
And I see that tag "@tag1" is absent on popup
And I type ">tag2," into tags input textbox in pop-up 'New Scenario'
And I see a notification message "&gt; is invalid for a tag name" under "1" required fields on pop-up "New feature"
And I see that tag ">tag2" is absent on popup

@REL-808 @SC_502606585
Scenario: Prohibiting to create the second Background
When I click checkbox 'background' in pop-up 'New Scenario'
And I type "backgroundName" as background name in textbox 'Name' in pop-up 'New Scenario'
And I type "backgroundDescription" as background description in textbox 'Description' for background in pop-up 'New Scenario'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then And I see that new background is successfully created and entered data matches data in Scenario Editor for the new background
And I see that the new background is expanded
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
And I see that checkbox 'background' is disabled in pop-up 'New Scenario'
And I see that checkbox 'background' has tooltip "This story already has a background" in pop-up 'New Scenario'

@REL-811 @ignore @SC_531207736
Scenario: Critical functionality
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I add another example line in pop-up 'New Scenario'
And I add element "1" to example data for "step"
And I add another example line in pop-up 'New Scenario'
And I add another example line in pop-up 'New Scenario'
And I add element "2" to example data for "step"
And I add another example line in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
And I see that new scenario is created and entered data matches data in Scenario Editor for the new scenario

@REL-860 @SC_517317240
Scenario: Critical functions - background
When I click checkbox 'background' in pop-up 'New Scenario'
And I type "backgroundName" as background name in textbox 'Name' in pop-up 'New Scenario'
And I type "backgroundDescription" as background description in textbox 'Description' for background in pop-up 'New Scenario'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then And I see that new background is successfully created and entered data matches data in Scenario Editor for the new background
And I see that the new background is expanded

@REL-807 @SC_549320152
Scenario: Background functionality
When I click checkbox 'background' in pop-up 'New Scenario'
And I type "backgroundName" as background name in textbox 'Name' in pop-up 'New Scenario'
And I type "backgroundDescription" as background description in textbox 'Description' for background in pop-up 'New Scenario'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I see that example table is not displayed in the new background in Scenario Editor

@REL-841 @SC_465511403
Scenario: Background validation
When I click checkbox 'background' in pop-up 'New Scenario'
And I type "backgroundName" as background name in textbox 'Name' in pop-up 'New Scenario'
And I type "backgroundDescription" as background description in textbox 'Description' for background in pop-up 'New Scenario'
And I type "step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
And I see pop up "New Scenario" was not closed
And I see a notification message "Background must start with 'Given'" under "1" required fields on pop-up "New feature"

@REL-858 @SC_494157724
Scenario: BDD validation when create a scenario in feature having a back
    #without keywords in the beginning of each string
    #less then 2 lines
    #having keywords only
    #And I type "Given" in the first string in Scenario Editor in pop-up 'New Scenario'
    #without given in feature having a background
When I click checkbox 'background' in pop-up 'New Scenario'
And I type "backgroundName" as background name in textbox 'Name' in pop-up 'New Scenario'
And I type "backgroundDescription" as background description in textbox 'Description' for background in pop-up 'New Scenario'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then And I see that new background is successfully created and entered data matches data in Scenario Editor for the new background
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
And I see pop up "New Scenario" was not closed
And I see a notification message "Steps. Line 1: Must start with 'Given', 'When', 'Then', 'And', 'But' or '#'" under "1" required fields on pop-up "New feature"
And I click on button "Cancel" on pop-up "New Scenario"
And I see pop up "New Scenario" was closed
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
And I see pop up "New Scenario" was not closed
And I see a notification message "Steps. Line 1: Must start with 'Given', 'When', 'Then', 'And', 'But' or '#'" under "1" required fields on pop-up "New feature"
And I click on button "Cancel" on pop-up "New Scenario"
And I see pop up "New Scenario" was closed
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given" into string "1" in Scenario Editor in scenario accordion
And I type "And" into string "1" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
And I see pop up "New Scenario" was not closed
And I see a notification message "Steps. Line 1: Can't contain a keyword only" under "1" required fields on pop-up "New feature"
And I see a notification message "Steps. Line 2: Can't contain a keyword only" under "1" required fields on pop-up "New feature"
And I click on button "Cancel" on pop-up "New Scenario"
And I see pop up "New Scenario" was closed
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "When this step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And that step" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
And I see pop up "New Scenario" was closed
Then I see that the new scenario is expanded
And I see that new scenario is created and entered data matches data in Scenario Editor for the new scenario

@REL-859 @SC_527276733
Scenario: BDD validation when create a scenario in feature having no back
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "When step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
And I see pop up "New Scenario" was not closed
And I see a notification message "Scenario must start with 'Given' (when feature doesn't have a background)" under "1" required fields on pop-up "New feature"

@REL-810 @SC_503071296
Scenario: Ace Editor functionality
    #autocomplete list should be displayed when required
    #select a word / a stepline from autocomplete list / keyword should present in each step, line break should be added befor each When
    #locals / keyword should present in each step, line break should be added befor each When
    #uncovered steps highlighting / keyword should present in each step, line break should be added befor each When
    #covered steps highlighting / keyword should present in each step, line break should be added befor each When
    #tables, comments highlighting / keyword should present in each step, line break should be added befor each When
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given bo s" in the first string in Scenario Editor in pop-up 'New Scenario'
Then I see that autocomplete is displayed in pop-up 'New Scenario'
And I see that all the autocomplete lines contain word "s" in pop-up 'New Scenario'
And I see that all the autocomplete lines contain word "bo" in pop-up 'New Scenario'
And I see that autocomplete contains no keywords in pop-up 'New Scenario'
And I see that autocomplete contains no duplicates in pop-up 'New Scenario'
And I see that numeric and literal regular expressions are replaced with placeholders in proposed steplines in autocomplete list in pop-up 'New Scenario'
And I type "And bo" into string "2" in Scenario Editor in scenario accordion
And I see that autocomplete types order is correct in pop-up 'New Scenario'
And I select step "[number] books should have been found" in autocomplete in pop-up 'New Scenario'
And I see that "2" line equals "And [number] books should have been found" in Ace Editor in pop-up 'New Scenario'
And I type "And bo" into string "3" in Scenario Editor in scenario accordion
And I select step "books" in autocomplete in pop-up 'New Scenario'
And I see that "3" line equals "And books" in Ace Editor in pop-up 'New Scenario'
And I type "An" into string "4" in Scenario Editor in scenario accordion
And I see that autocomplete line "And" is marked as "local" in pop-up 'New Scenario'
And I click button 'Backspace' for steps input on Pop Up
And I click button 'Backspace' for steps input on Pop Up
And I see that step "2" is marked red in Ace Editor in pop-up 'New Scenario'
And I type "And 2 books should have been found" into string "5" in Scenario Editor in scenario accordion
And I see that step "5" is marked green in Ace Editor in pop-up 'New Scenario'
And I type "|this|is|a|table|" into string "6" in Scenario Editor in scenario accordion
And I type "" into string "7" in Scenario Editor in scenario accordion
And I click button 'Backspace' for steps input on Pop Up
And I click button 'Backspace' for steps input on Pop Up
And I type "And something in between" into string "8" in Scenario Editor in scenario accordion
And I see that step "6" is not marked in Ace Editor in pop-up 'New Scenario'
And I type "comment" into string "9" in Scenario Editor in scenario accordion
And I see that "9" line is marked as comment in Ace Editor in pop-up 'New Scenario'
And I click button 'Enter'
And I see that "10" line equals "comment" in Ace Editor in pop-up 'New Scenario'
And I see that "10" line is marked as comment in Ace Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
And I see scenario is expanded
And I see that created scenario contains no empty lines

@REL-809 @ignore @SC_500517181
Scenario: Example table
When I type "Given I have an <example> parameter" in the first string in Scenario Editor in pop-up 'New Scenario'
And I see that example table header "example" is present
And I see that all the example tab elements appeared on popup 'New Scenario'
And I add element "one" to example data for "example"

