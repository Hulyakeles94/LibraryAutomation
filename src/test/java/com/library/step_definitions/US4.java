package com.library.step_definitions;

import com.library.utilities.db.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US4 {
    String query="SELECT u.full_name, count(*) as countofreadbooks\n" +
            "from users u inner join book_borrow bb on u.id = bb.user_id\n" +
            "group by full_name\n" +
            "order by 2 DESC";


    @When("I execute a query to find the most popular user")
    public void i_execute_a_query_to_find_the_most_popular_user() {
        DB_Util.runQuery(query);
    }
    @Then("verify {string} is the user who reads the most")
    public void verify_is_the_user_who_reads_the_most(String string) {
        String actual = DB_Util.getCellValue(1, 1);
        Assert.assertEquals(actual,string);
    }
}
