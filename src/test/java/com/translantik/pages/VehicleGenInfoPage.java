package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

}
