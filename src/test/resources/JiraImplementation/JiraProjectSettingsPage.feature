@JiraProjectSettingsPage @ST_533068908
Feature: Jira project settings page

Background: 

Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I check that project "rDefaultOne" is absent in DB
And I check that VCS "default" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultOne" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
When I select item "Git" under drop-down 'Name' in pop-up "ADD GIT REPOSITORY PATH"
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
And I see success notification ""
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "san4aGitAccount" in dropdown 'Account' at block VCS
And I see success notification ""
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD TASK TRACKING SYSTEM" is opened

@REL-791 @SC_508623250
Scenario: Check validation for Jira path field for Version Control System block on pop-up
When I select item "Jira" under drop-down 'Name' in pop-up "ADD TASK TRACKING SYSTEM"
And I type "https://nope" into textbox 'URL' in pop-up "ADD TASK TRACKING SYSTEM"
And I click on button "Add" on pop-up "ADD TASK TRACKING SYSTEM"
And I see a notification message "Must start with 'http(s)://jira.'" under second field
And I click on button "Cancel" on pop-up "ADD TASK TRACKING SYSTEM"
And I see pop up "ADD TASK TRACKING SYSTEM" was closed
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
And I see pop up "ADD TASK TRACKING SYSTEM" is opened
And I type "default" into textbox 'URL' in pop-up "ADD TASK TRACKING SYSTEM"
And I click on button "Add" on pop-up "ADD TASK TRACKING SYSTEM"
And I see a notification message "This field is required" under "1" required fields on pop-up "ADD TASK TRACKING SYSTEM"
And I select item "Jira" under drop-down 'Name' in pop-up "ADD TASK TRACKING SYSTEM"
And I click on button "Add" on pop-up "ADD TASK TRACKING SYSTEM"
Then I see pop up "ADD TASK TRACKING SYSTEM" was closed
Then I see success notification ""
And I see that "Jira" is added to setting 'Task tracking system' in page 'Project settings'

@REL-792 @SC_493740851
Scenario: Check account validation for Jira
When I select item "Jira" under drop-down 'Name' in pop-up "ADD TASK TRACKING SYSTEM"
And I type "https://jira.unitedsofthouse.com/" into textbox 'URL' in pop-up "ADD TASK TRACKING SYSTEM"
And I click on button "Add" on pop-up "ADD TASK TRACKING SYSTEM"
Then I see pop up "ADD TASK TRACKING SYSTEM" was closed
Then I see success notification ""
And I see that "Jira" is added to setting 'Task tracking system' in page 'Project settings'
When I selected menu "san4aGitAccount" in dropdown 'Account' at block TTS
And I see error notification ""
And I am in page "Editor"
And I see that button 'Upload from Jira' is disabled
Given I am in page "Dashboard"
And I select project in panel 'Projects' in page "Dashboard"
When I selected menu "DansJira" in dropdown 'Account' at block TTS
Then I see success notification ""
And I am in page "Editor"
And I see that button 'Upload from Jira' is enabled

@REL-793 @SC_536278232
Scenario: Check validation for Jira path field for Test Tracking System block on Project Settings page
When I select item "Jira" under drop-down 'Name' in pop-up "ADD TASK TRACKING SYSTEM"
And I type "https://jira.unitedsofthouse.com/" into textbox 'URL' in pop-up "ADD TASK TRACKING SYSTEM"
And I click on button "Add" on pop-up "ADD TASK TRACKING SYSTEM"
Then I see pop up "ADD TASK TRACKING SYSTEM" was closed
Then I see success notification ""
And I see that "Jira" is added to setting 'Task tracking system' in page 'Project settings'
And I change "Jira" 'Task tracking system' path setting to "https://nope" in page 'Project settings'
And I see "" warning under TTS Path field
And I change "Jira" 'Task tracking system' path setting to "" in page 'Project settings'
And I see "" warning under TTS Path field
And I change "Jira" 'Task tracking system' path setting to "https://jira.unitedsofthouse.com/" in page 'Project settings'
Then I see success notification ""

