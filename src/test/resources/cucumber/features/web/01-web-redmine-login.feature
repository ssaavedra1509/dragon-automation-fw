Feature: Desktop WEB UI Redmine Login
  As a user,
  I want to be able to login on Redmine

  @E2E
  Scenario: User inputs correct username and password with chrome_default_config
    Given I go to the Redmine login page on URL
    When I login with my credentials user "jhurtado" and "passw0rd"
    Then I should see the homepage with the username "jhurtado"

