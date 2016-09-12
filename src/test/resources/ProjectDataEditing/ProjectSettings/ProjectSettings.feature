@ProjectSettings @ST_523192283
Feature: Project settings

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

@REL-618 @SC_521826496
Scenario: Check that project name can be edited with existed project name
And I check that project "rDefaultTwo" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name3" into textbox 'Name' in pop-up 'New Project'
And I type "rDefaultTwo" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change textbox 'Name' value to "project_name2" in page 'Project settings'
Then I see success notification ""

@REL-611 @SC_544871599
Scenario: Check ability to edit project from Dashboard page
And I select project in panel 'Projects' in page "Dashboard"
When I change textbox 'Name' value to "project_name12" in page 'Project settings'
And I see success notification ""
And I see that textbox 'Name' is "project_name12" in page 'Project settings'
When I change textbox 'Description' value to "test1" in page 'Project settings'
And I see success notification ""
And I see that textbox 'Description' is "test1" in page 'Project settings'
When I change drop-down 'Project type' value to "public" in page 'Project settings'
And I see success notification ""
And I see that drop-down 'Project type' value is "public" in page 'Project settings'

