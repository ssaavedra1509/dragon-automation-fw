Feature: Desktop WEB UI - Redmine - Projects
  As a user
  I want to create a Project and check that it was successfully created.

@E2E
  Scenario: Create a Project
    Given I go to the Redmine login page on URL
    When I login with my credentials user "user" and "bitnami1"
    And I create a project
      | name          | RedmineProject |
      | description           | Esta es una descripción de prueba |
      | homepage              | RedmineProject |
      | public                | true    |
    Then The Project was successfully created
    #And The Project should be available in Projects list
