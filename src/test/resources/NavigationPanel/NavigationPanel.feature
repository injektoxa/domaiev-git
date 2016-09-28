@NavigationPanel @ST_299123422
Feature: Navigation Panel

@REL-965 @SC_345325047
Scenario: Check top and left navigation panels
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
Then I see that left panel is hidden
And I see item 'Relime' on the top panel
And I see item 'Dashboard' on the top panel
And I see item 'Maximize' on the top panel
When I select project "default"
Then I see that left panel is shown
And I see that left panel is maximized
And I see "Project Activity" item in the left panel
And I see "Editor" item in the left panel
And I see "Settings" item in the left panel
And I see "Feature Management" item in the left panel
Then I click on item 'Maximize'
And I see that left panel is minimized
And I click on item 'Relime'
And I am in page "Dashboard"
Then I see that left panel is hidden
And I see item 'Relime' on the top panel
And I see item 'Dashboard' on the top panel
And I see item 'Maximize' on the top panel
And I see that 'Current Project' label equals "New Auto Test Project"
And I click on item 'Dashboard'
Then I can see path matches RegEx "[default]dashboard" in browser route
And I see item 'Relime' on the top panel
And I see item 'Dashboard' on the top panel
And I see item 'Maximize' on the top panel
And I see that 'Current Project' label equals "New Auto Test Project"
And I click on item 'Recent Projects'
And I see up to 5 last opened projects in dropdown 'Recent Projects'
And I see 'View all projects' in dropdown'

