package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.GridSettingsPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GridSettingsStepDefs {

    GridSettingsPage gridSettingsPage = new GridSettingsPage();

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_page() {

         gridSettingsPage.navigateToModule("Fleet","Vehicles");

    }

    @When("the user clicks on the gear icon")
    public void the_user_clicks_on_the_gear_icon() {

    //WebDriverWait wait = new WebDriverWait(Driver.get(),20);
   // wait.until(ExpectedConditions.visibilityOf(gridSettingsPage.gridSettingsButton));
        BrowserUtils.waitFor(10);
        gridSettingsPage.gridSettingsButton.click();

    }

    @Then("the user see the {string}")
    public void the_user_see_the(String gridSettings) {

        String actualTitle = gridSettingsPage.gridSettingsMenuTitle.getText();
        String expectedTitle = gridSettings;
        Assert.assertEquals("verify the page",expectedTitle,actualTitle);
        gridSettingsPage.logOut();
    }

}
