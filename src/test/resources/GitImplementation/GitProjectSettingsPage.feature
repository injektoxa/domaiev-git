@GitProjectSettingsPage @ST_509082698
Feature: Project settings page

Background: 

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
And I select project "rDefaultOne"
And I am in page "Project Settings"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'

@REL-773 @SC_481493792
Scenario: Check that button 'Load/Reload from GIT' is absent
Then I can see that block 'Version control system' is empty
And I can't see button 'Load/Reload project from GIT' in block "Version control system'

@REL-768 @SC_539353091
Scenario: Check 'Load project from GIT' button for the first time
And I check that VCS "default" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "san4aGitAccount" in dropdown 'Account' at block VCS
Then I can see button 'Load/Reload project from GIT' in block "Version control system'
And I can see tooltip "Load from Git" on button 'Load/Reload project from GIT' in block "Version control system'
When I click on button 'Load from Git' on page 'Settings'
Then I see info notification "Start reload project from GIT"
And I see success notification "All stories and pathes for current project were update from GIT succesfully!"
And Unique tags appear in Git repository "[default]blob/master/src/test/resources/feature/book/search_book.feature"
And I am in page "Editor"
And I can see project was uploaded

@REL-769 @SC_470761697
Scenario: Check 'Load project from GIT' button for the non-first time
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "san4aGitAccount" in dropdown 'Account' at block VCS
Then I can see button 'Load/Reload project from GIT' in block "Version control system'
And I can see tooltip "Load from Git" on button 'Load/Reload project from GIT' in block "Version control system'
When I click on button 'Load from Git' on page 'Settings'
Then I see info notification "Start reload project from GIT"
And I see success notification "All stories and pathes for current project were update from GIT succesfully!"
Then I can see button 'Load/Reload project from GIT' in block "Version control system'
And I can see tooltip "Reload from Git" on button 'Load/Reload project from GIT' in block "Version control system'
When I click on button 'Load from Git' on page 'Settings'
Then I see info notification "Start reload project from GIT"
And I see success notification "All stories and pathes for current project were update from GIT succesfully!"
And Unique tags appear in Git repository "[default]blob/master/src/test/resources/feature/book/search_book.feature"
And I am in page "Editor"
And I can see project was uploaded

@REL-771 @SC_470380252
Scenario: Check notification when project was uploaded with errors
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "san4aJiraAccount" in dropdown 'Account' at block VCS
Then I can see button 'Load/Reload project from GIT' in block "Version control system'
When I click on button 'Load from Git' on page 'Settings'
Then I see info notification "Start reload project from GIT"
And I see error notification ""

