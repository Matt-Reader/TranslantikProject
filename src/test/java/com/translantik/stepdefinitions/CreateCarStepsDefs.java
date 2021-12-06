package com.translantik.stepdefinitions;

import com.translantik.pages.CreateCarPage;
import com.translantik.pages.DashboardPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateCarStepsDefs {

    CreateCarPage createCarPage = new CreateCarPage();


    @And("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
        BrowserUtils.waitFor(5);
    }

    @Then("the user clicks on Create Car button")
    public void theUserClicksOnCreateCarButton() {
        createCarPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJS(createCarPage.createCarButton);
    }

    @And("the user enters new Car information")
    public void theUserEntersNewCarInformation() throws InterruptedException {
        createCarPage.newCarGenerator();

    }

    @Then("the user clicks on save changes button")
    public void theUserClicksOnSaveChangesButton() {

        createCarPage.saveAndCloseButton.click();


    }
}
