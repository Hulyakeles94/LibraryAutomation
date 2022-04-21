package com.library.step_definitions;

import com.library.pages.BasePage;
import com.library.pages.LoginPage;
import com.library.utilities.db.DB_Util;
import com.library.utilities.ui.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2 {
    LoginPage loginPage=new LoginPage();
    BasePage basePage=new BasePage();
    String UiBorrowedBooks;
    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {
        loginPage.login();
        BrowserUtils.waitFor(2);
    }
    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
        UiBorrowedBooks = basePage.borrowedBooks.getText();
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");
        String DbBorrowedBooks = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(UiBorrowedBooks,DbBorrowedBooks);
    }

}
