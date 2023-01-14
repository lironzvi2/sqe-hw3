Feature: feature to test adding a product functionality

  Scenario:  Validate adding a product is working

    Given open browser add
    And admin log in - add
    And admin goes to dashboard control - add
    And admin goes to products - add
    And admin clicks on create Product
    And admin enters price and name
    And admin put product to category
    When admin clicks save
    Then product is added