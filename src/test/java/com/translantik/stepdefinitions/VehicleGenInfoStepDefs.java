package com.translantik.stepdefinitions;

import com.translantik.pages.VehicleGenInfoPage;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleGenInfoStepDefs {

    VehicleGenInfoPage vehicleGenInfoPage = new VehicleGenInfoPage();
    VehiclesPage vehiclesPage = new VehiclesPage();

    @Then("the user can see the {string} page")
    public void theUserCanSeeThePage(String expectedTitle) {
        BrowserUtils.waitFor(1);
        String actualTitle = vehicleGenInfoPage.genInfoTextLink.getText();
        Assert.assertEquals("Verify user land on 'General Information' page",expectedTitle,actualTitle);
    }

    @When("the user should land on General Information page")
    public void theUserShouldLandOnGeneralInformationPage() {
        vehicleGenInfoPage.clickRandomRow();
    }


    @Then("verify the user should see Edit, Delete and Add Event buttons on the General Information page")
    public void verifyTheUserShouldSeeEditDeleteAndAddEventButtonsOnTheGeneralInformationPage() {

        Assert.assertTrue("Verify Edit Button is displayed",vehicleGenInfoPage.editLocator.isDisplayed());
        Assert.assertTrue("Verify Delete Button is displayed",vehicleGenInfoPage.deleteLocator.isDisplayed());
        Assert.assertTrue("Verify Add Event Button is displayed",vehicleGenInfoPage.addEventLocator.isDisplayed());

    }

    @Then("the driver shouldn't see Add Event, Edit and Delete buttons")
    public void theDriverShouldnTSeeAddEventEditAndDeleteButtons() {

        Assert.assertFalse("Verify Add Event Button is not displayed",vehicleGenInfoPage.addEventLocator.isDisplayed());
        Assert.assertFalse("Verify Edit Button is not displayed",vehicleGenInfoPage.editLocator.isDisplayed());
        Assert.assertFalse("Verify Delete Button is not displayed",vehicleGenInfoPage.deleteLocator.isDisplayed());

    }


    @When("the user information must be same on the  General Information  and Fleet-Vehicle page")
    public void theUserInformationMustBeSameOnTheGeneralInformationAndFleetVehiclePage() {

        Driver.get().manage().window().maximize();
        BrowserUtils.waitFor(1);

        Random rand = new Random();
        int randomRow= rand.nextInt(Driver.get().findElements(By.xpath("//tr//td[@data-column-label='Driver']")).size());

        List<String> expectedRowValues = vehicleGenInfoPage.getInfoRowsList(randomRow);

        for (String value : expectedRowValues) {
            if (value.contains(",")){
                value.replace(",","");
            }
        }

        WebElement randomRowElement = Driver.get().findElement(By.xpath("(//tr//td[@data-column-label='Driver'])["+randomRow+"]"));

        System.out.println("vehiclesPage.getInfoRowsList(5) = " + expectedRowValues);

        BrowserUtils.waitFor(2);
        randomRowElement.click();
        BrowserUtils.waitFor(3);

        List<String> allValuesGenInfo =BrowserUtils.getElementsText(vehicleGenInfoPage.listOfGenInfo);

        List<String> actualValuesGenInfo = new ArrayList<>();

        for (int i = 0; i < 19; i++) {
           actualValuesGenInfo.add(i,allValuesGenInfo.get(i));
        }

        System.out.println("actualValuesGenInfo = " + actualValuesGenInfo);


        Assert.assertTrue("Check all the info is the same in Vehicles and General Information Page",expectedRowValues.equals(actualValuesGenInfo));

        BrowserUtils.waitFor(3);



    }
    //TODO
    @When("the user click any vehicle \\(row) under the Fleet-Vehicle module")
    public void theUserClickAnyVehicleRowUnderTheFleetVehicleModule() {



    }
}
