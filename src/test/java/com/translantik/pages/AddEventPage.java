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

    @FindBy(xpath = "(//label[@aria-required='true'])[1]")
    public WebElement titleCompulsoryFieldSign;

    @FindBy(xpath = "(//label[@aria-required='true'])[2]")
    public WebElement ownerCompulsoryFieldSign;

    @FindBy(xpath = "(//label[@aria-required='true'])[3]")
    public WebElement organizerDisplayNameCompulsoryFieldSign;

    @FindBy(xpath = "(//label[@aria-required='true'])[4]")
    public WebElement organizerEmailCompulsoryFieldSign;

    @FindBy(xpath = "(//label[@aria-required='true'])[5]")
    public WebElement startDateCompulsoryFieldSign;

    @FindBy(xpath = "(//label[@aria-required='true'])[6]")
    public WebElement endDateCompulsoryFieldSign;

    @FindBy(xpath = "//input[contains(@id,'oro_calendar_event_form_title-uid-')]")
    public WebElement titleInputBox;

    @FindBy(xpath = "//input[contains(@id,'oro_calendar_event_form_organizerDisplayName')]")
    public WebElement organizerDisplayNameInputBox;

    @FindBy(xpath = "//input[contains(@id,'oro_calendar_event_form_organizerEmail')]")
    public WebElement organizerEmailInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),'This value should not be blank.')]")
    public WebElement titleAlert;




}
