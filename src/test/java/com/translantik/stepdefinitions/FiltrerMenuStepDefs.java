package com.translantik.stepdefinitions;
import com.translantik.pages.DashboardPage;
import com.translantik.pages.FilterMenuPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FiltrerMenuStepDefs {
    int expectedSize;
    int actualSize;
    List<WebElement> checkBoxes;



    @Then("Manage filters should be hidden")
    public void manage_filters_should_be_hidden() {
        new FilterMenuPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        Assert.assertFalse(new FilterMenuPage().manageFilters.isDisplayed());
    }

    @When("the user click the filter button")
    public void the_user_click_the_filter_button() {
        //new FilterMenuPage().waitUntilLoaderScreenDisappear();
         WebDriverWait wait= new WebDriverWait(Driver.get(),5);
         wait.until(ExpectedConditions.elementToBeClickable(new FilterMenuPage().filterButton));
        //  BrowserUtils.hover(new FleetVehiclesPage().filterButton);
        //BrowserUtils.waitFor(3);
        // BrowserUtils.waitForClickablility(new FleetVehiclesPage().filterButton,20);
        new FilterMenuPage().filterButton.click();
        // BrowserUtils.clickWithJS(new FleetVehiclesPage().filterButton);
        BrowserUtils.waitFor(5);
    }

    @Then("Manage filter options should be displayed after clicking")
    public void manage_filter_options_should_be_displayed_after_clicking() {

        System.out.println(new FilterMenuPage().manageFilters.getText());
        Assert.assertTrue(new FilterMenuPage().manageFilters.isDisplayed());

    }
    @When("the user click on manage filter button")
    public void the_user_click_on_manage_filter_button() {
        BrowserUtils.waitFor(2);
        new FilterMenuPage().manageFilters.click();

    }

    @When("select some boxes")
    public void select_some_boxes() {
        BrowserUtils.waitFor(3);
        checkBoxes = new FilterMenuPage().manageFilterCheckBoxes;
        expectedSize = checkBoxes.size();
//        for (WebElement checkBox : checkBoxes) {
//            checkBox.click();
//        }
        for (int i = 0; i <3 ; i++) {
            checkBoxes.get(i).click();
            new FilterMenuPage().waitUntilLoaderScreenDisappear();
        }

    }


    @Then("some check boxes are selected")
    public void some_check_boxes_are_selected() {
        List<WebElement> filteredItems = new FilterMenuPage().filteredItems;
        actualSize = filteredItems.size();
        Assert.assertEquals(3,actualSize);

    }





    @Then("user should apply filtering for each of the data columns on the page")
    public void user_should_apply_filtering_for_each_of_the_data_columns_on_the_page() {





    }
    @When("select all boxes")
    public void select_all_boxes() {


        BrowserUtils.waitFor(3);
        checkBoxes = new FilterMenuPage().manageFilterCheckBoxes;
        expectedSize = checkBoxes.size();
//        for (WebElement checkBox : checkBoxes) {
//            checkBox.click();
//        }
        for (int i = 0; i <checkBoxes.size() ; i++) {
            checkBoxes.get(i).click();
            new FilterMenuPage().waitUntilLoaderScreenDisappear();
        }

    }

    @When("the user click on reset button")
    public void the_user_click_on_reset_button() {
        new FilterMenuPage().resetButton.click();
    }

    @Then("User can  remove all filterings by using the reset button")
    public void user_can_remove_all_filterings_by_using_the_reset_button() {
        for (WebElement checkBox : checkBoxes) {
            Assert.assertFalse(checkBox.isSelected());
        }
    }
    @Then("User can apply filtering for each of the {string}  on the page")
    public void user_can_apply_filtering_for_each_of_the_on_the_page(String dataColumns) {
        if (dataColumns.equals("Driver")){
            new FilterMenuPage().methodFilter(dataColumns);

            BrowserUtils.waitFor(2);
            String expectedDriverName =new FilterMenuPage().driverColumnName.getText();
            new FilterMenuPage().containsSearchBox.sendKeys(expectedDriverName+ Keys.ENTER);

            System.out.println("expectedDriverName = " + expectedDriverName);
            String actualDriverName = new FilterMenuPage().getActualCellName(dataColumns).getText();
            System.out.println("actualDriverName = " + actualDriverName);
            Assert.assertTrue(expectedDriverName.contains(actualDriverName));
        }else if(dataColumns.equals("Tags")){
            new FilterMenuPage().methodFilter(dataColumns);
            BrowserUtils.waitFor(2);
            String expectedTagName =new FilterMenuPage().tagName.getText();
            new FilterMenuPage().isAnyOfSearchBox.sendKeys(expectedTagName+ Keys.ENTER);

            System.out.println("expectedTagName = " + expectedTagName);
            String actualTagName = new FilterMenuPage().getActualCellName(dataColumns).getText();
            System.out.println("actualTagName = " + actualTagName);
            Assert.assertTrue(expectedTagName.contains(actualTagName));
        }


    }

    @Then("all check boxes are selected")
    public void all_check_boxes_are_selected() {
        List<WebElement> filteredItems = new FilterMenuPage().filteredItems;
        actualSize = filteredItems.size();
        Assert.assertEquals(expectedSize,actualSize);

    }









    @When("the user click on multiple options")
    public void the_user_click_on_multiple_options() {

        List<WebElement> manageFilterSearchBox = new FilterMenuPage().manageFilterCheckBoxes;
        for (int i = 0; i < 2; i++) {
            manageFilterSearchBox.get(i).click();
            new DashboardPage().waitUntilLoaderScreenDisappear();
        }
    }
    @When("the user sends values for the Licence Plate and Tags")
    public void the_user_sends_values_for_the_Licence_Plate_and_Tags() {

        new FilterMenuPage().filteredItems.get(0).click();
        new FilterMenuPage().containsSearchBox.sendKeys("55"+Keys.ENTER);

        new DashboardPage().waitUntilLoaderScreenDisappear();

        new FilterMenuPage().filteredItems.get(1).click();
        new FilterMenuPage().isAnyOfSearchBox.sendKeys("Purchased"+Keys.ENTER);

    }
    @Then("the application should be able to support multiple filtering of columns")
    public void the_application_should_be_able_to_support_multiple_filtering_of_columns() {

        String text = new FilterMenuPage().firstRowAfterFiltering.getText();

        System.out.println("text = " + text);

        Assert.assertTrue(text.contains("55") && text.contains("Purchased"));
    }





}

