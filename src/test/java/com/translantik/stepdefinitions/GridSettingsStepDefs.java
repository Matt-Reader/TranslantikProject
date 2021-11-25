package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.GridSettingsPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import com.translantik.utilities.UserGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class GridSettingsStepDefs {
    LoginPage loginPage = new LoginPage();
    GridSettingsPage gridSettingsPage = new GridSettingsPage();
    @Given("the user logged in as {string}")
    public void theUserLoggedInAsA(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));

        loginPage.LoginAsUserTypes(userType);

    }

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_page() {

         gridSettingsPage.navigateToModule("Fleet","Vehicles");

    }

    @When("the user clicks on the gear icon")
    public void the_user_clicks_on_the_gear_icon() {
        BrowserUtils.waitFor(9);
        gridSettingsPage.gridSettingsButton.click();

    }

    @Then("the user see the {string}")
    public void the_user_see_the(String gridSettings) {

        String actualTitle = gridSettingsPage.gridSettingsMenuTitle.getText();
        String expectedTitle = gridSettings;
        Assert.assertEquals("verify the page",expectedTitle,actualTitle);

    }

    @Then("the user see the grid settings as expected")
    public void theUserSeeTheGridSettingsAsExpected(List<String> menuOptions) {

        List<String> actualOptions = BrowserUtils.getElementsText(gridSettingsPage.GSOptionsTable);
        Assert.assertEquals(menuOptions,actualOptions);

    }

}
