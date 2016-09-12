@GitEditorPage @ST_507690698
Feature: Git editor page

Background: 

Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I check that VCS "default" is absent in DB
And I check that project "rDefaultOne" is absent in DB
And I read folder structure from GIT "default"
And I am in page "Dashboard"
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
And I see success notification ""
And I click button 'Plus' near setting 'Version control system' in page 'Project settings'
Then I see pop up "ADD GIT REPOSITORY PATH" is opened
And I type "default" into textbox 'URL' in pop-up "ADD GIT REPOSITORY PATH"
And I click on button "Add" on pop-up "ADD GIT REPOSITORY PATH"
Then I see that "Git" is added to setting 'Version control system' in page 'Project settings'
When I selected menu "default" in dropdown 'Account' at block VCS

@REL-779 @SC_548157043
Scenario: Load project from Git
Given I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
Then I see success notification ""
And I read folder structure from Editor page
And I check that GitHub and ReLime trees are the same

@REL-780 @SC_505477833
Scenario: Reload project from Git
Given I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
Then I see success notification ""
And I read initial IDs from database
When I click icon 'Update from Git' in panel 'Features'
And I see pop up "UPDATE DATA FROM GIT" is opened
And I click on 'Select All' checkbox on pop-up "UPDATE DATA FROM GIT"
And I click on button "Update" on pop-up "UPDATE DATA FROM GIT"
Then I see success notification ""
And I can see IDs is changed in ng-ispector
And I read folder structure from Editor page
And I check that GitHub and ReLime trees are the same

@REL-788 @SC_469479501
Scenario: Load and update project on Editor page
Given I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
Then I see success notification ""
And I am in page "Feature Management"
And I click button 'Save changes to Git' in page 'Feature Management'
Then I see success notification ""

@REL-775 @SC_546927306
Scenario: Load and update project on Editor page
Given I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
Then I see success notification ""
When I select feature "search_book" in the tree
And I select "Search books by publication year" scenario in the table
And I see scenario "Search books by publication year" is expanded
When I change textbox 'Name' value to "scenarioName1" in scenario accordion
And I change textbox 'Description' value to "scenarioDescription1" in scenario accordion
And I type "tag2" into tags input textbox in scenario accordion
And I click button 'Enter'
And I type "And one more step" into string "3" in Scenario Editor in scenario accordion
And I click option "Save" under drop-down 'Actions' in scenario accordion
Then I see that the scenario is collapsed
When I click icon 'Update from Git' in panel 'Features'
And I click on 'Select All' checkbox on pop-up "UPDATE DATA FROM GIT"
And I click on button "Update" on pop-up "UPDATE DATA FROM GIT"
Then I see success notification ""
When I select feature "search_book" in the tree
And I select "Search books by publication year" scenario in the table
And I see scenario "Search books by publication year" is expanded
And I can see that structures in scenario accordion for scenario "Search books by publication year" and Git file "[default]blob/master/src/test/resources/feature/book/search_book.feature" are the same

@REL-786 @SC_477859724
Scenario: Reload project without unique tags from Git via Editor page
When I delete tags for scenarios and feature in Git file "[default]blob/master/src/test/resources/feature/book/search_book.feature"
Given I am in page "Editor"
When I click icon 'Update from Git' in panel 'Features'
Then I see success notification ""
And I see that tags are present for scenarios and feature in Git file "[default]blob/master/src/test/resources/feature/book/search_book.feature"

