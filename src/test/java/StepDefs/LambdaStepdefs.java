package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyReaders;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static StepDefs.Hook.driver;

public class LambdaStepdefs {
    @Given("I am on the Lambdatest home page")
    public void i_am_on_the_lambdatest_home_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        PropertyReaders propReaders = new PropertyReaders();
        driver.get(propReaders.getLambdaTest_Url());
    }
    @Then("I Verify that home page is visible successfully")
    public void i_verify_that_home_page_is_visible_successfully() {
        // Write code here that turns the phrase above into concrete actions
        WebElement homePageIsVisible = driver.findElement(By.xpath("//div[@id='main-header']"));
        assertThat(homePageIsVisible.isDisplayed(),is(equalTo(true)));
    }
    @When("I hover on my account and I click on register link")
    public void iHoverOnMyAccountAndIClickOnRegisterLink() {
        WebElement myAccount = driver.findElement(By.xpath("(//span[contains(text(),' My account')])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).perform();
        WebElement Register = driver.findElement(By.xpath("//span[normalize-space()='Register']"));
        Register.click();
    }
    @Then("I Verify that register page is displayed successfully")
    public void iVerifyThatRegisterPageIsDisplayedSuccessfully() {
        WebElement registerAccountPageIsDisplay = driver.findElement(By.xpath("//h1[@class='page-title h3']"));
        assertThat(registerAccountPageIsDisplay.isDisplayed(),is(equalTo(true)));
    }

    @When("I enter valid details for {string}, {string}, {string}, {string}, {string}")
    public void i_enter_valid_details_for(String firstName, String lastName, String email, String telephone, String pword) {
        // Write code here that turns the phrase above into concrete actions
        WebElement setFirstName = driver.findElement(By.name("firstname"));
        setFirstName.sendKeys(firstName);
        WebElement setLastName = driver.findElement(By.name("lastname"));
        setLastName.sendKeys(lastName);
        WebElement setEmail = driver.findElement(By.name("email"));
        setEmail.sendKeys(pNumber() +email);
        WebElement setTelephone = driver.findElement(By.name("telephone"));
        setTelephone.sendKeys(telephone);
        WebElement setPassword = driver.findElement(By.name("password"));
        setPassword.sendKeys(pword);
        WebElement setConfirmPassword = driver.findElement(By.name("confirm"));
        setConfirmPassword.sendKeys(pword);
    }
    static int pNumber() {
        Random ran = new Random();
        return ran.nextInt(1000);
    }
    @When("I accept the privacy policy")
    public void i_accept_the_privacy_policy() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnPrivacyPolicy = driver.findElement(By.xpath("//div[@class='float-right']"));
        clickOnPrivacyPolicy.click();
    }
    @When("I click on Continue button on the Register and Account page")
    public void i_click_on_continue_button_on_the_register_and_account_page() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        clickOnContinue.click();
    }

    @Then("Register Confirmation page is displayed")
    public void register_confirmation_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement confirmationPage = driver.findElement(By.xpath("//h1[@class='page-title my-3']"));
