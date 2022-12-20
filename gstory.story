Scenario: Search for keyword on Google homepage
Given I am on the Google homepage
When I search for the keyword "JBehave"
Then the search results should include the string "What is JBehave?"

Scenario: Search for different keyword on Google
Given I am on the Google homepage
When I search for the keyword "Cucumber"
Then the search results should NOT include the string "What is JBehave?"