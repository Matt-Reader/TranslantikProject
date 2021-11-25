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

}
