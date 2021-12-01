package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddEventPage {

    @FindBy (css = "div[role='dialog']")
    public WebElement popUpPage;

    @FindBy (css = "span[title='#5484ED']")
    public WebElement colorBlue;

    @FindBy (className = "simplecolorpicker inline fontawesome with-empty-color with-custom-color")
    public List<WebElement> colorColumn;

    @FindBy (css = "button[title='close']")
    public WebElement closeButton;

    @FindBy (xpath = "//input[starts-with(@id, 'oro_calendar_event_form_allDay-uid')]")
    public WebElement allDayEventCheckBox;

    @FindBy (xpath = "//input[starts-with(@id, 'recurrence-repeat')]")
    public WebElement repeatBox;

    @FindBy (xpath = "//select[starts-with(@id, 'recurrence-repeats')]")
    public WebElement repeatDropDown;

    @FindBy (css = "input[checked='checked']")
    public WebElement neverButton;

    @FindBy (css = "input[checked='checked']")
    public WebElement afterButton;

    @FindBy (xpath = "(//input[@type='radio'])[4]")
    public WebElement byButton;

}