//        assertThat(confirmationPage.isDisplayed(),is(equalTo(true)));
        assertThat(confirmationPage.getText(),is(equalTo("Your Account Has Been Created!")));

    }
    @Then("I {string} of my account")
    public void i_of_my_account(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnLogout = driver.findElement(By.xpath("//a[contains(text(),' Logout')]"));
        clickOnLogout.click();
    }


    @When("I hover on my account and I click on login link")
    public void i_hover_on_my_account_and_i_click_on_login_link() {
        // Write code here that turns the phrase above into concrete actions
        WebElement myAccount = driver.findElement(By.xpath("(//span[contains(text(),' My account')])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).perform();
        WebElement clickOnLogin = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        clickOnLogin.click();
    }
    @Then("I Verify that login page is displayed successfully")
    public void iVerifyThatLoginPageIsDisplayedSuccessfully() {
        WebElement loginAccountPageIsDisplay = driver.findElement(By.xpath("(//div[@class='card-body p-4'])[2]"));
        assertThat(loginAccountPageIsDisplay.isDisplayed(),is(equalTo(true)));
//        assertThat(loginAccountPageIsDisplay.getText(),is(equalTo("")));
    }
    @Then("I enter valid login details as {string} and {string}")
    public void i_enter_valid_login_details_as_and(String eMail, String pWord) {
        // Write code here that turns the phrase above into concrete actions
        WebElement setEmail = driver.findElement(By.name("email"));
        setEmail.sendKeys(eMail);
        WebElement setPassword = driver.findElement(By.name("password"));
        setPassword.sendKeys(pWord);
    }
    @And("I click on login button")
    public void iClickOnLoginButton() {
        WebElement clickOnLoginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        clickOnLoginBtn.click();
    }
    @Then("I Verify that my account page is displayed successfully")
    public void i_verify_that_my_account_page_is_displayed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        WebElement accountPageIsDisplay = driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
        assertThat(accountPageIsDisplay.isDisplayed(),is(equalTo(true)));
    }
    @When("I click on edit your account information section")
    public void i_click_on_edit_your_account_information_section() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnEditInformation = driver.findElement(By.xpath("(//div[@class='col-6 col-sm-4 col-lg-2_4'])[1]"));
        clickOnEditInformation.click();

//        boolean isChecked = false;
//        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
//        List<WebElement> radioButtons = driver.findElements(By.name("cars"));
//        int size = radioButtons.size();
//        System.out.println("Size of the list: " + size);
//
//        for (int i = 0; i<size; i++){     // loop through code
//            isChecked = radioButtons.get(i).isSelected();
//            if (!isChecked) {
//                radioButtons.get(i).click();
//                Thread.sleep(2000);
//            }
//        }

    }
    @Then("I Verify that account information page is displayed successfully")
    public void i_verify_that_account_information_page_is_displayed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        WebElement accountInfoPageIsDisplay = driver.findElement(By.xpath("//ol[@class='breadcrumb']"));
        assertThat(accountInfoPageIsDisplay.getText(),is(equalTo("Account Edit Information")));

    }
    @Then("I click on back button to return to my account")
    public void i_click_on_back_button_to_return_to_my_account() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnBackBtn = driver.findElement(By.xpath(" //a[@class='btn btn-secondary']"));
        clickOnBackBtn.click();
    }
    @When("I click on Logout link from the right hand menu")
    public void i_click_on_logout_link_from_the_right_hand_menu() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnLogoutBtn = driver.findElement(By.xpath(" //a[contains(text(),'Logout')]"));
        clickOnLogoutBtn.click();

    }
    @Then("Account Logout Page is Displayed")
    public void account_logout_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement accountLogoutPageIsDisplay = driver.findElement(By.xpath("//h1[@class='page-title my-3']"));
        assertThat(accountLogoutPageIsDisplay.getText(),is(equalTo("Account Logout")));

    }
    @Then("I enter valid details for {string},{string}, {string},{string}")
    public void i_enter_valid_details_for(String firstName, String email, String telephone , String pword) {
        // Write code here that turns the phrase above into concrete actions
        WebElement setFirstName = driver.findElement(By.name("firstname"));
        setFirstName.sendKeys(firstName);
        WebElement setEmail = driver.findElement(By.name("email"));
        setEmail.sendKeys(pNumber() +email);
        WebElement setTelephone = driver.findElement(By.name("telephone"));
        setTelephone.sendKeys(telephone);
        WebElement setPassword = driver.findElement(By.name("password"));
        setPassword.sendKeys(pword);
    }
    @Then("I enter Invalid detail for {string}")
    public void i_enter_invalid_detail_for(String lastName) {
        // Write code here that turns the phrase above into concrete actions
        WebElement setInvalidLastName =
                driver.findElement(By.id("input-lastname"));
        setInvalidLastName.sendKeys(lastName);
    }
    @Then("I should get last name error {string}")
    public void iShouldGetLastNameError(String eMsge) {
//        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='text-danger']"));
//        assertThat(errorMessage.getText(), is(Matchers.equalTo("Password confirmation does not match password!")));
        WebElement errorLastName =
                driver.findElement(By.xpath("//*[@class='text-danger']"));
        String actualResult = errorLastName.getText();
        assertThat(actualResult, is(equalTo(eMsge)));
        System.out.println(actualResult);
    }
    @And("I enter valid details for {string}, {string}, {string} and {string}")
    public void iEnterValidDetailsForAnd(String firstName, String lastName, String email, String telephone) {
        WebElement setFirstName = driver.findElement(By.name("firstname"));
        setFirstName.sendKeys(firstName);
        WebElement setLastName = driver.findElement(By.name("lastname"));
        setLastName.sendKeys(lastName);
        WebElement setEmail = driver.findElement(By.name("email"));
        setEmail.sendKeys(pNumber()+email);
        WebElement setTelephone = driver.findElement(By.name("telephone"));
        setTelephone.sendKeys(telephone);

    }
    @And("I enter invalid details for {string}")
    public void iEnterInvalidDetailsFor(String invPwd) {
        WebElement setInvalidPassWord = driver.findElement(By.id("input-password"));
        setInvalidPassWord.sendKeys(invPwd);
        WebElement setInvalidConPassWord = driver.findElement(By.id("input-confirm"));
        setInvalidConPassWord.sendKeys(invPwd);

    }
    @Then("I should get password and confirm password error {string}")
    public void i_should_get_password_and_confirm_password_error(String ePwMsge) {
        WebElement errorPasswrdMessage =
                driver.findElement(By.xpath("//div[@class='text-danger']"));
        String actualResult = errorPasswrdMessage.getText();
        assertThat(actualResult, is(equalTo(ePwMsge)));
        System.out.println(actualResult);

    }


    @And("I enter valid details for {string}, {string}, {string}, {string}")
    public void iEnterValidDetailsFor(String firstName, String lastName, String telephone, String pword) {
        WebElement setFirstName = driver.findElement(By.name("firstname"));
        setFirstName.sendKeys(firstName);
        WebElement setLastName = driver.findElement(By.name("lastname"));
        setLastName.sendKeys(lastName);
        WebElement setTelephone = driver.findElement(By.name("telephone"));
        setTelephone.sendKeys(telephone);
        WebElement setPassword = driver.findElement(By.name("password"));
        setPassword.sendKeys(pword);
        WebElement setConfirmPassword = driver.findElement(By.name("confirm"));
        setConfirmPassword.sendKeys(pword);

    }

    @And("I enter Invalid detail for {string} address")
    public void iEnterInvalidDetailForAddress(String email) {
        WebElement setinValidEmail = driver.findElement(By.name("email"));
        setinValidEmail.sendKeys(email);

    }

    @Then("I should get email address error {string}")
    public void iShouldGetEmailAddressError(String eEmlMsge) {
        WebElement errorEmailMessage =
                driver.findElement(By.xpath(" //div[@class='text-danger']"));
        String actualResult = errorEmailMessage.getText();
        assertThat(actualResult, is(equalTo(eEmlMsge)));
        System.out.println(actualResult);
    }

    @Then("I click on {string} menu")
    public void i_click_on_menu(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnShopByCategory = driver.findElement(By.xpath("//a[normalize-space()='Shop by Category']//span[@class='icon svg-icon']//*[name()='svg']"));
        clickOnShopByCategory.click();
    }
    @Then("I click on {string} from the left hand menu")
    public void i_click_on_from_the_left_hand_menu(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnSoftware = driver.findElement(By.xpath(" //div[@id='mz-component-1626147655']//li[4]//a[1]//div[1]//*[name()='svg']"));
        clickOnSoftware.click();
    }
    @And("I scroll down my window to select second page")
    public void iScrollDownMyWindowToSelectSecondPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 400)");
    }
    @When("I click on second page")
    public void i_click_on_second_page() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnSecondPage = driver.findElement(By.xpath(" //a[normalize-space()='2']"));
        clickOnSecondPage.click();
    }
    @When("I choose {string}")
    public void i_choose(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement selectAProduct = driver.findElement(By.xpath(" //div[@class='row']//div[1]//div[1]//div[2]//h4[1]//a[1]"));
        selectAProduct.click();
    }
    @When("I click on Buy Now")
    public void i_click_on_buy_now() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnBuyNow = driver.findElement(By.xpath(" //button[@title='Buy now']"));
        clickOnBuyNow.click();
    }
    @And("I click on I want to Use New Address")
    public void iClickOnIWantToUseNewAddress() {
        WebElement clickOnNewAddress = driver.findElement(By.xpath(" //label[@for='input-payment-address-new']"));
        clickOnNewAddress.click();
    }
    @And("I clear the telephone box")
    public void iClearTheTelephoneBox() {
        WebElement clearTelephoneSpace = driver.findElement(By.name("telephone"));
        clearTelephoneSpace.clear();
    }
    @And("I enter all neccessary personal details {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void iEnterAllNeccessaryPersonalDetailsAnd(String firstName, String lastName, String address, String telephone, String postCde, String city, String cotry, String sta) throws InterruptedException {
        WebElement setFirstName = driver.findElement(By.name("firstname"));
        setFirstName.sendKeys(firstName);
        WebElement setLastName = driver.findElement(By.name("lastname"));
        setLastName.sendKeys(lastName);
        WebElement setAddress = driver.findElement(By.name("address_1"));
        setAddress.sendKeys(address);
        WebElement setTelephone = driver.findElement(By.name("telephone"));
        setTelephone.sendKeys(telephone);
        WebElement setPostcode = driver.findElement(By.name("postcode"));
        setPostcode.sendKeys(postCde);
        WebElement setCity = driver.findElement(By.name("city"));
        setCity.sendKeys(city);

        WebElement setCountry = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select country = new Select(setCountry);
        country.selectByVisibleText(cotry);
        Thread.sleep(2000);

        WebElement setState = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select state = new Select(setState);
        state.selectByVisibleText(sta);
        Thread.sleep(2000);

    }
    @And("I scroll down my window to select agree on terms and condition")
    public void iScrollDownMyWindowToSelectAgreeOnTermsAndCondition() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 400)");

    }
    @And("I accept the agree to the Terms & Conditions")
    public void iAcceptTheAgreeToTheTermsConditions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickOnAgreeTerm =
