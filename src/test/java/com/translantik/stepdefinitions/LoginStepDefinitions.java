package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import com.translantik.utilities.UserGenerator;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {


    @Then("the user should be login as a {string}")
    public void the_user_should_be_login_as_a(String userType) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserGenerator userGenerator = new UserGenerator();

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        UserGenerator.userGen(userType);
        //send username and password and login
        loginPage.login(UserGenerator.username, UserGenerator.password);

        if (userType.equals("driver")){
            String expectedSubtitle = "Quick Launchpad";
            Assert.assertTrue("Verify that user should land to the Quick Launcpad",
                    expectedSubtitle.equalsIgnoreCase(dashboardPage.pageSubtitleLocator.getText()));

        }else if (userType.equalsIgnoreCase("sales manager") || userType.equalsIgnoreCase("store manager")){
            String expectedSubtitle = "Dashboard";
            Assert.assertTrue("Verify that user should land to the Dashboard",
                    expectedSubtitle.equalsIgnoreCase(dashboardPage.pageSubtitleLocator.getText()));

        }
    }


}
