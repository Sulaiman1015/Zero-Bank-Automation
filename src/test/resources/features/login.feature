@login
Feature: Login functionality


  Scenario: unauthorized user should not be able to login
    Given user is on login page
    When user login with wrong username "wrong" and password "wrong"
    Then error message "Login and/or password are wrong." should be displayed


  Scenario:authorized user should be able to login
    Given user is on login page
    When user login with username "username" and password "password"
    Then the "Account summary" page should be displayed