//                driver.findElement(By.xpath("(//div[@class='custom-control custom-checkbox'])[2]"));
////        clickOnAgreeTerm.isSelected();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='input-agree']")));
        clickOnAgreeTerm.click();
    }
    @And("I click on Continue button under agree on terms and condition")
    public void iClickOnContinueButtonUnderAgreeOnTermsAndCondition() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickOnContinue =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button-save']")));
               driver.findElement(By.xpath("//button[@id='button-save']"));
        clickOnContinue.click();
        Thread.sleep(2000);
    }
    @Then("I Verify that Confirm Order page is displayed successfully")
    public void iVerifyThatConfirmOrderPageIsDisplayedSuccessfully() {
        WebElement confirmOrderPageIsDisplay =
                driver.findElement(By.xpath("//h1[@class='page-title mb-3']"));
        String actualResult = confirmOrderPageIsDisplay.getText();
        assertThat(actualResult, is(equalTo("Confirm Order")));
        System.out.println(actualResult);
    }
    @And("I click on Confirm Order button")
    public void iClickOnConfirmOrderButton() {
        WebElement clickOnConfirmOrder = driver.findElement(By.xpath(" //button[@id='button-confirm']"));
        clickOnConfirmOrder.click();

    }

    @Then("order confirmation {string} is display")
    public void orderConfirmationIsDisplay(String mssge) {
        WebElement confirmationOrderPlacedIsDisplay =
                driver.findElement(By.xpath("//h1[@class='page-title my-3']"));
        String actualResult = confirmationOrderPlacedIsDisplay.getText();
        assertThat(actualResult, is(equalTo(mssge)));
        System.out.println(actualResult);

    }
    @When("I hover on my account and I click on logout of my account.")
    public void i_hover_on_my_account_and_i_click_on_logout_of_my_account() {
        // Write code here that turns the phrase above into concrete actions
        WebElement myAccount = driver.findElement(By.xpath("(//span[contains(text(),' My account')])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).perform();
        WebElement clickOnLogout = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
        clickOnLogout.click();
    }

}
