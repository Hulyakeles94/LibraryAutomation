package com.library.step_definitions;

import com.library.utilities.db.DB_Util;
import com.library.utilities.ui.ConfigurationReader;
import com.library.utilities.ui.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before (value = "@ui")
    public void setupScenarioForLogins(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Before(value = "@db")
    public void setupForDatabaseScenarios(){
        DB_Util.createConnection();
    }
    @After(value = "@db")
    public void tearDownnForDatabaseScenarios(){
        DB_Util.destroy();
    }

    @After(value = "@ui")
    public void tearDownn(Scenario scenario){

        if (scenario.isFailed()){
            WebDriver driver = Driver.getDriver();
            final byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
