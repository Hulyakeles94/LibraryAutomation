package com.library.step_definitions;

import com.library.pages.BasePage;
import com.library.pages.BooksPage;
import com.library.pages.LoginPage;
import com.library.utilities.db.DB_Util;
import com.library.utilities.ui.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.ArrayList;
import java.util.List;

public class US5 {

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        new LoginPage().login();
        BrowserUtils.waitForPageToLoad(2);
    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
        new BasePage().NavigateSubModule(string);
    }
    @When("I open book {string}")
    public void i_open_book(String bookName) {
        new BooksPage().searchBtn.sendKeys(bookName+ Keys.ENTER);
        BrowserUtils.waitFor(2);
    }
    @Then("book information must match the Database for {string}")
    public void book_information_must_match_the_database(String bookName) {
        String query="select name,author,year from books\n" +
                "where name='"+bookName+"'";
        DB_Util.runQuery(query);
        List<String> actualInfo=new ArrayList<>();

        actualInfo.add(new BooksPage().bookName.getText());
        actualInfo.add(new BooksPage().author.getText());
        actualInfo.add(new BooksPage().year.getText());

        List<String> expectedInfo = DB_Util.getRowDataAsList(1);

        Assert.assertEquals(actualInfo,expectedInfo);

    }
}
