package com.translantik.stepdefinitions;

import com.translantik.pages.LocationFilterPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LocationFilter_StepDefs {

    LocationFilterPage locationFilterPage = new LocationFilterPage();

    @When("the user clicks on the Manage Filter button")
    public void theUserClicksOnTheManageFilterButton() {
        locationFilterPage.manageFilterButton.click();
        locationFilterPage.addFilter.click();
    }

    @And("the user clicks on the Location select button")
    public void theUserClicksOnTheLocationSelectButton() {
        locationFilterPage.locationButton.click();
    }

    @Then("the user should see the Location select button")
    public void theUserShouldSeeTheLocationSelectButton() {
        Assert.assertTrue(locationFilterPage.locationButton.isSelected());
    }

    @When("the user clicks on the Contains button under the Location options")
    public void theUserClicksOnTheContainsButtonUnderTheLocationOptions() {
        locationFilterPage.locationAllDropButton.click();
        locationFilterPage.dropDown.click();
    }

    @Then("the user should see the methods as below")
    public void theUserShouldSeeTheMethodsAsBelow(List<String> methods) {

        locationFilterPage.availableMethods(methods);

    }

    @When("the user clicks on the Contains method")
    public void theUserClicksOnTheContainsMethod() {
        locationFilterPage.locationAllDropButton.click();
        locationFilterPage.dropDown.click();
        locationFilterPage.containsMethod.click();
    }

    @And("the user enters a specific keyword as {string}")
    public void theUserEntersASpecificKeywordAs(String keyword) {

        locationFilterPage.inputBox.sendKeys(keyword);
        locationFilterPage.updateButton.click();
        locationFilterPage.waitUntilLoaderScreenDisappear();
    }

    @Then("the results should contains the given keyword as {string}")
    public void theResultsShouldContainsTheGivenKeywordAs(String keyword) {
        locationFilterPage.containsMethodVerification(keyword);
    }

    @When("the user clicks on the Does Not Contains method")
    public void theUserClicksOnTheDoesNotContainsMethod() {
        locationFilterPage.locationAllDropButton.click();
        locationFilterPage.dropDown.click();
        locationFilterPage.doesNotContainMethod.click();
    }

    @Then("the results should not contains the given keyword as {string}")
    public void theResultsShouldNotContainsTheGivenKeywordAs(String keyword) {
        locationFilterPage.setDoesNotContainMethod(keyword);
    }

    @When("the user clicks on the Starts With method")
    public void theUserClicksOnTheStartsWithMethod() {
        locationFilterPage.locationAllDropButton.click();
        locationFilterPage.dropDown.click();
        locationFilterPage.startsWithMethod.click();
    }


    @Then("the results should start with the given keyword as {string}")
    public void theResultsShouldStartWithTheGivenKeywordAs(String keyword) {
        locationFilterPage.setStartsWithMethod(keyword);
    }

    @When("the user clicks on the Ends With method")
    public void theUserClicksOnTheEndsWithMethod() {
        locationFilterPage.locationAllDropButton.click();
        locationFilterPage.dropDown.click();
        locationFilterPage.endsWithMethod.click();
    }

    @Then("the results should end with the given keyword as {string}")
    public void theResultsShouldEndWithTheGivenKeywordAs(String keyword) {
        locationFilterPage.setEndsWithMethod(keyword);
    }

    @When("the user clicks on the Is Equal To method")
    public void theUserClicksOnTheIsEqualToMethod() {
        locationFilterPage.locationAllDropButton.click();
        locationFilterPage.dropDown.click();
        locationFilterPage.isEqualToMethod.click();
    }


    @Then("the results should exactly match with the given keyword as {string}")
    public void theResultsShouldExactlyMatchWithTheGivenKeywordAs(String keyword) {
        locationFilterPage.setIsEqualToMethod(keyword);
    }

    @When("the user clicks on {string}")
    public void theUserClicksOnMethods(String locationMethod) {
        locationFilterPage.setAllMethods(locationMethod);
    }


    @Then("the {string} should not accept the given keyword")
    public void theShouldNotAcceptTheGivenKeyword(String locationMethod) {

        locationFilterPage.specialCharVerification(locationMethod);

    }
}
