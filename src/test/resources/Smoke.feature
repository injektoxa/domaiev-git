@Smoke @ST_545114612
Feature: Smoke test set

Background: Sign in

Given I am in page "Default"
And I am signed in
And I am in page "Dashboard"

@REL-863 @SC_464981888
Scenario: Create project
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I see that all the entered data matches data in page 'Project Settings' for the new project

@REL-869 @SC_475585365
Scenario: Edit project
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
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
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I see that drop-down 'Saving mode' value is "requiring confirmation" in page 'Project settings'

@REL-864 @SC_484574512
Scenario: Create account
When I navigate to page 'Profile'
And I click on Create button for Credentials on Profile page
When I populated all required fields for new credential
And I click button 'Add' for new credential
Then I see my account in table 'Credentials'

@REL-876 @SC_496225292
Scenario: Add VCS
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "San4aGit" in dropdown 'Account' at block VCS
And I see that entered data matches data in setting 'Version control system' in page 'Project settings' for Git

@REL-879 @SC_503499221
Scenario: Update from Git
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "San4aGit" in dropdown 'Account' at block VCS
And I see that entered data matches data in setting 'Version control system' in page 'Project settings' for Git
And I read folder structure from GIT "smoke"
And I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
Then I see success notification ""
And I read folder structure from Editor page
And I check that GitHub and ReLime trees are the same

@REL-865 @SC_468495341
Scenario: Create folder
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New folder' in panel 'Features'
And I see pop up "New folder" is opened
When I type "folderName_1" into textbox 'Name' in pop-up 'New folder'
And I click on button "Create" on pop-up "New folder"
Then I see that new folder is successfully created
And I see that the new folder is selected in the tree

@REL-866 @SC_480104061
Scenario: Create feature
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I see that the new feature is selected in the tree

@REL-867 @SC_466985141
Scenario: Create scenario
    #And I select feature "fileName_1" in the tree
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
And I see that new scenario is created and entered data matches data in Scenario Editor for the new scenario
And I see that example table is displayed in the new scenario in Scenario Editor

@REL-868 @SC_484213268
Scenario: Create background
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
And I select feature "fileName_1" in the tree
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I click checkbox 'background' in pop-up 'New Scenario'
And I type "backgroundName" as background name in textbox 'Name' in pop-up 'New Scenario'
And I type "backgroundDescription" as background description in textbox 'Description' for background in pop-up 'New Scenario'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
Then And I see that new background is successfully created and entered data matches data in Scenario Editor for the new background
And I see that the new background is expanded
And I see that background is displayed in separated control in the first position in Scenario Editor
And I see that example table is not displayed in the new background in Scenario Editor

@REL-870 @SC_537076659
Scenario: Edit account
When I navigate to page 'Profile'
And I click on Create button for Credentials on Profile page
When I populated all required fields for new credential
And I click button 'Add' for new credential
Then I see my account in table 'Credentials'
When I am in page "Dashboard"
And I navigate to page 'Profile'
And I click button 'Edit' for created account in panel 'Your accounts' in page 'User Profile'
When I change textbox 'Account name' value to "accountName1" in table 'Credentials'
And I change textbox 'User name' value to "userName1" in table 'Credentials'
And I change textbox 'Password' value to "123" in table 'Credentials'
And I click button 'Save' for edited account
And I see my account in table 'Credentials'

@REL-871 @SC_534327152
Scenario: Edit folder
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New folder' in panel 'Features'
And I see pop up "New folder" is opened
When I type "folderName_1" into textbox 'Name' in pop-up 'New folder'
And I click on button "Create" on pop-up "New folder"
Then I see that new folder is successfully created
And I select folder "folderName_1" in the tree
When I change textbox 'Folder name' value to "folderName_1_1" in folder info block under the tree
And I click button 'Enter'
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Folder name' in folder info block under the tree

@REL-872 @SC_471368850
Scenario: Edit feature
    #And I see that new tag is added in tags input textbox in feature info block under the tree
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I see that the new feature is selected in the tree
When I change textbox 'Feature' value to "featureName_1_1" in feature info block under the tree
And I click button 'Enter'
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Feature' in feature info block under the tree
When I change textbox 'File name' value to "fileName_1_1" in feature info block under the tree
And I click button 'Enter'
Then I see success notification ""
And I see that changes are successfully saved in textbox 'File name' in feature info block under the tree
When I change textbox 'Description' value to "test1" in feature info block under the tree
And I lose focus
Then I see success notification ""
And I see that changes are successfully saved in textbox 'Description' in feature info block under the tree
When I type "tag2" into tags input textbox in feature info block under the tree
And I click button 'Enter'
And I lose focus
Then I see success notification ""
And I see that tag "tag2" is added to feature info under the tree

@REL-873 @tag @SC_529021399
Scenario: Edit scenario + Save by Save option
    #And I select feature "fileName_1" in the tree
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
When I change textbox 'Name' value to "scenarioName1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario

@REL-874 @tag @SC_473346080
Scenario: Edit scenario + Save by Save Scenarios pop-up
    #And I select feature "fileName_1" in the tree
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
When I change textbox 'Name' value to "scenarioName12" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription12" in scenario accordion
And I type "tag3" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And two more step" into string "4" in Scenario Editor in scenario accordion
And I click button 'Save scenarios'
And I see pop up "Save scenarios" is opened
And I click on button "Save" on pop-up "Save scenarios"
Then I see that the scenario is collapsed
And I see that changes are successfully saved and changed data matches data in Scenario Editor for the edited scenario

