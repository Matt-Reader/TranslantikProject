package com.translantik.stepdefinitions;

import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class DeleteACar_StepDefs {

    VehiclesPage vehicle = new VehiclesPage();
    @When("the user hover on the three dots at the end each row")
    public void the_user_hover_on_the_three_dots_at_the_end_each_row() {

        Driver.get().manage().window().maximize();
        BrowserUtils.waitFor(2);
        vehicle.hoverOnThreeDot();

    }


    @Then("the user can see the delete button")
    public void the_user_can_see_the_delete_button() {

        Assert.assertTrue("Verify tha delete button displayed", vehicle.threeDotDeleteBTN.size()>0);
    }

    @And("the user click on the delete button")
    public void theUserClickOnTheDeleteButton() {

        BrowserUtils.clickWithJS(vehicle.threeDotDeleteBTN.get(vehicle.threeDotDeleteBTN.size()-1));
        BrowserUtils.waitFor(2);
    }

    @Then("the Delete Confirmation should be display")
    public void theDeleteConfirmationShouldBeDisplay() {
        Assert.assertTrue(vehicle.deletePopUp.isDisplayed());
    }

    @And("the user click on the Yes, Delete button from pop up Delete Confirmation")
    public void theUserClickOnTheYesDeleteButtonFromPopUpDeleteConfirmation() {
        vehicle.popUpYesDeleteBTN.click();
        BrowserUtils.waitFor(1);
    }

    @Then("for user the message {string} should be displayed")
    public void forUserTheMessageShouldBeDisplayed(String expectedMSG) {
        Assert.assertEquals("Verify delete alert message", expectedMSG, vehicle.alertDeleteMSG.getText());
    }


    @And("the user click on any random row in vehicle page")
    public void theUserClickOnAnyRandomRowInVehiclePage() {
        Driver.get().manage().window().maximize();
        BrowserUtils.waitFor(10);
        //Driver.get().findElements(By.xpath("//tbody//tr[@class='grid-row row-click-action']")).size()
        Random random = new Random();
        int randomRow = random.nextInt(Driver.get().findElements(By.xpath("//tbody//tr[@class='grid-row row-click-action']")).size());
        BrowserUtils.waitFor(4);
        String element = "//tbody//tr[@class='grid-row row-click-action']//td[4]";
        WebElement webEleRow = Driver.get().findElement(By.xpath("//tbody//tr[@class='grid-row row-click-action']//td[4]"));
        
        BrowserUtils.clickWithJS(webEleRow);
        vehicle.waitUntilLoaderScreenDisappear();
    }

    @When("the user click on the delete button in General Information page")
    public void theUserClickOnTheDeleteButtonInGeneralInformationPage() {
        vehicle.generalInfoDltBtn.click();
    }
}
