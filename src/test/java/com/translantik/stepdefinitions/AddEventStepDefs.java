package com.translantik.stepdefinitions;

import com.github.javafaker.Faker;
import com.translantik.pages.VehiclesPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddEventStepDefs {
    VehiclesPage vehiclesPage=new VehiclesPage();

    Faker faker=new Faker();

    @When("the user should be able to click any vehicle")
    public void the_user_should_be_able_to_click_any_vehicle() {


        BrowserUtils.waitFor(6);
        List<WebElement> carList=Driver.get().findElements(By.xpath("//tbody/tr"));
        /*for (int i = 1; i < carList.size(); i++) {

            WebElement row=Driver.get().findElement(By.xpath("//tbody/tr["+i+"]"));
            row.click();
            BrowserUtils.waitFor(3);
            Assert.assertTrue("verify the add button is here",Driver.get().findElement(By.cssSelector("a[title='Add an event to this record']")).isDisplayed());
            Driver.get().navigate().back();
            BrowserUtils.waitFor(2);
        }*/
        int vehicle= faker.random().nextInt(1,carList.size());
        Driver.get().findElement(By.xpath("//tbody/tr["+vehicle+"]")).click();
        BrowserUtils.waitFor(2);

    }

    @Then("the user should be able to launch on {string} page")
    public void the_user_should_be_able_to_launch_on_page(String generalInfo) {
        generalInfo=Driver.get().findElement(By.cssSelector("h5[class='user-fieldset'] span")).getText();
        Assert.assertEquals("General Information",generalInfo);
    }

    @Then("the user should be able to see {string} button")
    public void the_user_should_be_able_to_see_button(String buttonName) {
        Assert.assertEquals("verify that Add Event button is here","Add Event",buttonName);
        System.out.println("buttonName = " + buttonName);
    }

    @When("the user should be able to click on {string} button")
    public void theUserShouldBeAbleToClickOnButton(String addButton) {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.cssSelector("a[title='Add an event to this record']")).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the {string} pop up should be open")
    public void the_pop_up_should_be_open(String popUp) {
        Assert.assertTrue("verify the page is popup",Driver.get().findElement(By.cssSelector("div[role='dialog']")).isDisplayed());
        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }

    @Given("the user can select any color")
    public void theUserCanSelectAnyColor() {
        Driver.get().findElement(By.cssSelector("span[title='#5484ED']")).click();
        BrowserUtils.waitFor(2);
        Assert.assertTrue("the color is selected",Driver.get().findElement(By.cssSelector("span[title='#5484ED']")).isDisplayed());
        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }

    @And("the user should be able to click {string}")
    public void theUserShouldBeAbleToClick(String allDay) {
        Driver.get().findElement(By.xpath("//input[starts-with(@id, 'oro_calendar_event_form_allDay-uid')]")).click();
        Assert.assertTrue("The box is selected",Driver.get().findElement(By.xpath("//input[starts-with(@id, 'oro_calendar_event_form_allDay-uid')]")).isSelected());
        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }

    @When("the user should be able to click {string} checkbox")
    public void theUserShouldBeAbleToClickCheckbox(String repeatCheckBox) {
        Driver.get().findElement(By.xpath("//input[starts-with(@id, 'recurrence-repeat')]")).click();
        Assert.assertTrue("verify the checkbox is selected",Driver.get().findElement(By.xpath("//input[starts-with(@id, 'recurrence-repeat')]")).isSelected());

    }
    @And("the user should be able to see {string} {string} {string} {string}")
    public void theUserShouldBeAbleToSee(String daily, String weekly, String monthly, String yearly) {
        WebElement dropDown = Driver.get().findElement(By.xpath("//select[starts-with(@id, 'recurrence-repeats')]"));
        List<WebElement> dropDownMenu=Driver.get().findElements(By.xpath("//select[starts-with(@id, 'recurrence-repeats')]"));
        List<String>str= new ArrayList();
        str.add(0,daily);
        str.add(1,weekly);
        str.add(2,monthly);
        str.add(3,yearly);

        /*for (int i = 0; i < dropDownMenu.size(); i++) {
            //System.out.println("dropDownMenu.get(1).getText() = " + str[i]);
            Assert.assertEquals(str.get(i),dropDownMenu.get(i).getText());
        }*/

        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }

    @And("the user should be able to click {string} radio button")
    public void theUserShouldBeAbleToClickRadioButton(String neverRadio) {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector("input[checked='checked']")).isSelected());

    }

    @Then("the user should be able to see {string} {string} {string}")
    public void theUserShouldBeAbleToSee(String never, String after, String by) {
        Assert.assertEquals(never, Driver.get().findElement(By.xpath("//span[normalize-space()='Never']")).getText());
        Assert.assertEquals(after, Driver.get().findElement(By.xpath("//span[normalize-space()='After']")).getText());
        Assert.assertEquals(by, Driver.get().findElement(By.xpath("//span[normalize-space()='By']")).getText());
        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
    }

    @Given("the user can see all events on the General information page")
    public void the_user_can_see_all_events_on_the_General_information_page() {

        List<WebElement> generalInfoRows=Driver.get().findElements(By.xpath("(//div[@class='row-fluid'])[1]/div/div/div"));
        String generalTitle=Driver.get().findElement(By.xpath("(//div[@class='row-fluid'])[1]/div/div/h5")).getText();
        List<WebElement> detailInfo=Driver.get().findElements(By.xpath("(//div[@class='row-fluid'])[1]/div/div/div/div/div"));
        List<WebElement> infoLabel=Driver.get().findElements(By.xpath("(//div[@class='row-fluid'])[1]/div/div/div/label"));


        for (int i =0 ; i < 1; i++) {
            System.out.println("generalTitle is = " + generalTitle);
            for (int j = 0; j <= generalInfoRows.size()-1; j++) {
                System.out.println("Line "+j+" of the information is = " + infoLabel.get(j).getText()+" >>> "+detailInfo.get(j).getText());
                Assert.assertTrue("the user can see",infoLabel.get(j).isDisplayed());
                Assert.assertTrue("the user can see",detailInfo.get(j).isDisplayed());
            }

        }
    }


}
