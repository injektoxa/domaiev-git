@RemoveFolder @ST_358824087
Feature: Remove folder

@REL-446 @SC_321271812
Scenario: Remove folder
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I select project "default"
And I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
And I click on 'Select All' checkbox on pop-up "UPDATE DATA FROM GIT"
And I click on button "Update" on pop-up "UPDATE DATA FROM GIT"
Then I see success notification ""
And I click button 'New folder' in panel 'Features'
And I see pop up "New folder" is opened
When I type "folderName_1" into textbox 'Name' in pop-up 'New folder'
And I click on button "Create" on pop-up "New folder"
Then I see that new folder is successfully created
And I select folder "folderName_1" in the tree
When I click icon 'Delete' in panel 'Features'
And I click on button "Delete" on pop-up "Delete folder"
Then I see that the folder was successfully deleted

