@AceEditor @ST_351223929
Feature: Ace Editor

@REL-834 @SC_294057876
Scenario: Autocomplete rules + highlight
  #autocomplete list should be displayed when required
  #select a word / a stepline from autocomplete list / keyword should present in each step, line break should be added befor each When
  #locals / keyword should present in each step, line break should be added befor each When
  #uncovered steps highlighting / keyword should present in each step, line break should be added befor each When
  #covered steps highlighting / keyword should present in each step, line break should be added befor each When
  #tables, comments highlighting / keyword should present in each step, line break should be added befor each When
Given I am in page "Default"
And I am signed in
Given I am in page "Dashboard"
And I select project "default"
And I am in page "Editor"
And I delete feature "fileName_1" if it's present in the tree
And I click button 'New feature' in panel 'Features'
And I see pop up "New Feature" is opened
When I type "featureName_1" into textbox 'Feature' in pop-up 'New feature'
And I type "fileName_1" into textbox 'File name' in pop-up 'New feature'
And I type "test" into textbox 'Description' in pop-up 'New feature'
And I click button 'Enter'
And I click on button "Create" on pop-up "New feature"
Then I see that new feature is successfully created
And I see that the new feature is selected in the tree
And I click button 'New Scenario'
And I see pop up "New Scenario" is opened
When I type "scenarioName" in textbox 'Name' in pop-up 'New Scenario'
And I type "scenarioDescription" in textbox 'Description' in pop-up 'New Scenario'
And I type "Given bo s" in the first string in Scenario Editor in pop-up 'New Scenario'
And I type "And step" into string "2" in Scenario Editor in scenario accordion
And I click on button "Create" on pop-up "New Scenario"
Then I see that the new scenario is expanded
And I select step "2" in Ace Editor in scenario accordion
And I click button 'Enter'
And I type "And bo" in the current string in Scenario Editor in scenario accordion
Then I see that autocomplete is displayed in pop-up 'New Scenario'
And I see that all the autocomplete lines contain word "bo" in pop-up 'New Scenario'
And I see that autocomplete contains no keywords in pop-up 'New Scenario'
And I see that autocomplete contains no duplicates in pop-up 'New Scenario'
And I see that numeric and literal regular expressions are replaced with placeholders in proposed steplines in autocomplete list in pop-up 'New Scenario'
And I see that autocomplete types order is correct in pop-up 'New Scenario'
And I select step "[number] books should have been found" in autocomplete in pop-up 'New Scenario'
And I see that "3" line equals "And [number] books should have been found" in Ace Editor in scenario accordion
And I type "And bo" into string "4" in Scenario Editor in scenario accordion
And I select step "books" in autocomplete in pop-up 'New Scenario'
And I see that "4" line equals "And books" in Ace Editor in scenario accordion
And I type "An" into string "5" in Scenario Editor in scenario accordion
And I see that autocomplete line "And" is marked as "local" in pop-up 'New Scenario'
And I click button 'Backspace' for steps input in scenario acordion
And I click button 'Backspace' for steps input in scenario acordion
And I click button 'Backspace' for steps input in scenario acordion
And I see that step "3" is marked red in Ace Editor in scenario accordion
And I type "And 2 books should have been found" into string "5" in Scenario Editor in scenario accordion
And I see that step "5" is marked green in Ace Editor in scenario accordion
And I type "|this|is|a|table|" into string "6" in Scenario Editor in scenario accordion
And I type "" into string "7" in Scenario Editor in scenario accordion
And I click button 'Backspace' for steps input in scenario acordion
And I click button 'Backspace' for steps input in scenario acordion
And I type "And something in between" into string "8" in Scenario Editor in scenario accordion
And I see that step "6" is not marked in Ace Editor in scenario accordion
And I type "comment" into string "9" in Scenario Editor in scenario accordion
And I see that "9" line is marked as comment in Ace Editor in scenario accordion
And I click button 'Enter'
And I see that "10" line equals "comment" in Ace Editor in scenario accordion
And I see that "10" line is marked as comment in Ace Editor in scenario accordion

