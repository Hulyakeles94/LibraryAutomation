package com.library.pages;

import com.library.utilities.ui.ConfigurationReader;
import com.library.utilities.ui.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement inputBox;
    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signBtn;

    public void login(){
        inputBox.sendKeys(ConfigurationReader.getProperty("librarian_username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        signBtn.click();
    }
}
