Feature:

  @DemoQA
  Scenario Outline: Fill a TextBox on DemoQA
    Given I am on the DemoQA home page
    And I scroll my window down
    When I click on Element link
    Then Element Confirmation page is displayed
    When I click on the TextBox Button
    Then the TextBox Page is Displayed
#    And I fill in all the neccessary details
    And I fill in details as follows "<FullName>", "<Email>", "<CurrentAddress>", "<PermanentAddress>"
    And I click on Submit Button
    Then the form submitted is displayed successfully
    Examples:
      | FullName | Email | CurrentAddress | PermanentAddress |
      | Sam Odex | odexsolo77@gmail.com | Brega Hamlet Lane | Blackwood. Gallops Cavan |
