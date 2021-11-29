package com.translantik.stepdefinitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.GridSettingsPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import com.translantik.utilities.UserGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class GridSettingsStepDefs {
    Actions actions = new Actions(Driver.get());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
    Random rn = new Random();
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

    @Then("the user checked all the traits one by one")
    public void theUserCheckedAllTheTraitsOneByOne(List<String> menuOptions) {
        int i = 1;
        for (String element : menuOptions) {
            gridSettingsPage.quickSearchField.sendKeys(element);
            Assert.assertEquals(element,Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table table-condensed']//tbody/tr)["+i+"]")).getText());
            gridSettingsPage.quickSearchField.clear();
            i++;
        }

    }

    @Then("the user unclicked some of the menu icons")
    public void theUserUnclickedsomeOfTheMenuIcons() {
        // this code is not able to click all the elements I guess I need to scroll down at the same time eith a new loop

        for (int i = 2 ; i<=7 ; i++) {
           Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table table-condensed']//tbody/tr)["+i+"]")).click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @And("the user select {} column randomly and the column should appear on the All Cars page screen")
    public void theUserSelectColumnRandomlyAndtheColumnShouldAppearOnTheAllCarsPageScreen(String columns) {

        int randomCheckbox = rn.nextInt(6)+1 ;

        WebElement element = Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table " +
                "table-condensed']//tbody/tr)[" + randomCheckbox + "]"));
        element.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (WebElement carsPageHeader : gridSettingsPage.carsPageHeaders) {
            String text = carsPageHeader.getText();

            if(text.equalsIgnoreCase(element.getText())){
                break;
            }else{
                System.out.println("verify the checkbox that randomly selected");
            }
    }
    }

    @When("drag and drop any element, needs to be changed it's order")
    public void dragAndDropAnyElementNeedsToBeChangedItSOrder() {
            String dummy = "Id";
        for (int i = 0; i < 5; i++) {
            int source = rn.nextInt(10) +6;
            int target = 0;

            actions.moveToElement(gridSettingsPage.sortList.get(source)).clickAndHold().
                    pause(1000).moveToElement(gridSettingsPage.sortList.get(target)).pause(1000).release().perform();
            BrowserUtils.waitFor(2);
            Assert.assertFalse(dummy.contains(gridSettingsPage.titleCell.get(0).getText()));
            dummy+=gridSettingsPage.titleCell.get(0).getText();

        }

    }
}