@REL-875 @SC_528018069
Scenario: Add TTS
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD JIRA PATH" is opened
And I type "https://jira.unitedsofthouse.com/" into textbox 'URL' in pop-up "ADD JIRA PATH"
And I click on button "Add" on pop-up "ADD JIRA PATH"
And I tie "DansJira" account in TTS settings
And I see success notification ""
Then I see that "https://jira.unitedsofthouse.com/" is added to setting 'Task tracking system' in page 'Project settings'
And I see that entered data matches data in setting 'Task tracking system' in page 'Project settings' for Jira

@REL-877 @SC_530181089
Scenario: Create Jira-linked feature
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD JIRA PATH" is opened
And I type "https://jira.unitedsofthouse.com/" into textbox 'URL' in pop-up "ADD JIRA PATH"
And I click on button "Add" on pop-up "ADD JIRA PATH"
And I tie "DansJira" account in TTS settings
And I see success notification ""
Then I see that "https://jira.unitedsofthouse.com/" is added to setting 'Task tracking system' in page 'Project settings'
And I see that entered data matches data in setting 'Task tracking system' in page 'Project settings' for Jira
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New feature" is opened
When I click checkbox 'Jira-linked' in pop-up 'New feature'
And I type "REL-1872" into textbox 'Jira-key' in pop-up 'New feature'
And I click on button "Create" on pop-up "New feature"
And I see success notification ""
Then I see that new jira-linked feature is successfully created
And I see that data from linked Jira issue matches data in new feature in feature info block under the tree

@REL-878 @SC_481397096
Scenario: Remove TTS
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I click button 'Plus' near setting 'Task tracking system' in page 'Project settings'
Then I see pop up "ADD JIRA PATH" is opened
And I type "https://jira.unitedsofthouse.com/" into textbox 'URL' in pop-up "ADD JIRA PATH"
And I click on button "Add" on pop-up "ADD JIRA PATH"
And I tie "DansJira" account in TTS settings
And I see success notification ""
Then I see that "https://jira.unitedsofthouse.com/" is added to setting 'Task tracking system' in page 'Project settings'
And I see that entered data matches data in setting 'Task tracking system' in page 'Project settings' for Jira
And I can delete "https://jira.unitedsofthouse.com/" from setting 'Task tracking system' in page 'Project settings'

@REL-880 @SC_482970581
Scenario: Remove scenario
    #And I select feature "fileName_1" in the tree
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "tag1" into tags input textbox in pop-up 'New Scenario'
And I click button 'Enter'
And I type "Given step" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And another <step>" into string "2" in Scenario Editor in pop-up 'New Scenario'
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
When I click option "Delete" under drop-down 'Actions' in scenario accordion
And I click on button "Delete" on pop-up "Delete scenario"
Then I see that the scenario was successfully deleted

@REL-881 @SC_507181529
Scenario: Remove feature
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I type "tag1" into tags input textbox in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
When I click icon 'Delete' in panel 'Features'
And I click on button "Delete" on pop-up "Delete feature file"
Then I see that the feature was successfully deleted

@REL-882 @SC_502467541
Scenario: Remove folder
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
And I see that project is added to panel 'Projects'
And I select project in panel 'Projects' in page "Dashboard"
And I change drop-down 'Saving mode' value to "requiring confirmation" in page 'Project settings'
And I see success notification ""
And I check that VCS "smoke" is absent in DB
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "smoke" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
And I am in page "Editor"
And I click button 'New folder' in panel 'Features'
And I see pop up "New folder" is opened
When I type "folderName_1" into textbox 'Name' in pop-up 'New folder'
And I click on button "Create" on pop-up "New folder"
Then I see that new folder is successfully created
And I select folder "folderName_1" in the tree
When I click icon 'Delete' in panel 'Features'
And I click on button "Delete" on pop-up "Delete folder"
Then I see that the folder was successfully deleted

@REL-883 @SC_491779782
Scenario: Remove account
When I navigate to page 'Profile'
And I click on Create button for Credentials on Profile page
When I populated all required fields for new credential
And I click button 'Add' for new credential
When I see my account in table 'Credentials'
And I am in page "Dashboard"
When I navigate to page 'Profile'
And I click button 'Delete' for created account in panel 'Credentials' in page 'User Profile'
And I see account is not in the table 'Credentials'

@REL-884 @SC_532102144
Scenario: Remove project
When I am in page "Dashboard"
And I check that project "sDefault" is absent in DB
And I click button 'Plus' in panel 'Projects' in page "Dashboard"
Then I see pop up "New Project" is opened
When I type "project_name1" into textbox 'Name' in pop-up 'New Project'
And I type "sDefault" into textbox 'Project key' in pop-up 'New Project'
And I type "test" into textbox 'Description' in pop-up 'New Project'
And I select item "private" in drop-down 'Project Type' in pop-up 'New Project'
And I click on button "Create" on pop-up "New Project"
Then I see success notification ""
When I delete project in panel 'Projects' in page "Dashboard"
And I click on button "Delete" on pop-up "Delete account"
Then I see success notification ""
And I see that the project was successfully deleted

