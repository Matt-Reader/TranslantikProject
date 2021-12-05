package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("the user should be login as a {string}")
    public void the_user_should_be_login_as_a(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.LoginAsUserTypes(userType);

    }

    @Given("the user logged in as {string}")
    public void theUserLoggedInAsA(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.LoginAsUserTypes(userType);
    }

//    @Given("the user logged in as {string}")
//    public void the_user_logged_in_as(String userType) {
//
//        Driver.get().get(ConfigurationReader.get("url"));
//        String username = null;
//        String password = null;
//
//        if (userType.equals("driver")) {
//            username = ConfigurationReader.get("driver_username");
//            password = ConfigurationReader.get("driver_password");
//
//        } else if (userType.equals("sales manager")) {
//            username = ConfigurationReader.get("salesmanager_username");
//            password = ConfigurationReader.get("salesmanager_password");
//
//        }
//        if (userType.equals("store manager")) {
//            username = ConfigurationReader.get("storemanager_username");
//            password = ConfigurationReader.get("storemanager_password");
//
//        }
//
//        new LoginPage().login(username, password);
//
//    }


    @Then("the subtitle contains {string}")
    public void the_subtitle_contains(String expectedSubTitle) {

        BrowserUtils.waitFor(2);
        System.out.println("expectedSubTitle = " + expectedSubTitle);
        String actualSubTitle = new DashboardPage().pageSubTitle.getText();
        System.out.println("actualSubTitle = " + actualSubTitle);
        Assert.assertTrue(actualSubTitle.contains(expectedSubTitle));

    }

    @Then("the user get current url")
    public String the_user_get_current_url() {
        return Driver.get().getCurrentUrl();

    }

    @Then("the user logs out")
    public void the_user_logs_out() {
        new DashboardPage().logOut();

    }

    @Then("the user paste url into address bar and presses enter")
    public void the_user_paste_url_into_address_bar_and_presses_enter() {
        the_user_get_current_url();
        Driver.get().navigate().to(the_user_get_current_url());

    }

    @Then("the user see own username in profile menu")
    public void the_user_see_own_username_in_profile_menu() {
        String userName = new DashboardPage().userName.getText();
        System.out.println("userName = " + userName);

    }

    @Given("the user tries to login with invalid credentials")
    public void the_user_tries_to_login_with_invalid_credentials() {
        Driver.get().get(ConfigurationReader.get("url"));
        String username = "abc123";
        String password = "111111";
        loginPage.login(username, password);

    }

    @Then("the user sees error massage on the login page")
    public void the_user_sees_error_massage_on_the_login_page() {
        WebElement error = Driver.get().findElement(By.cssSelector("#login-form > fieldset > div.alert.alert-error > div"));
        System.out.println("error.getText() = " + error.getText());

    }

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @Then("the user sees password as default bullet in password box")
    public void the_user_sees_password_as_default_bullet_in_password_box() {
        String password = "111111";
        WebElement passwordInput = Driver.get().findElement(By.id("prependedInput2"));
        passwordInput.sendKeys(password);
        String expectedPaswordType = "password";
        String actualPasswordType = passwordInput.getAttribute("type");
        Assert.assertEquals("Verify the type of password input", expectedPaswordType, actualPasswordType);

    }

    @When("the user click {string} link")
    public void the_user_click_link(String string) {
        Driver.get().findElement(By.linkText("Forgot your password?")).click();

    }

    @Then("the user land on {string} page")
    public void the_user_land_on_page(String expectedTitle) {
        WebElement actualTitle = Driver.get().findElement(By.xpath("//*[@id=\"central-panel\"]/div/div/div[1]/form/div/h2"));
        String actualTitleText = actualTitle.getText();
        Assert.assertEquals("Verify land on the Forgot Password page", expectedTitle, actualTitleText);

    }

    @When("the user sees {string} link")
    public void the_user_sees_link(String expectedText) {
        WebElement actualLink = Driver.get().findElement(By.className("custom-checkbox__text"));
        String actualLinkText = actualLink.getText();
        Assert.assertEquals("Verify that see the link text",expectedText,actualLinkText);

    }

    @Then("the user clickable {string} link")
    public void the_user_clickable_link(String string) {
        BrowserUtils.clickWithJS(loginPage.rememberMeCheckBox);
        BrowserUtils.waitFor(3);
        Assert.assertTrue("Verify Remember me check box clickable", loginPage.rememberMeCheckBox.isSelected());

    }

    @When("the user enters the username in the username box and click on enter on the keyboard")
    public void the_user_enters_the_username_in_the_username_box_and_click_on_enter_on_the_keyboard() {
        loginPage.userName.sendKeys("user1");
        loginPage.userName.sendKeys(Keys.ENTER);

    }

    @Then("the user enters the password in the password box and click on enter on the keyboard")
    public void the_user_enters_the_password_in_the_password_box_and_click_on_enter_on_the_keyboard() {
        loginPage.password.sendKeys("UserUser123");
        loginPage.password.sendKeys(Keys.ENTER);

    }

    @Then("the user sees {string} title")
    public void the_user_sees_title(String expectedTitle) {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }




}
