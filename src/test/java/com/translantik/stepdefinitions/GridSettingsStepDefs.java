package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;

public class GridSettingsStepDefs {
    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Given("the user is on the loginpage")
    public void the_user_is_on_the_loginpage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
}
