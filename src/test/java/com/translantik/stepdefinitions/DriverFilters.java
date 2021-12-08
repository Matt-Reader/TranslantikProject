package com.translantik.stepdefinitions;

import com.translantik.pages.DriverFiltersPage;
import com.translantik.pages.FilterMenuPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.AssertionFailedError;
import org.junit.Assert;

import java.util.List;
import java.util.Locale;

public class DriverFilters {
    DriverFiltersPage dfp = new DriverFiltersPage();

    @When("the user click on Driver filter option")
    public void theUserClickOnDriverFilterOption() {
        dfp.selectDriverFilterOption();
    }

    @Then("the user should be able to see driver filter tab")
    public void theUserShouldBeAbleToSeeDriverFilterTab() {
        dfp.checkFilterSelected();
    }

    @When("the user click on Driver filter tab")
    public void theUserClickOnDriverFilterTab() {
        dfp.driverFilterTab.click();
    }

    @Then("the user should be able to see the options below")
    public void theUserShouldBeAbleToSeeTheOptions(List<String> options) {
        Assert.assertTrue(dfp.verifyOptions(options));
    }

    @And("the user click on filter choice")
    public void theUserClickOnFilterChoice() {
        dfp.choiceFilter.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user select {string}")
    public void theUserSelect(String filterType) {
        dfp.getOption(0,filterType).click();
    }

    @And("enter the {string}")
    public void enterThe(String keyword) {
        dfp.searchInput.sendKeys(keyword);
    }

    @Then("the result should be {string} the {string}")
    public void theResultShouldBeAsWithThe(String expected, String keyword) {
        dfp.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(dfp.verifyTextList(expected, keyword.toLowerCase()));
    }

    @And("click the update button")
    public void clickTheUpdateButton() {
        dfp.filterUpdateButton.click();
    }

    @And("the user click on the filter button")
    public void theUserClickOnTheFilterButton() {
        BrowserUtils.waitFor(4);
        dfp.filterIconClick();
    }
}
