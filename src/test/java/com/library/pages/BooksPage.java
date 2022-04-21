package com.library.pages;

import com.library.utilities.ui.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//input[@type='search']")
    public WebElement searchBtn;

    @FindBy(xpath="(//tr[@role='row'])[2]//td[3]")
    public WebElement bookName;

    @FindBy(xpath="(//tr[@role='row'])[2]//td[4]")
    public WebElement author;

    @FindBy(xpath="(//tr[@role='row'])[2]//td[6]")
    public WebElement year;
}
