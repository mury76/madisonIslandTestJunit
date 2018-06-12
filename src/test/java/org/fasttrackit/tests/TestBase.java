package org.fasttrackit.tests;

import org.fasttrackit.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

public class TestBase {

    @Before
    public void setup() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://fasttrackit.org/selenium-test/");
        DriverFactory.getDriver().findElement(By.linkText("ACCOUNT")).click();
        DriverFactory.getDriver().findElement(By.linkText("Register")).click();
    }

    @After
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
