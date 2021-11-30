package com.translantik.stepdefinitions;

import com.translantik.pages.GridSettingsPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;


public class GridSettingsStepDefs {

    LoginPage loginPage = new LoginPage();
    GridSettingsPage gridSettingsPage = new GridSettingsPage();

    @Given("the user logged in as {string}")
    public void theUserLoggedInAsA(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.LoginAsUserTypes(userType);
    }

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_page() {
        gridSettingsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        gridSettingsPage.navigateToModule("Fleet","Vehicles");
    }

    @When("the user clicks on the gear icon")
    public void the_user_clicks_on_the_gear_icon() {
        gridSettingsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(7);
        gridSettingsPage.gridSettingsButton.click();
    }

    @Then("the user see the {string}")
    public void the_user_see_the(String gridSettings) {

        String actualTitle = gridSettingsPage.gridSettingsMenuTitle.getText();
        String expectedTitle = gridSettings;
        Assert.assertEquals("verify the page",expectedTitle,actualTitle);
    }

    @Then("the user see the grid settings as expected")
    public void theUserSeeTheGridSettingsAsExpected(List<String> menuOptions) {

        List<String> actualOptions = BrowserUtils.getElementsText(gridSettingsPage.GSOptionsTable);
        Assert.assertEquals(menuOptions,actualOptions);
    }

    @Then("the user checked all the menu options one by one")
    public void theUserCheckedAllTheMenuOptionsOneByOne(List<String> menuOptions) {

        gridSettingsPage.menuoptionsSearchEngine(menuOptions);
    }

    @Then("the user unclicked some of the menu icons")
    public void theUserUnclickedsomeOfTheMenuIcons() {
        // this code is not able to click all the elements I guess I need to scroll down at the same time eith a new loop

        gridSettingsPage.unclickMenuItems(7);
    }

    @And("the user select {} column randomly and the column should appear on the All Cars page screen")
    public void theUserSelectColumnRandomlyAndtheColumnShouldAppearOnTheAllCarsPageScreen(int column) {

        gridSettingsPage.clickARondomCheckBox();
    }

    @When("drag and drop any element, needs to be changed it's order")
    public void dragAndDropAnyElementNeedsToBeChangedItSOrder() {
        gridSettingsPage.dragAndDropItems(5);
    }

    @Then("the user clicked {int} check-boxes and see corresponding changes under the Fleet-Vehicles page")
    public void theUserClickedCheckBoxesAndSeeCorrespondingChangesUnderTheFleetVehiclesPage(int number) {

        gridSettingsPage.clickColumnsandVerify(number);
    }
}
