Feature: Order products
    As a manager
    I want the inventory to be deducted accordingly, so that I know if the order can be fulfilled.

Background:
    Given a product Bread with price 20 Baht with quantity 100 in the inventory
    And a product Jam with price 10 Baht with quantity 30 in the inventory

Scenario: Order small quantity
    When I buy Bread with quantity 2
    And I buy Jam with quantity 1
    Then a product Bread in the inventory should remain 98 left
    And a product Jam in the inventory should remain 29 left

Scenario: Order large quantity
    When I buy Bread with quantity 101
    Then a product Bread in the inventory should remain 100 left
