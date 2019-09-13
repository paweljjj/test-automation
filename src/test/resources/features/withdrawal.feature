Feature: Withdrawal tests

  Scenario: Withdrawal should not be possible if we do not have sufficient founds
    Given I make 200 PLN deposit
    When I want to withdraw 500 PLN
    Then Error insufficient founds should occur
    And I have 200 PLN on my Account

  Scenario Outline: Withdrawal should be possible if we have sufficient founds
    Given I make 200 PLN deposit
    When I want to withdraw <withdrawal> PLN
    Then Error insufficient founds did not occur
    And I have <remainingMoney> PLN on my Account

    Examples:
      | withdrawal | remainingMoney |
      | 0          | 200            |
      | 50         | 150            |
      | 100        | 100            |
      | 150        | 50             |
