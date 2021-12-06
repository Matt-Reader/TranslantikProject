package com.translantik.pages;

import com.translantik.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class LocationFilterPage extends BasePage{

    @FindBy(xpath = "//*[@class='fa-filter hide-text']")
    public WebElement manageFilterButton;

    @FindBy(className = "add-filter-button")
    public WebElement addFilter;

    @FindBy(id = "ui-multiselect-0-0-option-3")
    public WebElement locationButton;

    @FindBy(xpath = "//*[@class='filter-item oro-drop']")
    public WebElement locationAllDropButton;

    @FindBy(xpath = "//*[@class='btn dropdown-toggle']")
    public WebElement dropDown;

    @FindBy(xpath = "(//*[@class='dropdown-item choice-value'])[1]")
    public WebElement containsMethod;

    @FindBy(xpath = "(//*[@class='dropdown-item choice-value'])[2]")
    public WebElement doesNotContainMethod;

    @FindBy(xpath = "(//*[@class='dropdown-item choice-value'])[3]")
    public WebElement isEqualToMethod;

    @FindBy(xpath = "(//*[@class='dropdown-item choice-value'])[4]")
    public WebElement startsWithMethod;

    @FindBy(xpath = "(//*[@class='dropdown-item choice-value'])[5]")
    public WebElement endsWithMethod;

    @FindBy(xpath = "(//*[@class='value-field-frame']/input)[1]")
    public WebElement inputBox;

    @FindBy(xpath = "//*[@class='btn btn-primary filter-update']")
    public WebElement updateButton;

    @FindBy(xpath = "//*[@class='no-data']/span")
    public WebElement NoEntitiesMessage;

    public void availableMethods(List<String> methods){
        int i = 1;
        for (String element : methods) {
            String methodXpath = "(//*[@class='dropdown-item choice-value'])["+i+"]";
            Assert.assertEquals(element, Driver.get().findElement(By.xpath(methodXpath)).getText());
            i++;
        }
    }

    public void containsMethodVerification(String keyword){
        for (int i = 1; i < 8; i++) {
            String resultPath = "((//*[@class='grid-body']/tr)["+i+"]/td)[4]";
            Assert.assertTrue(Driver.get().findElement(By.xpath(resultPath)).getText().toLowerCase().contains(keyword.toLowerCase()));
        }
    }

    public void setDoesNotContainMethod(String keyword){
        for (int i = 1; i < 8; i++) {
            String resultPath = "((//*[@class='grid-body']/tr)["+i+"]/td)[4]";
            Assert.assertFalse(Driver.get().findElement(By.xpath(resultPath)).getText().toLowerCase().contains(keyword.toLowerCase()));
        }
    }

    public void setStartsWithMethod(String keyword){
        for (int i = 1; i < 8; i++) {
            String resultPath = "((//*[@class='grid-body']/tr)["+i+"]/td)[4]";
            Assert.assertTrue(Driver.get().findElement(By.xpath(resultPath)).getText().toLowerCase().startsWith(keyword.toLowerCase()));
        }
    }

    public void setEndsWithMethod(String keyword){
            String resultPath = "((//*[@class='grid-body']/tr)[1]/td)[4]";
            Assert.assertTrue(Driver.get().findElement(By.xpath(resultPath)).getText().toLowerCase().endsWith(keyword.toLowerCase()));
    }

    public void setIsEqualToMethod(String keyword){
        String resultPath = "((//*[@class='grid-body']/tr)[1]/td)[4]";
        Assert.assertEquals(Driver.get().findElement(By.xpath(resultPath)).getText().toLowerCase(),keyword.toLowerCase());
    }

    public void setAllMethods(String locationMethod){
        LocationFilterPage locationFilterPage = new LocationFilterPage();
        switch (locationMethod) {
            case "Contains":
                locationFilterPage.locationAllDropButton.click();
                locationFilterPage.dropDown.click();
                locationFilterPage.containsMethod.click();
                break;
            case "Does Not Contain":
                locationFilterPage.locationAllDropButton.click();
                locationFilterPage.dropDown.click();
                locationFilterPage.doesNotContainMethod.click();
                break;
            case "Starts With":
                locationFilterPage.locationAllDropButton.click();
                locationFilterPage.dropDown.click();
                locationFilterPage.startsWithMethod.click();
                break;
            case "Ends With":
                locationFilterPage.locationAllDropButton.click();
                locationFilterPage.dropDown.click();
                locationFilterPage.endsWithMethod.click();
                break;
            case "Is Equal To":
                locationFilterPage.locationAllDropButton.click();
                locationFilterPage.dropDown.click();
                locationFilterPage.isEqualToMethod.click();
                break;
        }
    }

    public void specialCharVerification(String locationMethod){
        LocationFilterPage locationFilterPage = new LocationFilterPage();
        String expectedMessage = "No entities were found to match your search. Try modifying your search criteria...";
        if(locationMethod != "Does Not Contain"){
            Assert.assertTrue(false);
        }else {
            Assert.assertFalse(locationFilterPage.NoEntitiesMessage.getText().equals(expectedMessage));
        }



    }
}
