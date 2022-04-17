package com.library.step_definitions;

import com.library.utilities.db.DB_Util;
import com.library.utilities.ui.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.lang.module.Configuration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class US1 {

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("SELECT ID FROM users");
    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        List<String> UserId = DB_Util.getColumnDataAsList("ID");
        Set<String> removeDuplicatedUserId=new LinkedHashSet<>(UserId);
        //When we minus the size and if the result is 0, means all ID's are unique
        Assert.assertTrue((UserId.size()-removeDuplicatedUserId.size())==0);
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users");
    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedColumnsName) {
        List<String> actualColumnsName = DB_Util.getAllColumnNamesAsList();
        Assert.assertEquals(actualColumnsName,expectedColumnsName,"Column names NOT matching");
    }
}