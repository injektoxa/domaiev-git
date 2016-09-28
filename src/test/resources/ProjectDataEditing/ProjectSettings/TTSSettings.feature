@TTSSettings @ST_312869014
Feature: TTS settings

@REL-825 @SC_323564022
Scenario: Check task tracker notifications
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
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD JIRA PATH" is opened
And I type "https://jira.unitedsofthouse.com" into textbox 'URL' in pop-up "ADD JIRA PATH"
And I click on button "Add" on pop-up "ADD JIRA PATH"
Then I see pop up "ADD JIRA PATH" was closed
Then I see success notification ""
Then I see that "https://jira.unitedsofthouse.com/" is added to setting 'Task tracking system' in page 'Project settings'

@REL-830 @SC_362676179
Scenario: Make changes in task tracker
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
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD JIRA PATH" is opened
And I type "https://jira.unitedsofthouse.com" into textbox 'URL' in pop-up "ADD JIRA PATH"
And I click on button "Add" on pop-up "ADD JIRA PATH"
Then I see pop up "ADD JIRA PATH" was closed
And I see success notification ""
And I see that "https://jira.unitedsofthouse.com/" is added to setting 'Task tracking system' in page 'Project settings'

@REL-620 @ignore @SC_330767205
Scenario: Check that when all TTS are added button 'Add TTS' is disabled
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
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "Add task tracking system" is opened
When I select item "Jira" under drop-down 'Name' in pop-up "Add task tracking system"
And I type "https://jira.unitedsofthouse.com" into textbox 'URL' in pop-up "Add task tracking system"
And I click on button "Add" on pop-up "Add task tracking system"
And I see success notification ""
And I see that "Jira" is added to setting 'Task tracking system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "Add task tracking system" is opened
When I select item "Redmine" under drop-down 'Name' in pop-up "Add task tracking system"
And I type "https://redmine.unitedsofthouse.com" into textbox 'URL' in pop-up "Add task tracking system"
And I click on button "Add" on pop-up "Add task tracking system"
And I see success notification ""
And I see that "Redmine" is added to setting 'Task tracking system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "Add task tracking system" is opened
When I select item "QC" under drop-down 'Name' in pop-up "Add task tracking system"
And I type "https://qc.unitedsofthouse.com" into textbox 'URL' in pop-up "Add task tracking system"
And I type "dom" into textbox "DOMAIN" in pop-up "Add task tracking system"
And I type "proj" into textbox "PROJECT" in pop-up "Add task tracking system"
And I click on button "Add" on pop-up "Add task tracking system"
And I see success notification ""
And I see that "QC" is added to setting 'Task tracking system' in page 'Project settings'
And I see that button 'Add TTS' is disabled

@REL-623 @ignore @SC_368574490
Scenario: Check that alredy connected TTS are not displayed in dropdown list
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
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "Add task tracking system" is opened
When I select item "Jira" under drop-down 'Name' in pop-up "Add task tracking system"
And I type "https://jira.unitedsofthouse.com" into textbox 'URL' in pop-up "Add task tracking system"
And I click on button "Add" on pop-up "Add task tracking system"
And I see success notification ""
And I see that "Jira" is added to setting 'Task tracking system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "Add task tracking system" is opened
Then I see item "Jira" is absent under drop-down 'Name' in pop-up "Add task tracking system"
When I select item "Redmine" under drop-down 'Name' in pop-up "Add task tracking system"
And I type "https://redmine.unitedsofthouse.com" into textbox 'URL' in pop-up "Add task tracking system"
And I click on button "Add" on pop-up "Add task tracking system"
And I see success notification ""
And I see that "Redmine" is added to setting 'Task tracking system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "Add task tracking system" is opened
Then I see item "Jira" is absent under drop-down 'Name' in pop-up "Add task tracking system"
Then I see item "Redmine" is absent under drop-down 'Name' in pop-up "Add task tracking system"
And I click on button "Cancel" on pop-up "Add task tracking system"

