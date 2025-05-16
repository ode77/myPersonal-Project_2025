@Lambda2
Feature:

  Background:
    Given I am on the Lambdatest home page
    Then I Verify that home page is visible successfully
    When I hover on my account and I click on login link
    Then I Verify that login page is displayed successfully

  Scenario Outline: Validate Login as a Returning Customer
#    Given I am on the Lambdatest home page
#    Then I Verify that home page is visible successfully
#    When I hover on my account and I click on login link
#    Then I Verify that login page is displayed successfully
    And I enter valid login details as "<Email>" and "<Password>"
    And I click on login button
    Then I Verify that my account page is displayed successfully
    When I click on edit your account information section
    Then I Verify that account information page is displayed successfully
    And I click on back button to return to my account
    Then I Verify that my account page is displayed successfully
    When I click on Logout link from the right hand menu
    Then Account Logout Page is Displayed
    Examples:
      | Email               | Password |
      | odex4@gmail.com     | Yahoo7   |
      | rsolomon7@gmail.com | Darr77   |

  @Lambda2
  Scenario Outline: Validate Login as a Returning Customer
#    Given I am on the Lambdatest home page
#    Then I Verify that home page is visible successfully
#    When I hover on my account and I click on login link
#    Then I Verify that login page is displayed successfully
    And I enter valid login details as "<Email>" and "<Password>"
    And I click on login button
    Then I Verify that my account page is displayed successfully
    And I click on "Shop by Category" menu
    And I click on "Software" from the left hand menu
    And I scroll down my window to select second page
    When I click on second page
    And I choose "<Product>"
    And I click on Buy Now
    And I click on I want to Use New Address
    And I clear the telephone box
    And I enter all neccessary personal details "<FirstName>", "<LastName>", "<Address>", "<Telephone>", "<PostCode>", "<City>", "<Country>" and "<State>"
    And I scroll down my window to select agree on terms and condition
    And I accept the agree to the Terms & Conditions
    And I click on Continue button under agree on terms and condition
    Then I Verify that Confirm Order page is displayed successfully
    And I click on Confirm Order button
    Then order confirmation "<Message>" is display
    When I hover on my account and I click on logout of my account.
    Examples:
      | Email               | Password | Product   | FirstName | LastName | Address             | Telephone  | PostCode | City   | Country | State  | Message |
      | rsolomon7@gmail.com | Darr77   | HP LP3065 | Rhemi     | Solomon  | 11 Blackwood Avenue | 0899456789 | 00353    | Dublin | Ireland        | Dublin | Your order has been placed! |
      | odex4@gmail.com     | Yahoo7   | HP LP3065 | Sheyi     | Odele    | 24 Belview grove    | 0899456000 | D24E5V6  | Kent   | United Kingdom | Dundee | Your order has been placed! |

