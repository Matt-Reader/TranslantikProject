package com.translantik.pages;

import com.translantik.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(className = "btn extra-submit btn-uppercase btn-primary")
    public WebElement request;

    @FindBy(css = "a[href='/user/login']")
    public WebElement returnToLogin;

    public void forgotPassword(String userNameStr) {
        userName.sendKeys(userNameStr);
        request.click();
    }
}
