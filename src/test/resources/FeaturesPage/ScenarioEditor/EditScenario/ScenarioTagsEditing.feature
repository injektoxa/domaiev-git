@ScenarioTagsEditing @ST_519285198
Feature: Scenario tags editing

Background: 

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
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded

@REL-831 @SC_481360328
Scenario: Tags functionality
  #user cannot start feature tags with "ST_" or "SC_"
  #spaces should be replaced with hyphens
  #user cannot add duplicate tags
  #adding feature to insure autocomplete
  #tags autocomplete should be displayed when required
  #tag length should not exceed 128 symbols limitation
  #error message should not be displayed in tags field when edit the input
  #delete a tag / type several valid tags before performing the following steps
And I type "S" into tags input textbox in scenario info block
And I see that autocomplete for tags doesn't contains elements that match RegEx "ST_[a-z,A-Z,0-9]+"
And I see that autocomplete for tags doesn't contains elements that match RegEx "SC_[a-z,A-Z,0-9]+"
And I type "SC_" into tags input textbox in scenario info block
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on Editor page
And I type "SC_," into tags input textbox in scenario info block
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on Editor page
And I type "ST_" into tags input textbox in scenario info block
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on Editor page
And I type "ST_," into tags input textbox in scenario info block
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on Editor page
And I type "tag 1" into tags input textbox in scenario info block
And I click button 'Enter'
And I see that tag "tag-1" is added to scenario info
And I type "tag 2," into tags input textbox in scenario info block
And I see that tag "tag-2" is added to scenario info
And I type "tag 1" into tags input textbox in scenario info block
And I click button 'Enter'
And I see a notification message "This tag has already been entered" under "1" required fields on Editor page
And I type "tag-2," into tags input textbox in scenario info block
And I see a notification message "This tag has already been entered" under "1" required fields on Editor page
And I type "tag-3" into tags input textbox in scenario info block
And I click button 'Enter'
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName2" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription2" in textbox 'Description' in pop-up 'New Scenario'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
And I type "tag-1" into tags input textbox in scenario info block
And I see that autocomplete contains elements that match RegEx "tag-1"
And I type "wrongtag" into tags input textbox in scenario info block
And I see that autocomplete for tags doesn't contains elements that match RegEx "wrongtag"
And I type "xFS3EnqxjVawBoZY4KsekZ3koCllngBVWIof4aHDrUwZC8tAcYLH0oJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4NoJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4N" into tags input textbox in scenario info block
And I click button 'Enter'
And I see a notification message "The length must be up to 128 characters" under "1" required fields on Editor page
And I type "xFS3EnqxjVawBoZY4KsekZ3koCllngBVWIof4aHDrUwZC8tAcYLH0oJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4NoJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4N," into tags input textbox in scenario info block
And I see a notification message "The length must be up to 128 characters" under "1" required fields on Editor page
And I type "ST_" into tags input textbox in scenario info block
And I see a notification message "Tag name must not start with 'ST_'" under "0" required fields on Editor page
And I type "ST_1" into tags input textbox in scenario info block
And I see a notification message "Tag name must not start with 'ST_'" under "0" required fields on Editor page
And I type "tag 1" into tags input textbox in scenario info block
And I click button 'Enter'
And I see that tag "tag-1" is added to scenario info
And I type "tag 2," into tags input textbox in scenario info block
And I see that tag "tag-2" is added to scenario info
And I click button 'Backspace' for scenario tags input
And I click button 'Backspace' for scenario tags input
And I see that tag "tag-2" is absent in scenario info
And I click button 'Delete' for tag "tag-1" in scenario info
And I see that tag "tag-1" is absent in scenario info

@REL-832 @SC_541153708
Scenario: Valid symbols for tags
And I type "tag1" into tags input textbox in scenario info block
And I click button 'Enter'
And I see that tag "tag1" is added to scenario info
And I type "tag2," into tags input textbox in scenario info block
And I see that tag "tag2" is added to scenario info

@REL-833 @SC_521491542
Scenario: Invalid symbols for tags
And I type "@tag1" into tags input textbox in scenario info block
And I click button 'Enter'
And I see a notification message "@ is invalid for a tag name" under "1" required fields on Editor page
And I see that tag "@tag1" is absent in scenario info
And I type ">tag2," into tags input textbox in scenario info block
And I see a notification message "&gt; is invalid for a tag name" under "1" required fields on Editor page
And I see that tag ">tag2" is absent in scenario info

