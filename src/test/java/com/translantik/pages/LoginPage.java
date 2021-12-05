package com.translantik.pages;

import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import com.translantik.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement loginBTN;

    @FindBy(id = "remember_me")
    public WebElement rememberMeCheckBox;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginBTN.click();
        // verification that we logged
    }

    public void LoginAsUserTypes(String userType){

        if(userType.equalsIgnoreCase("driver")){
            userName.sendKeys(ConfigurationReader.get("driver_username"));
            password.sendKeys(ConfigurationReader.get("driver_password"));
        } else if (userType.equalsIgnoreCase("salesmanager")){
            userName.sendKeys(ConfigurationReader.get("salesmanager_username"));
            password.sendKeys(ConfigurationReader.get("salesmanager_password"));
        } else if (userType.equalsIgnoreCase("storemanager")) {
            userName.sendKeys(ConfigurationReader.get("storemanager_username"));
            password.sendKeys(ConfigurationReader.get("storemanager_password"));
        }

        loginBTN.click();
    }


}
