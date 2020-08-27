Feature: REST - Exchange REST testing
  As a user...
  I want to ...

  @ApiRest
  Scenario: Exchange PEN to USD
    Given System is ready to sent request
    When System sends a request to exchange service:
      | amount            | 520.30 |
      | currencyIsoSource | PEN    |
      | currencyIsoTarget | USD    |
    Then The response status should be 200
    And System should responds with response data
      | amount                 | 520.3     |
      | amountWithExchangeRate | 155.31343 |
      | currencyIsoSource      | PEN       |
      | currencyIsoTarget      | USD       |
      | exchangeRate           | 3.35      |

  @ApiRest
  Scenario: Exchange USD to PEN
    Given System is ready to sent request
    When System sends a request to exchange service:
      | amount            | 500 |
      | currencyIsoSource | USD |
      | currencyIsoTarget | PEN |
    Then The response status should be 200
    And System should responds with response data
      | amount                 | 500.0  |
      | amountWithExchangeRate | 1665.0 |
      | currencyIsoSource      | USD    |
      | currencyIsoTarget      | PEN    |
      | exchangeRate           | 3.33   |

  @ApiRest
  Scenario: Exchange EUR to PEN
    Given System is ready to sent request
    When System sends a request to exchange service:
      | amount            | 300 |
      | currencyIsoSource | EUR |
      | currencyIsoTarget | PEN |
    Then The response status should be 200
    And System should responds with response data
      | amount                 | 300.0  |
      | amountWithExchangeRate | 1290.0 |
      | currencyIsoSource      | EUR    |
      | currencyIsoTarget      | PEN    |
      | exchangeRate           | 4.3    |