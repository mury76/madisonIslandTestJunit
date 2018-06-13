package org.fasttrackit.tests;

import org.fasttrackit.DriverFactory;
import org.fasttrackit.steps.LoginFormSteps;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends TestBase {

    @Test
    public void tryToLoginWithValidData () {
        LoginFormSteps goToLogin = new LoginFormSteps();
        goToLogin.goToLoginPage();

        String email = "mail@mail.com";
        String password = "123456";

        LoginFormSteps loginFormSteps = new LoginFormSteps();
        loginFormSteps.fillOutTheLoginPage(email, password);

        WebElement welcomeMsgContainer = DriverFactory.getDriver().findElement(By.className("welcome-msg"));
        assertThat("Welcome message not displayed", welcomeMsgContainer.isDisplayed());

    }

    @Test
    public void tryToLoginWithNonExistentAccount () {
        LoginFormSteps goToLogin = new LoginFormSteps();
        goToLogin.goToLoginPage();

        String email = TestUtils.getEmail();
        String password = "123456";

        LoginFormSteps loginFormSteps = new LoginFormSteps();
        loginFormSteps.fillOutTheLoginPage(email, password);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.className("error-msg"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());

    }

}
