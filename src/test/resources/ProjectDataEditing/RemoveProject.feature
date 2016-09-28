@RemoveProject @ST_361055510
Feature: Remove project

@REL-610 @SC_367468331
Scenario: Check ability to delete project from Dashboard page
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I check that project "rDefaultOne" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultOne" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
When I delete project in panel 'Projects' in page "Dashboard"
And I click on button "Delete" on pop-up "Delete account"
Then I see success notification ""
And I see that the project was successfully deleted

