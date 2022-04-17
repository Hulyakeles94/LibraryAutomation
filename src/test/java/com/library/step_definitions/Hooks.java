package com.library.step_definitions;

import com.library.runners.utilities.Driver;
import com.library.utilities.db.DB_Util;
import com.library.utilities.ui.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before (value = "@ui")
    public void setupScenarioForLogins(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }



    @Before(value = "@db", order = 0)
    public void setupForDatabaseScenarios(){
        DB_Util.createConnection(ConfigurationReader.getProperty("connectionString"),
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));
    }
    @After(value = "@db")
    public void tearDownnForDatabaseScenarios(){
        DB_Util.destroy();
    }

    @After
    public void tearDownn(Scenario scenario){

        if (scenario.isFailed()){
            WebDriver driver = Driver.getDriver();
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
