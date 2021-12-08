package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DriverFiltersPage extends BasePage {
    @FindBy(xpath = "//label[@for='ui-multiselect-0-0-option-2']/..")
    public WebElement driverFilterOption;

    @FindBy(css = "div.filter-item > div.btn.filter-criteria-selector.oro-drop-opener.filter-default-value")
    public WebElement driverFilterTab;

    @FindBy(css = "div.choice-filter button.dropdown-toggle")
    public WebElement choiceFilter;

    @FindBy(css = "div.choice-filter input[type=\"text\"]")
    public WebElement searchInput;

    @FindBy(css = "div.choice-filter button.filter-update")
    public WebElement filterUpdateButton;

    @FindBy(css = "i.fa-filter.hide-text")
    public WebElement filterIcon;

    public void filterIconClick() {
        if (!Driver.get().findElement(By.xpath("//a//i[@class='fa-filter hide-text']/..")).getAttribute("class").contains("pressed")) {
            filterIcon.click();
        }
    }

    public void selectDriverFilterOption() {
        driverFilterOption.click();
    }

    public void checkFilterSelected() {
        BrowserUtils.verifyElementDisplayed(driverFilterTab);
    }

    public boolean verifyOptions(List<String> options) {
        boolean result = true;
        for (int i = 1; i <= options.size(); i++) {
            result = options.contains(getOption(i, null).getText());
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public WebElement getOption(int index, String text) {
        if (text != null) {
            return Driver.get().findElement(By.xpath("//div[@class='choice-filter']//li/a[.='" + text.toLowerCase() + "']"));
        }
        return Driver.get().findElement(By.xpath("//div[@class='choice-filter']//li[" + index + "]/a"));
    }

    public List<String> getTdText() {
        int rowCount = Driver.get().findElements(By.xpath("//tbody//tr")).size();
        List<String> trowsText = new ArrayList<>();
        for (int i = 1; i <= rowCount; i++) {
            trowsText.add(Driver.get().findElement(By.xpath("//tbody//tr[" + i + "]//td[4]")).getText().toLowerCase());
        }
        return trowsText;
    }

    public boolean verifyTextList(String expected, String keyWord) {
        switch (expected) {
            case "contains":
                return verifyContains(keyWord);
            case "notContains":
                return verifyNotContains(keyWord);
            case "startsWith":
                return verifyStartsWith(keyWord);
            case "endsWith":
                return verifyEndsWith(keyWord);
            case "equals":
                return verifyEquals(keyWord);
            default:
                return true;
        }
    }

    public boolean verifyContains(String keyWord) {
        boolean result = true;
        for (String s : getTdText()) {
            System.out.println("s = " + s);
            result = s.contains(keyWord);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyNotContains(String keyWord) {
        boolean result = true;
        for (String s : getTdText()) {
            result = !s.contains(keyWord);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyStartsWith(String keyWord) {
        boolean result = true;
        for (String s : getTdText()) {
            result = s.startsWith(keyWord);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyEndsWith(String keyWord) {
        boolean result = true;
        for (String s : getTdText()) {
            result = s.endsWith(keyWord);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyEquals(String keyWord) {
        boolean result = true;
        for (String s : getTdText()) {
            result = s.equals(keyWord);
            if (!result) {
                return false;
            }
        }
        return true;
    }
}
