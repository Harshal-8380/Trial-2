Feature: Google Search Functionality

  Scenario Outline: Checking the serach functionality of Google
    Given User is in chrome browser and is on google home page
    When user search for <keywords>
    Then user should get relevant search results

    Examples: 
      | keywords                           |
      | top 10 richest person in the world |
