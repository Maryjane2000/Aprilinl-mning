Feature: User

  Background:
    Given I have opened "chrome" browser

  Scenario: I Create a users and everything goes as expected
    Given I write an email
    Given I write a username
    Given I write a password
    When I click the sign in button
    Then I get the result if the account is created or not

  Scenario: I Create a user with a long username that has more than 100 characters
    Given I write an email
    Given I write a username with more than 100 characters
    Given I write a password
    When I click the sign in button again
    Then I get the result from a username with more than 100 characters

  Scenario: Already exist
    Given I write an email that already exist
    Given I write a username that already exist
    Given I write a password that already exist
    When I click the sign in button1
    Then I get the result if email already exist



  Scenario: I Create a users but the e-mail is missing
    Given I do not write an email
    Given I write a username
    Given I write a password
    When I click the sign in button2
    Then I get the result