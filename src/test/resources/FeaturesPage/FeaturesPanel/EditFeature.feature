@EditFeature @ST_530547609
Feature: Edit feature

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

@REL-504 @SC_469854657
Scenario: Tags functionality
    #user cannot start feature tags with "ST_" or "SC_"
    #spaces should be replaced with hyphens
    #user cannot add duplicate tags
    #tags autocomplete should be displayed when required
    #tag length should not exceed 128 symbols limitation
    #error message should not be displayed in tags field when edit the input
    #confirm changes in tags field
When I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_2" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_2" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I select feature "fileName_1" in the tree
When I type "S" into tags input textbox in feature info block under the tree
And I see that autocomplete for tags doesn't contains elements that match RegEx "ST_[a-z,A-Z,0-9]+"
And I see that autocomplete for tags doesn't contains elements that match RegEx "SC_[a-z,A-Z,0-9]+"
When I type "SC_" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on Editor page
When I type "SC_," into tags input textbox in feature info block under the tree
And I see a notification message "Tag name must not start with 'SC_'" under "1" required fields on Editor page
When I type "ST_" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on Editor page
When I type "ST_," into tags input textbox in feature info block under the tree
And I see a notification message "Tag name must not start with 'ST_'" under "1" required fields on Editor page
When I type "tag 1" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see that tag "tag-1" is added to feature info under the tree
When I type "tag 2," into tags input textbox in feature info block under the tree
And I see that tag "tag-2" is added to feature info under the tree
When I type "tag 1" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see a notification message "This tag has already been entered" under "1" required fields on Editor page
When I type "tag-2," into tags input textbox in feature info block under the tree
And I see a notification message "This tag has already been entered" under "1" required fields on Editor page
And I select feature "fileName_2" in the tree
When I type "tag-1" into tags input textbox in feature info block under the tree
And I see that autocomplete contains elements that match RegEx "tag-1"
When I type "tag-3" into tags input textbox in feature info block under the tree
And I see that autocomplete for tags doesn't contains elements that match RegEx "tag-3"
When I type "xFS3EnqxjVawBoZY4KsekZ3koCllngBVWIof4aHDrUwZC8tAcYLH0oJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4NoJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4N" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see a notification message "The length must be up to 128 characters" under "1" required fields on Editor page
When I type "xFS3EnqxjVawBoZY4KsekZ3koCllngBVWIof4aHDrUwZC8tAcYLH0oJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4NoJLOOySsp27XIwcmgsqncWTu8oXY6gHQEEXl3Chfy98t4N," into tags input textbox in feature info block under the tree
And I see a notification message "The length must be up to 128 characters" under "1" required fields on Editor page
When I type "ST_" into tags input textbox in feature info block under the tree
And I see a notification message "Tag name must not start with 'SC_'" under "0" required fields on Editor page
When I type "ST_1" into tags input textbox in feature info block under the tree
And I see a notification message "Tag name must not start with 'SC_'" under "0" required fields on Editor page
And I select feature "fileName_1" in the tree
When I click button 'Backspace' for tags input under the tree
When I click button 'Backspace' for tags input under the tree
Then I see that tag "tag-2" is absent on feature info under the tree
When I click button 'Delete' for tag "tag-1" under the tree
Then I see that tag "tag-1" is absent on feature info under the tree

@REL-520 @SC_495942825
Scenario: Valid symbols for tags
When I type "tag1" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see that tag "tag1" is added to feature info under the tree
When I type "tag2," into tags input textbox in feature info block under the tree
And I see that tag "tag2" is added to feature info under the tree

@REL-524 @SC_465033716
Scenario: Invalid symbols for tags
When I type "@tag1" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I see a notification message "@ is invalid for a tag name" under "1" required fields on Editor page
And I see that tag "@tag1" is absent on feature info under the tree
When I type ">tag2," into tags input textbox in feature info block under the tree
And I see a notification message "&gt; is invalid for a tag name" under "1" required fields on Editor page
And I see that tag ">tag2" is absent on feature info under the tree

@REL-506 @SC_529406558
Scenario: Valid symbols for file name field
When I change textbox 'File name' value to "fileName_1_1" in feature info block under the tree
And I click button 'Enter'
Then I see success notification ""
And I see that changes are successfully saved in textbox 'File name' in feature info block under the tree
When I change textbox 'File name' value to "fileName_1_2" in feature info block under the tree
And I lose focus
Then I see success notification ""
And I see that changes are successfully saved in textbox 'File name' in feature info block under the tree
When I change textbox 'File name' value to "fileName_1_3" in feature info block under the tree
And I click button 'Save' for edited field under the tree
Then I see success notification ""
And I see that changes are successfully saved in textbox 'File name' in feature info block under the tree

@REL-507 @SC_533612277
Scenario: Invalid symbols for file name field
When I change textbox 'File name' value to "@fileName_1_1" in feature info block under the tree
And I click button 'Enter'
And I see a notification message "Story file name must contain only the following characters: A-z 0-9 _ -" under "1" required fields on Editor page
When I change textbox 'File name' value to "$fileName_1_2" in feature info block under the tree
And I lose focus
And I see a notification message "Story file name must contain only the following characters: A-z 0-9 _ -" under "1" required fields on Editor page
When I change textbox 'File name' value to "%fileName_1_3" in feature info block under the tree
And I click button 'Save' for edited field under the tree
And I see a notification message "Story file name must contain only the following characters: A-z 0-9 _ -" under "1" required fields on Editor page

@REL-491 @SC_476274024
Scenario: Edit Feature field
When I change textbox 'Feature' value to "featureName_1_1" in feature info block under the tree
And I click button 'Enter'
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Feature' in feature info block under the tree
When I change textbox 'Feature' value to "featureName_1_2" in feature info block under the tree
And I lose focus
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Feature' in feature info block under the tree
When I change textbox 'Feature' value to "featureName_1_3" in feature info block under the tree
And I click button 'Save' for edited field under the tree
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Feature' in feature info block under the tree

@REL-525 @SC_518264773
Scenario: Edit description field
When I change textbox 'Description' value to "text1" in feature info block under the tree
And I lose focus
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Description' in feature info block under the tree
When I change textbox 'Description' value to "text2" in feature info block under the tree
And I click button 'Save' for edited field under the tree
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Description' in feature info block under the tree

