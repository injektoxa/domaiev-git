@EditAccount @ST_306131532
Feature: Edit account

@REL-694 @SC_302083614
Scenario: Check updating existing account
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
When I navigate to page 'Profile'
And I click on Create button for Credentials on Profile page
When I populated all required fields for new credential
And I click button 'Add' for new credential
And I click button 'Edit' for created account in panel 'Your accounts' in page 'User Profile'
And I click button 'Edit' for created account in panel 'Your accounts' in page 'User Profile'
When I change textbox 'Account name' value to "accountName1" in table 'Credentials'
And I change textbox 'User name' value to "userName1" in table 'Credentials'
And I change textbox 'Password' value to "123" in table 'Credentials'
And I click button 'Save' for edited account
And I see my account in table 'Credentials'
And I click button 'Delete' for created account in panel 'Credentials' in page 'User Profile'

