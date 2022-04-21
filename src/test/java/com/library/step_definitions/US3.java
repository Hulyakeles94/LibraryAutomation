package com.library.step_definitions;

import com.library.utilities.db.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US3 {
    String actualPopularCategory;
    String query = "SELECT book_categories.name, COUNT(*) AS countofbookcategories\n" +
            "FROM book_borrow\n" +
            "         INNER JOIN books\n" +
            "                    ON book_borrow.book_id = books.id\n" +
            "         INNER JOIN book_categories\n" +
            "                    ON books.book_category_id = book_categories.id\n" +
            "GROUP BY book_categories.name\n" +
            "ORDER BY countofbookcategories DESC";


    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery(query);
        actualPopularCategory = DB_Util.getCellValue(1,1);
    }
    @Then("verify that {string} is the most popular book genre.")
    public void verify_that_is_the_most_popular_book_genre(String string) {
        Assert.assertEquals(actualPopularCategory,string);
    }
}
