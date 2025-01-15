Feature: Test for LogIn

  Background:
    When open login page

  Scenario: Successful login
    Given login page is opened
    When login with correct username propro.organav@gmail.com and password Lorl34715sgh1!
    Then dashboard page is opened

  Scenario: Not Successful login
    Given login page is opened
    When set username "propro.organav@gmail.com"
    When set password "aasdfsag"
    When user clicks login button
    Then error message is displayed