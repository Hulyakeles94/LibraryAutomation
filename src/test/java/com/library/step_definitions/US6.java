package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.utilities.db.DB_Util;
import com.library.utilities.ui.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class US6 {
    BooksPage booksPage = new BooksPage();
    List<String> actualBookCategories;
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        WebElement bookCategoryDropdown = booksPage.bookCategoryDropdown;
        actualBookCategories = BrowserUtils.getAllSelectOptions(bookCategoryDropdown);
        actualBookCategories.remove(0);
    }
    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Util.runQuery("SELECT name\n" +
                "FROM book_categories");
    }
    @Then("verify book categories must match the book_categories table from DB.")
    public void verify_book_categories_must_match_the_book_categories_table_from_db() {
        List<String> expectedBookCategories = DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(actualBookCategories, expectedBookCategories);
    }
}
