package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.PropertyReaders;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.List;

import static StepDefs.Hook.driver;

public class MortgageStepDef {
    @Given("I am on the Mortgage calculator website")
    public void i_am_on_the_mortgage_calculator_website() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        PropertyReaders propReaders = new PropertyReaders();
        driver.get(propReaders.getMortgageCal_Url());


    }
    @When("I enter the following")
    public void i_enter_the_following(List<List<String>>dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        // For other transformations you can register a DataTableType.
        WebElement setHomeValue = driver.findElement(By.name("param[homevalue]"));
        setHomeValue.sendKeys(dataTable.get(1).get(1));
        WebElement setDownPayment = driver.findElement(By.name("param[downpayment]"));
        setDownPayment.sendKeys(dataTable.get(2).get(1));
        WebElement setIntrestRate = driver.findElement(By.name("param[interest_rate]"));
        setIntrestRate.sendKeys(dataTable.get(3).get(1));
        WebElement setLoanTerm = driver.findElement(By.name("param[term]"));
        setLoanTerm.sendKeys(dataTable.get(4).get(1));
        WebElement setStartMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        Select month = new Select(setStartMonth);
        month.selectByVisibleText(dataTable.get(5).get(1));
        WebElement setStartYear = driver.findElement(By.xpath("//*[@name='param[start_year]']"));
        setStartYear.sendKeys(dataTable.get(6).get(1));



    }
    @When("accept default value for all the remaining values")
    public void accept_default_value_for_all_the_remaining_values() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I click on calculate link")
    public void i_click_on_calculate_link() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickCalculateBtn = driver.findElement(By.name("cal"));
        clickCalculateBtn.click();

    }
    @Then("I should get mortgage offer with {string}, {string}, {string}, {string}, {string} and {string}")
    public void i_should_get_mortgage_offer_with_and(String totalMonthlyPayment, String downPaymentAmount, String downPaymentPercentage, String loanPayofDate, String totalIntPaid, String monTaxPaid) {
        // Write code here that turns the phrase above into concrete actions
        WebElement getTotalMonthlyPmt = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[1]"));
        String totalMonthlyPmt = getTotalMonthlyPmt.getText();
        assertThat(totalMonthlyPmt, is(equalTo(totalMonthlyPayment)));

        WebElement getDownPmtAmount = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[3]"));
        String downPmtAmount = getDownPmtAmount.getText();
        assertThat(downPmtAmount, is(equalTo(downPaymentAmount)));

        WebElement getDownPmtPercentage = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[4]"));
        String downPmtPercentage = getDownPmtPercentage.getText();
        assertThat(downPmtPercentage, is(equalTo(downPaymentPercentage)));

        WebElement getLoanPayoffdate = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[5]"));
        String loanPayoffDate = getLoanPayoffdate.getText();
        assertThat(loanPayoffDate, is(equalTo(loanPayofDate)));

        WebElement getTotalInstPaid = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[6]"));
        String totalIntrestPaid = getTotalInstPaid.getText();
        assertThat(totalIntrestPaid, is(equalTo(totalIntPaid)));

        WebElement getMonthlyTaxPaid = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[7]"));
        String monthlyTaxPaid = getMonthlyTaxPaid.getText();
        assertThat(monthlyTaxPaid, is(equalTo(monTaxPaid)));
    }
    @When("I enter the following data")
    public void i_enter_the_following_data(List<List<String>>dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        WebElement setPropertyTax = driver.findElement(By.name("param[property_tax]"));
        setPropertyTax.sendKeys(dataTable.get(1).get(1));
        WebElement setPMI = driver.findElement(By.name("param[pmi]"));
        setPMI.sendKeys(dataTable.get(2).get(1));
        WebElement setHomeIns = driver.findElement(By.name("param[hoi]"));
        setHomeIns.sendKeys(dataTable.get(3).get(1));
        WebElement setMonthlyHOA = driver.findElement(By.name("param[hoa]"));
        setMonthlyHOA.sendKeys(dataTable.get(4).get(1));
        WebElement setLoanType = driver.findElement(By.xpath("//select[@name='param[milserve]']"));
        Select sel = new Select(setLoanType);
        sel.selectByVisibleText(dataTable.get(5).get(1));
    }
    @Then("I should get mortgage offer with {string}, {string}, {string}, {string} and {string}")
    public void i_should_get_mortgage_offer_with_and(String totalTaxPd, String monthlyHomeIns, String totalHomeIns, String annualPaymentAmt, String totalOf360Pmt) {
        // Write code here that turns the phrase above into concrete actions
        WebElement getTotalTaxPd = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[8]"));
        String totalTaxPaid = getTotalTaxPd.getText();
        assertThat(totalTaxPaid, is(equalTo(totalTaxPd)));

        WebElement getMonthlyHomeInsurance = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[9]"));
        String monthlyHomeInsurance = getMonthlyHomeInsurance.getText();
        assertThat(monthlyHomeInsurance,is(monthlyHomeIns));

        WebElement getTotalHomeInsurance = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[10]"));
        String totalHomeInsurance = getTotalHomeInsurance.getText();
        assertThat(totalHomeInsurance,is(totalHomeIns));

        WebElement getAnnualPaymentAmount = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[11]"));
        String annualPaymentAmount = getAnnualPaymentAmount.getText();
        assertThat(annualPaymentAmount,is(annualPaymentAmt));

        WebElement getTotalOf360Payments = driver.findElement(By.xpath("(//*[@class='repayment-block']/div/div/h3)[12]"));
        String totalOf360Payment = getTotalOf360Payments.getText();
        assertThat(totalOf360Payment, is(totalOf360Pmt));
    }
}
