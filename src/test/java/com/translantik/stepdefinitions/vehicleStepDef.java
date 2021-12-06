package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;

public class vehicleStepDef {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("the {string} is on the Vehicles page")
    public void theIsOnTheVehiclesPage(String userType) {

        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.LoginAsUserTypes(userType);
        dashboardPage.navigateToModule("Fleet", "Vehicles");
        dashboardPage.waitUntilLoaderScreenDisappear();
}}
