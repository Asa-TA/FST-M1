@classactivity1
Feature: DuckDuckGO Search

@smoketest
Scenario: Searching for cheese on DucDuckGO
  Given User is on the DuckDuckGo website
  When User searches for Cheese
  Then User should see search results 