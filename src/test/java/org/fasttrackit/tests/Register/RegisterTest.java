package org.fasttrackit.tests.Register;

import org.fasttrackit.DriverFactory;
import org.fasttrackit.steps.RegisterFormSteps;
import org.fasttrackit.tests.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterTest extends TestBase {

    String email = "mail" + System.currentTimeMillis() + "@mail.com";

    @Test
    public void registerWithValidData () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = email;
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement successMsgContainer = DriverFactory.getDriver().findElement(By.className("success-msg"));
        assertThat("Success message not displayed", successMsgContainer.isDisplayed());
    }

    @Test
    public void registerWithDuplicatedEmail () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = email;
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFirstTime = new RegisterFormSteps();
        registerFirstTime.fillOutTheForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement successMsgContainer = DriverFactory.getDriver().findElement(By.className("success-msg"));
        assertThat("Success message not displayed", successMsgContainer.isDisplayed());

        DriverFactory.getDriver().quit();

        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://fasttrackit.org/selenium-test/");
        goToRegister.goToRegisterPage();

        RegisterFormSteps registerSecondTime = new RegisterFormSteps();
        registerSecondTime.fillOutTheForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.className("error-msg"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());


    }


}
