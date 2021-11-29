package com.translantik.stepdefinitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteACar_StepDefs {

    VehiclesPage vehicle = new VehiclesPage();
    @When("the user hover on the three dots at the end each row")
    public void the_user_hover_on_the_three_dots_at_the_end_each_row() {

        Driver.get().manage().window().maximize();
        vehicle.hoverOnThreeDot();

    }


    @Then("the user can see the delete button")
    public void the_user_can_see_the_delete_button() {

        Assert.assertTrue("Verify tha delete button displayed", vehicle.threeDotDeleteBTN.isDisplayed());
    }

    @And("the user click on the delete button")
    public void theUserClickOnTheDeleteButton() {
        
    }

    @Then("the Delete Confirmation should be display")
    public void theDeleteConfirmationShouldBeDisplay() {
    }
}
