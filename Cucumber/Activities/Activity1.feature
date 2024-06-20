@activity1
Feature: Basic Syntax

  Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
    When User types in its ENTER
    Then Show how many search results were shown
    And Close the browser