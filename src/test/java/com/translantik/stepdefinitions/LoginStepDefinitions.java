package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {


    @Then("the user should be login as a {string}")
    public void the_user_should_be_login_as_a(String userType) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        //send username and password and login
        loginPage.login(username, password);

        if (userType.equals("driver")){
            String expectedSubtitle = "Quick Launchpad";
            Assert.assertTrue("Verify that user should land to the Quick Launcpad",
                    expectedSubtitle.equalsIgnoreCase(dashboardPage.pageSubtitleLocator.getText()));

        }else if (userType.equalsIgnoreCase("sales manager") || userType.equalsIgnoreCase("store manager")){
            String expectedSubtitle = "Dashboard";
            Assert.assertTrue("Verify that user should land to the Quick Launcpad",
                    expectedSubtitle.equalsIgnoreCase(dashboardPage.pageSubtitleLocator.getText()));

        }
    }


}
