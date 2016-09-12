@CreateNewProject @ST_536083122
Feature: Create new project

Background: 

Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I check that project "rDefaultOne" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened

@REL-824 @SC_544384695
Scenario: Create new project
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultOne" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project

@REL-613 @SC_554014852
Scenario: Check that validation message 'This project key is already in use' must be shown under the Key field filled with existing key
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultOne" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultOne" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I see a notification message "This project key is already in use" under second field
And I click on button "Create" on pop-up "New Project"
And I see pop up "New Project" was not closed
And I click on button "Cancel" on pop-up "New Project"

@REL-617 @SC_469928980
Scenario: Check that project with existed name can be created
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultOne" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I check that project "rDefaultTwo" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name2" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultTwo" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project

@REL-630 @SC_499524987
Scenario: Check that characters in project key name are in upper-case
And I type "test" into textbox 'Project key' in pop-up 'New Project'
And I see that characters in 'Project key' field in pop-up 'New Project' are in upper-case
And I click on button "Cancel" on pop-up "New Project"

@REL-629 @SC_492523578
Scenario: Check that project key consists of 3 or 4 characters
And I type "te" into textbox 'Project key' in pop-up 'New Project'
And I see a notification message "Must be 3 or 4 characters length" under second field
And I type "text1" into textbox 'Project key' in pop-up 'New Project'
And I see a notification message "Must be 3 or 4 characters length" under second field
And I click on button "Cancel" on pop-up "New Project"

