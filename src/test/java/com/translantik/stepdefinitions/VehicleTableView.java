package com.translantik.stepdefinitions;

import com.translantik.pages.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VehicleTableView {
    VehiclesPage vehiclesPage=new VehiclesPage();
    @When("the user should see all vehicles information under module")
    public void theUserShouldSeeAllVehiclesInformationUnderModule() {
        vehiclesPage.driverNameIsVisible();
    }

    @Then("the user should see the total page number")
    public void theUserShouldSeeTheTotalPageNumber() {
        vehiclesPage.totalPgeNumberIsVisible();
    }
}
