package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
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

    public void hoverOnThreeDot (){

        Random rand = new Random();
        int randomRowThreeDot= rand.nextInt(Driver.get().findElements(By.xpath("//td//div/a[@data-toggle='dropdown']")).size());

        Actions actions = new Actions(Driver.get());
        WebElement threeDot = Driver.get().findElement(By.xpath("(//td//div/a[@data-toggle='dropdown'])["+randomRowThreeDot+"]"));

        actions.moveToElement(threeDot).build().perform();
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(threeDot);
    }



}
