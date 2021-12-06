package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class VehiclesPage extends BasePage {


    @FindBy(css = "a[title='Delete']")
    public List<WebElement> threeDotDeleteBTN;

    @FindBy(xpath = "//h3[text()='Delete Confirmation']")
    public WebElement deletePopUp;

    @FindBy(xpath = "//a[text()='Yes, Delete']")
    public WebElement popUpYesDeleteBTN;

    @FindBy(css = "div[class='message']")
    public WebElement alertDeleteMSG;

    @FindBy(css = "a[title='Delete Car']")
    public WebElement generalInfoDltBtn;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement totalPageNumber;

    @FindBy(css = ".fa-chevron-right.hide-text")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement PageNumber;

    @FindBy(css=".fa-chevron-left.hide-text")
    public WebElement previousButton;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalVehicleNumber;

    @FindBy(css=".action.btn.mode-text-only.dropdown-toggle")
    public WebElement exportGridButton;

    @FindBy(xpath = "//a[@title='CSV']")
    public WebElement CSVButton;

    @FindBy(xpath = "//div[text()='Export started successfully. You will receive email notification upon completion.']")
    public WebElement confirmMessage;





    public void hoverOnThreeDot (){

        Random rand = new Random();
        int randomRowThreeDot= rand.nextInt(Driver.get().findElements(By.xpath("//td//div/a[@data-toggle='dropdown']")).size());

        Actions actions = new Actions(Driver.get());
        WebElement threeDot = Driver.get().findElement(By.xpath("(//td//div/a[@data-toggle='dropdown'])["+randomRowThreeDot+"]"));

        actions.moveToElement(threeDot).build().perform();
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(threeDot);
    }

    public void driverNameIsVisible(){
        for (int i = 1; i <=25 ; i++) {
    Assert.assertTrue(Driver.get().findElement(By.xpath("(//tbody/tr/td[@data-column-label='Driver'])[" + i + "]"))
            .isDisplayed());
        }
    }




}
