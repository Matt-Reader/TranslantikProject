package com.translantik.stepdefinitions;


import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VehicleTableView {
    VehiclesPage vehiclesPage=new VehiclesPage();
    @When("the user should see all vehicles information under module")
    public void theUserShouldSeeAllVehiclesInformationUnderModule() {
        BrowserUtils.waitFor(3);
        vehiclesPage.driverNameIsVisible();
    }

    @Then("the user should see the total page number")
    public void theUserShouldSeeTheTotalPageNumber() {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(vehiclesPage.totalPageNumber.isDisplayed());

    }

    @And("the user should go to next page after clicking the next button")
    public void theUserShouldGoToNextPageAfterClickingTheNextButton() {
        vehiclesPage.nextButton.click();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(vehiclesPage.PageNumber.getAttribute("value"),"2");
    }

    @And("the user should go to previous page after clicking the previous button")
    public void theUserShouldGoToPreviousPageAfterClickingThePreviousButton() {
        vehiclesPage.previousButton.click();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(vehiclesPage.PageNumber.getAttribute("value"),"1");

    }

    @And("the user should see the total recordings of vehicles")
    public void theUserShouldSeeTheTotalRecordingsOfVehicles() {
        Assert.assertTrue(vehiclesPage.totalVehicleNumber.isDisplayed());
    }

    @And("the user should download table data in XLS or CSV format from Export Grid button")
    public void theUserShouldDownloadTableDataInXLSOrCSVFormatFromExportGridButton() {
        vehiclesPage.exportGridButton.click();
        BrowserUtils.waitFor(1);
        vehiclesPage.CSVButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(vehiclesPage.confirmMessage.isDisplayed());

    }
}
