@Lambda2
Feature:

  Background:
    Given I am on the Lambdatest home page
    Then I Verify that home page is visible successfully
    When I hover on my account and I click on register link
    Then I Verify that register page is displayed successfully

  Scenario Outline: Register new user happy path
#    Given I am on the Lambdatest home page
#    Then I Verify that home page is visible successfully
#    When I hover on my account and I click on register link
#    Then I Verify that register page is displayed successfully
    And I enter valid details for "<FirstName>", "<LastName>", "<E-mail>", "<Telephone>", "<Password and ConfirmPword>"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed
    And I "Logout" of my account
    Examples:
      | FirstName | LastName | E-mail              | Telephone  | Password and ConfirmPword |
      | sheyi     | odele    | odex4@gmail.com     | 0899786754 | Yahoo7                    |
      | Rhemi     | Solomon  | rsolomon7@gmail.com | 0877908745 | Darr77                    |


  @Lambda2
  Scenario Outline: Validate Last Name
#    Given I am on the Lambdatest home page
#    Then I Verify that home page is visible successfully
#    When I hover on my account and I click on register link
#    Then I Verify that register page is displayed successfully
    And I enter valid details for "<FirstName>","<E-mail>", "<Telephone>","<Password and ConfirmPword>"
    And I enter Invalid detail for "<LastName>"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then I should get last name error "<Message>"
    Examples:
      | FirstName | LastName | E-mail          | Telephone  | Password and ConfirmPword | Message                                        |
      | sheyi     |          | odex4@gmail.com | 0899786754 | Yahoo                     | Last Name must be between 1 and 32 characters! |

  @Lambda2
  Scenario Outline: Password and Confirm Password validation
#    Given I am on the Lambdatest home page
#    Then I Verify that home page is visible successfully
#    When I hover on my account and I click on register link
#    Then I Verify that register page is displayed successfully
    And I enter valid details for "<FirstName>", "<LastName>", "<E-mail>" and "<Telephone>"
    And I enter invalid details for "<Password and Confirm Password>"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then I should get password and confirm password error "<Message>"
    Examples:
      | FirstName | LastName | E-mail          | Telephone  | Password and Confirm Password | Message |
      | sheyi     | odele    | odex4@gmail.com | 0899786754 | Ya                        | Password must be between 4 and 20 characters! |

  @Lambda2
  Scenario Outline: Validate Email input
#    Given I am on the Lambdatest home page
##    Then I Verify that home page is visible successfully
##    When I hover on my account and I click on register link
##    Then I Verify that register page is displayed successfully
    And I enter valid details for "<FirstName>", "<LastName>", "<Telephone>", "<Password and ConfirmPword>"
    And I enter Invalid detail for "<Email>" address
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then I should get email address error "<Message>"
    Examples:
      | FirstName | LastName | Telephone | Password and ConfirmPword | Email | Message |
      | Soloman | Dan | 0899674524 | Yahoo | odex@gaml | E-Mail Address does not appear to be valid! |




