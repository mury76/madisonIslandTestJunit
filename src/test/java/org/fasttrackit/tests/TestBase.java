package org.fasttrackit.tests;

import org.fasttrackit.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

public class TestBase {

    @Before
    public void setup() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
