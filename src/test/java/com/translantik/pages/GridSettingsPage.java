package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridSettingsPage extends BasePage{

    @FindBy(css=".fa-cog.hide-text")
    public WebElement gridSettingsButton;

    @FindBy(xpath="//*[text()='Grid Settings']")
    public WebElement gridSettingsMenuTitle;



}
