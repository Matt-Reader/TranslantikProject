package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GridSettingsPage extends BasePage{

    @FindBy(css=".fa-cog.hide-text")
    public WebElement gridSettingsButton;

    @FindBy(xpath="//*[text()='Grid Settings']")
    public WebElement gridSettingsMenuTitle;

    @FindBy(xpath="(//*[@class='grid table-hover table table-condensed']//tbody/tr)")
    public List<WebElement> GSOptionsTable;

    @FindBy(css=".column-manager-search.empty>input")
    public WebElement quickSearchField;

    // I did not use that locator because I created a dynamic locator in order to verify grid settings menu options
    @FindBy(xpath="(//*[@class='grid table-hover table table-condensed']//tbody/tr)[1]")
    public WebElement firstElementOnGS;
    // all cars table inside the car page
    @FindBy(xpath="//*[@class='grid table-hover table table-bordered table-condensed']/thead[1]/tr/th")
    public List<WebElement> carsPageHeaders;
    // all 20 arrows inside the grid settings
    @FindBy(css = ".sort-cell>span>i")
    public List<WebElement> sortList;

    @FindBy(css = ".title-cell>label")
    public List<WebElement> titleCell;


    Actions actions = new Actions(Driver.get());
    Random rn = new Random();

    /**
     * this method clicks any number of the columns at the grid settings page and verify
     * @param columnNumber
     *
     */
    public void clickColumnsandVerify(int columnNumber){

        for (int i = 1; i <= columnNumber; i++) {

            Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table table-condensed']//tbody/tr)["+i+"]")).click();
             BrowserUtils.waitFor(1);
            String actualText = this.carsPageHeaders.get(i).getText();
            String expectedTextUpper = this.titleCell.get((i-1)).getText().toUpperCase(Locale.ROOT);
            Assert.assertEquals("verify that the element clicked",expectedTextUpper,actualText);

        }
    }

    /**
     *
     * This method can unclick max 7 rows safely. Because of the Java script code
     * @param columnNumber
     */
    public void unclickMenuItems(int columnNumber){
  for (int i = 2 ; i<=columnNumber ; i++) {
      Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table table-condensed']//tbody/tr)[" + i + "]")).click();
  }
    }

    /**
     *
     * This method can drag and drop any number of elements which is bigger than from its place o the
     * begining of the grid settings menu parameters
     * @param number
     */
    public void dragAndDropItems(int number) {

        String dummy = "Id";
        for (int i = 0; i < number; i++) {
            int source = rn.nextInt(10) + 6;
            int target = 0;

            actions.moveToElement(this.sortList.get(source)).clickAndHold().
                    pause(1000).moveToElement(this.sortList.get(target)).pause(1000).release().perform();
            BrowserUtils.waitFor(2);
            Assert.assertFalse(dummy.contains(this.titleCell.get(0).getText()));
            dummy += this.titleCell.get(0).getText();

        }
    }

    /**
     * this method clicks one random checkbox which is between 0-6 checkboxes
     */
    public void clickARondomCheckBox() {
        int randomCheckbox = rn.nextInt(6)+1 ;

        WebElement element = Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table " +
                "table-condensed']//tbody/tr)[" + randomCheckbox + "]"));
        element.click();
        BrowserUtils.waitFor(1);
    }

    /**
     * This method writes all of the menu options, which given in feature files as a list, in the Grid Settings text fields
     * And verify if it finds the written element appear as a first element of the table underneath.
     * @param menuOptions
     */

    public void menuoptionsSearchEngine(List<String> menuOptions) {

        int i = 1;
        for (String element : menuOptions) {
            this.quickSearchField.sendKeys(element);
            Assert.assertEquals(element,Driver.get().findElement(By.xpath("(//*[@class='grid table-hover table table-condensed']//tbody/tr)["+i+"]")).getText());
            this.quickSearchField.clear();
            i++;
        }
    }
    }









