@CreateNewFeature @ST_497393307
Feature: Create new feature

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

@REL-490 @SC_495292263
Scenario: Invalid symbols nor file name field
When I type "!@3A2_-" into textbox 'File name' in pop-up 'New feature'
Then I see a notification message "Story file name must contain only the following characters: A-z 0-9 _ -" under second field

@REL-529 @SC_492968167
Scenario: Valid symbols for file name
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I see that the new feature is selected in the tree

@REL-821 @SC_462401431
Scenario: Tags functionality
    #user cannot start feature tags with "ST_" or "SC_"
    #spaces should be replaced with hyphens
    #user cannot add duplicate tags
    #adding feature to insure autocomplete
    #tags autocomplete should be displayed when required
    #tag length should not exceed 128 symbols limitation
    #error message should not be displayed in tags field when edit the input
    #delete a tag / type several valid tags before performing the following steps
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "S" into tags input textbox in pop-up 'New feature'
And I see that autocomplete for tags doesn't contains elements that match RegEx "ST_[a-z,A-Z,0-9]+"
And I see that autocomplete for tags doesn't contains elements that match RegEx "SC_[a-z,A-Z,0-9]+"
And I type "SC_" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on pop-up "New feature"
And I type "SC_," into tags input textbox in pop-up 'New feature'
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on pop-up "New feature"
And I type "ST_" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on pop-up "New feature"
And I type "ST_," into tags input textbox in pop-up 'New feature'
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on pop-up "New feature"
And I type "tag 1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see that tag "tag-1" is added on popup
And I type "tag 2," into tags input textbox in pop-up 'New feature'
And I see that tag "tag-2" is added on popup
And I type "tag 1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see a notification message "This tag has already been entered" under "1" required fields on pop-up "New feature"
And I type "tag-2," into tags input textbox in pop-up 'New feature'
And I see a notification message "This tag has already been entered" under "1" required fields on pop-up "New feature"
And I type "" into tags input textbox in pop-up 'New feature'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I see that the new feature is selected in the tree
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
And I type "tag-1" into tags input textbox in pop-up 'New feature'
And I see that autocomplete contains elements that match RegEx "tag-1"
And I type "wrongtag" into tags input textbox in pop-up 'New feature'
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

@REL-505 @SC_538056916
Scenario: Valid symbols for tags
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see that tag "tag1" is added on popup
And I type "tag2," into tags input textbox in pop-up 'New feature'
And I see that tag "tag2" is added on popup

@REL-528 @SC_546818590
Scenario: Invalid symbols for tags
And I type "@tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I see a notification message "@ is invalid for a tag name" under "1" required fields on pop-up "New feature"
And I see that tag "@tag1" is absent on popup
And I type ">tag2," into tags input textbox in pop-up 'New feature'
And I see a notification message "&gt; is invalid for a tag name" under "1" required fields on pop-up "New feature"
And I see that tag ">tag2" is absent on popup

