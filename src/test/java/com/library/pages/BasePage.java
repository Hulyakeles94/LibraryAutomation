package com.library.pages;

import com.library.runners.utilities.BrowserUtils;
import com.library.runners.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="borrowed_books")
    public WebElement borrowedBooks;


    public void NavigateSubModule(String moduleName){
        String locator = "//span[.='"+moduleName+"']/..";
        Driver.getDriver().findElement(By.xpath(locator)).click();
        BrowserUtils.waitFor(2);
    }
}
