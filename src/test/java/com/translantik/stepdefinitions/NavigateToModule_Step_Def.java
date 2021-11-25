package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import io.cucumber.java.en.Given;

public class NavigateToModule_Step_Def {

    DashboardPage dashboardPage = new DashboardPage();

    @Given("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {

        dashboardPage.navigateToModule(tab, module);
        dashboardPage.waitUntilLoaderScreenDisappear();

    }
}
