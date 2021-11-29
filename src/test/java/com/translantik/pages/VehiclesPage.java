package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class VehiclesPage extends BasePage {


    @FindBy(xpath = "(//td//div/a[@data-toggle='dropdown'])/..//li/a[@title='Delete']")
    public WebElement threeDotDeleteBTN;

    public void hoverOnThreeDot (){

//        Random rand = new Random();
//        int randomRowThreeDot= rand.nextInt(Driver.get().findElements(By.xpath("//td//div/a[@data-toggle='dropdown']")).size());

        Actions actions = new Actions(Driver.get());
        WebElement threeDot = Driver.get().findElement(By.xpath("(//td//div/a[@data-toggle='dropdown'])[3]"));

        actions.moveToElement(threeDot).build().perform();
        threeDot.click();
        BrowserUtils.waitFor(3);
    }


}
