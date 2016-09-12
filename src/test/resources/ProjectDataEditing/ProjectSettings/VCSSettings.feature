@VCSSettings @ST_530413395
Feature: VCS settings

Background: 

Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I check that VCS "default" is absent in DB
And I check that project "F002" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "F002" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened

@REL-800 @SC_527144729
Scenario: Check that VCS is added to project only once
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "san4aGitAccount" in dropdown 'Account' at block VCS
And I see that entered data matches data in setting 'Version control system' in page 'Project settings' for Git
And I am not able to add or delete VCS

@REL-829 @ignore @SC_528953738
Scenario: Check VCS with invalid account
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I selected menu "DansJira" in dropdown 'Account' at block VCS
And I see error notification ""

@REL-778 @SC_482933746
Scenario: Check validation for path field for VERSION CONTROL SYSTEM table when you add VCS
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
And I see a notification message "This field is required" under "1" required fields on pop-up "ADD GIT REPOSITORY PATH"
And I type "github.com/san4a/SomeRepository" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I see a notification message "Must start with 'http(s)://'" under "1" required fields on pop-up "ADD GIT REPOSITORY PATH"
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'

