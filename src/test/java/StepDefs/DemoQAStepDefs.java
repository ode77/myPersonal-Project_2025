package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.PropertyReaders;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import static StepDefs.Hook.driver;


public class DemoQAStepDefs {
    @Given("I am on the DemoQA home page")
    public void i_am_on_the_demo_qa_home_page() throws IOException {
        PropertyReaders propReaders = new PropertyReaders();
        driver.get(propReaders.getDEMOQA_Url());
    }
    @When("I scroll my window down")
    public void i_scroll_my_window_down() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 400)");

    }
    @When("I click on Element link")
    public void i_click_on_element_link() {
        WebElement clickOnElement = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][.='Elements']"));
        clickOnElement.click();

    }
    @Then("Element Confirmation page is displayed")
    public void element_confirmation_page_is_displayed() {
        WebElement elementConfirmationPage = driver.findElement(By.xpath("//div[normalize-space()='Elements']"));
        assertThat(elementConfirmationPage.isDisplayed(),is(equalTo(true)));

    }
    @When("I click on the TextBox Button")
    public void i_click_on_the_text_box_button() {
        WebElement clickOnTestBox = driver.findElement(By.xpath("//span[contains(text(),'Text Box')]"));
        clickOnTestBox.click();

    }
    @Then("the TextBox Page is Displayed")
    public void the_text_box_page_is_displayed() {
        WebElement testBoxConfirmationPage = driver.findElement(By.xpath("//h1[contains(text(),'Text Box')]"));
        assertThat(testBoxConfirmationPage.isDisplayed(),is(equalTo(true)));

    }
    @And("I fill in details as follows {string}, {string}, {string}, {string}")
    public void iFillInDetailsAsFollows(String fName, String eMail, String cAddre, String pAddre) {
        WebElement setFullName = driver.findElement(By.id("userName"));
        setFullName.sendKeys(fName);
        WebElement setEmail = driver.findElement(By.id("userEmail"));
        setEmail.sendKeys(eMail);
        WebElement setCurrentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        setCurrentAddress.sendKeys(cAddre);
        WebElement setPermanetaddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        setPermanetaddress.sendKeys(pAddre);

//    }
//    @Then("I fill in all the neccessary details")
//    public void i_fill_in_all_the_neccessary_details() throws IOException {
//        PropertyReaders propReaders = new PropertyReaders();
//        WebElement setFullName = driver.findElement(By.id("userName"));
//        setFullName.sendKeys(propReaders.getFullName());
//        System.out.println(propReaders.getFullName());

    }
    @And("I click on Submit Button")
    public void i_click_on_submit_button() {
        WebElement clickOnSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        clickOnSubmit.submit();


    }

    @Then("the form submitted is displayed successfully")
    public void theFormSubmittedIsDisplayedSuccessfully() {
        WebElement formConfirmationPage = driver.findElement(By.xpath("//div[@id='output']"));
        assertThat(formConfirmationPage.isDisplayed(),is(equalTo(false)));
//        ebElement  successMessage = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
//        String actualResult = successMessage.getText();
//        assertThat(actualResult.contains(msg),is(equalTo(true)));
//        System.out.println(actualResult);

    }


}