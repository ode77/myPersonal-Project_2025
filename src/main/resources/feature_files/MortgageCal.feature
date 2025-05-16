@MORTGAGE
Feature: Mortgage Calculator Test DATATABLE

  Scenario Outline: Calculate Mortgage rate with given values and default values
    Given I am on the Mortgage calculator website
    When I enter the following
      | field       | Value |
      | homeValue   | 50000 |
      | downPayment | 20000 |
      | intrestRate | 5     |
      | loanTerm    | 25    |
      | startMonth  | Sep   |
      | startYear   | 2020  |
    And accept default value for all the remaining values
    And I click on calculate link
    Then I should get mortgage offer with "<totalMonthlyPayment>", "<downPaymentAmount>", "<downPaymentPercentage>", "<loanPayOffDate>", "<totalIntrestPaid>" and "<monthlyTaxPaid>"
    Examples:
      | totalMonthlyPayment | downPaymentAmount | downPaymentPercentage | loanPayOffDate | totalIntrestPaid | monthlyTaxPaid |
      | $550.38             | $20,000.00        | 40.00%                | Aug, 2045      | $22,613.10       | $250.00        |


  @MORTGAGE
  Scenario Outline: Calculate Mortgage rate with given values and default values
    Given I am on the Mortgage calculator website
    When I enter the following data
      | field        | value        |
      | Property Tax | 2400         |
      | PMI          | 0.5          |
      | Home Ins     | 1000         |
      | Monthly HOA  | 0            |
      | Loan Type    | Conventional |
    And accept default value for all the remaining values
    And I click on calculate link
    Then I should get mortgage offer with "<TotalTaxPaid>", "<MonthlyHomeInsurance>", "<TotalHomeInsurance>", "<AnnualPaymentAmount>" and "<TotalOf360Payments>"
    Examples:
      | TotalTaxPaid | MonthlyHomeInsurance | TotalHomeInsurance | AnnualPaymentAmount | TotalOf360Payments |
      | $72,000.00   | $83.33               | $30,000.00         | $27,620.93          | $828,627.80       |
