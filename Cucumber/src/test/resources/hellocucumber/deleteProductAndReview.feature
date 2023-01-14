Feature: test 2 functionalities

  Scenario:  Validate deleted product

    Given open browser delete
    And admin log in
    And admin goes to dashboard control
    And admin goes to products
    When admin deletes shirt product
    Then the shirt product is deleted

  Scenario:  Validate filtering

    Given open browser filter
    And customer log in
    And user goes to women category
    And user filters to brand adidas
    When user checks product
    Then product is from adidas brand