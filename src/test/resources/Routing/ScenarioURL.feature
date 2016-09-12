@ScenarioURL @ST_486527976
Feature: Scenario url

@REL-761 @SC_544135127
Scenario: Check url format when scenario is selected
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I select project "default"
And I am in page "Editor"
And I select feature "search_book" in the tree
Then I see story "search_book" is selected in the tree
And I select "(no name)" scenario in the table
And I see scenario is expanded
Then I can see path matches RegEx "[default][A-Z,0-9]{3,4}/editor/ST_[a-z,A-Z,0-9]+/SC_[a-z,A-Z,0-9]+" in browser route

