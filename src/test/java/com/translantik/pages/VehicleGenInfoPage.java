package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class VehicleGenInfoPage extends BasePage{

    @FindBy (css = ".user-fieldset>span")
    public WebElement genInfoTextLink;

    @FindBy (css = "a[title='Edit Car']")
    public WebElement editLocator;

    @FindBy (css = "a[title='Delete Car']")
    public WebElement deleteLocator;

    @FindBy (css = "a[title='Add an event to this record']")
    public WebElement addEventLocator;

    @FindBy (css = "div.control-label")
    public List<WebElement> listOfGenInfo;

    @FindBy(xpath = "//tbody//tr//td//div[@class='dropdown']")
    List<WebElement> threeDotWebelements;

    //give a random number
    @FindBy (xpath = "(//tbody//tr//td//div[@class='dropdown'])[3]")
    public WebElement randomThreeDotLocator;

    @FindBy(css = "a[title='View']")
    public WebElement viewBTN;

    public List<String> getInfoRowsList(int randomRowValue){

        List<WebElement> genInfoElements =Driver.get().findElements(By.xpath("(//div//tbody/tr)["+randomRowValue+"]/td"));

        List<String> genInfosOnTheVehiclesPage = BrowserUtils.getElementsText(genInfoElements);

        return genInfosOnTheVehiclesPage;
    }

/*    public void clickRandomRow(){

        Random rand = new Random();
        int randomRow= rand.nextInt(Driver.get().findElements(By.xpath("//tr//td[@data-column-label='Driver']")).size());

        WebElement randomRowWebELement = Driver.get().findElement(By.xpath("((//div//tbody/tr)["+randomRow+"]/td)[3]"));

        randomRowWebELement.click();

    }*/

}
