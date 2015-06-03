Feature: Point Of Sale Checkout

  Point of Sale accepts an arbitrary
  ordering of products (similar to what would happen at a checkout line)
  and then returns the correct total price for an entire shopping cart
  based on the per unit prices or the volume prices as applicable.

  Background:
    Given these products exists
      | code | price |
      | A    | 2.00  |
      | B    | 12.00 |
      | C    | 1.25  |
      | D    | 0.15  |
    And have these volume prices
      | productCode | units | price |
      | A    | 4     | 7.00  |
      | C    | 6     | 6.00  |

  Scenario: Checkout without volume prices
    Given I add these products to my shopping cart
      | A    |
      | B    |
      | C    |
      | D    |
    Then the total should be 15.40

  Scenario: Checkout with single product with volume prices
    Given I add these products to my shopping cart
      | C    |
      | C    |
      | C    |
      | C    |
      | C    |
      | C    |
      | C    |
    Then the total should be 7.25


  Scenario: Checkout with single product with volume prices and other products
    Given I add these products to my shopping cart
      | A    |
      | B    |
      | C    |
      | D    |
      | A    |
      | B    |
      | A    |
      | A    |
    Then the total should be 32.40