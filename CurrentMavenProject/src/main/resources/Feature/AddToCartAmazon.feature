Feature: Add to cart functionality

  Scenario: Checking the Add to cart functionality of amazon.in
    Given user is on google chrome and is on "https://www.amazon.in/" home page
    When user serach for "samsung m13" and press Enter
    Then user should go to samsung m13 page list
    When user click on 2nd visible phone then new window should open
    And user click on Add to Cart
    Then item should be added to cart
