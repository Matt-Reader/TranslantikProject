package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

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



}
