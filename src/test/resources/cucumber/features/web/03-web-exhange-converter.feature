Feature:  WEB UI - Exchange - P
  As a user
  I want to ...

  @E2E
  Scenario: Exchange USD to PEN
    Given I go to the Exchange page on URL
    When I want to perform the following exchange:
      | currency_source | USD |
      | currency_target | PEN |
      | amount          | 100 |
    Then the following should be displayed on the screen:
      | convertedAmount | 375  |
      | exchangeRate    | 3.75 |


  @E2E
  Scenario: Exchange PEN to USD
    Given I go to the Exchange page on URL
    When I want to perform the following exchange:
      | currency_source | PEN |
      | currency_target | USD |
      | amount          | 100 |
    Then the following should be displayed on the screen:
      | convertedAmount | 28.17 |
      | exchangeRate    | 3.55  |