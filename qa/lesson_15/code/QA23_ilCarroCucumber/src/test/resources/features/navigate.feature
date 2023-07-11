Feature: Home Page

  @navigate
  Scenario: Verify Home Page title is displayed
    Given User launches browser
    When User opens ilCarro Home Page
    Then User verifies Home Page title
    And User quits browser