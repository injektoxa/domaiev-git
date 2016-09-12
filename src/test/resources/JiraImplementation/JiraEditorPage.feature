@JiraEditorPage @ST_498517911
Feature: Jira editor page

Background: 

    #When I select item "Jira" under drop-down 'Name' in pop-up "ADD TASK TRACKING SYSTEM"
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
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
And I see success notification ""
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "san4aGitAccount" in dropdown 'Account' at block VCS
And I see success notification ""
When I click on button 'Load from Git' on page 'Settings'
Then I see info notification "Start reload project from GIT"
And I see success notification "All stories and pathes for current project were update from GIT succesfully!"
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD JIRA PATH" is opened
And I type "https://jira.unitedsofthouse.com" into textbox 'URL' in pop-up "ADD JIRA PATH"
And I click on button "Add" on pop-up "ADD JIRA PATH"
Then I see pop up "ADD JIRA PATH" was closed
Then I see success notification ""
Then I see that "https://jira.unitedsofthouse.com/" is added to setting 'Task tracking system' in page 'Project settings'

@REL-794 @SC_482541490
Scenario: Check that Jira linked story can be created
When I selected menu "san4aJiraAccount" in dropdown 'Account' at block TTS
Then I see success notification ""
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New feature" is opened
And I see that checkbox 'Jira linked' is enabled
When I click checkbox 'Jira-linked' in pop-up 'New feature'
And I type "REL-1886" into textbox 'Jira-key' in pop-up 'New feature'
And I click on button "Create" on pop-up "New feature"
Then I see that new jira-linked feature is successfully created
And I see that data from linked Jira issue matches data in new feature in feature info block under the tree

@REL-795 @SC_490862149
Scenario: Check that Jira linked story can't be created without valid Jira path and account
When I selected menu "san4aGitAccount" in dropdown 'Account' at block TTS
And I see error notification ""
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New feature" is opened
And I see that checkbox 'Jira linked' is disabled
And I see that checkbox 'Jira linked' tooltip equals "Set up Jira at Project settings page"

@REL-796 @SC_484232000
Scenario: Check that Jira linked story can be changed by use
When I selected menu "san4aJiraAccount" in dropdown 'Account' at block TTS
Then I see success notification ""
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New feature" is opened
And I see that checkbox 'Jira linked' is enabled
When I click checkbox 'Jira-linked' in pop-up 'New feature'
And I type "REL-1886" into textbox 'Jira-key' in pop-up 'New feature'
And I click on button "Create" on pop-up "New feature"
Then I see success notification ""
Then I see that new jira-linked feature is successfully created
And I see that data from linked Jira issue matches data in new feature in feature info block under the tree
And I select feature "REL-1886" in the tree
Then I see success notification ""
When I change textbox 'Feature' value to "featureName_1_1" in feature info block under the tree
And I click button 'Save' for edited field under the tree
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Feature' in feature info block under the tree
When I change textbox 'File name' value to "fileName_1_1" in feature info block under the tree
And I click button 'Save' for edited field under the tree
Then I see success notification ""
And I see that changes are successfully saved in textbox 'File name' in feature info block under the tree
When I change textbox 'Description' value to "test1" in feature info block under the tree
And I lose focus
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Description' in feature info block under the tree

