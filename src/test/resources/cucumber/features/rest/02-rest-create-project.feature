Feature: REST - Redmine REST testing - Create project
  As a user...
  I want to ...

@ApiRest
  Scenario: Create an project - JSON
    Given System is ready to sent request
    When System sends a request to create project service from redmine
      | name        | RedmineProject                  |
      | identifier  | redmineproject                  |
      | description | Redmine Project for api testing |
      | is_public   | true                            |
    Then The response status should be 201
