package org.fasttrackit.tests;

import org.fasttrackit.DriverFactory;
import org.fasttrackit.steps.LoginFormSteps;
import org.fasttrackit.steps.RegisterFormSteps;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterTest extends TestBase {

    String email = "mail" + System.currentTimeMillis() + "@mail.com";

    @Test
    public void tryregisterWithValidData () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = email;
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement successMsgContainer = DriverFactory.getDriver().findElement(By.className("success-msg"));
        assertThat("Success message not displayed", successMsgContainer.isDisplayed());
    }

    @Test
    public void tryregisterWithDuplicatedEmail () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = email;
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFirstTime = new RegisterFormSteps();
        registerFirstTime.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement successMsgContainer = DriverFactory.getDriver().findElement(By.className("success-msg"));
        assertThat("Success message not displayed", successMsgContainer.isDisplayed());

        DriverFactory.getDriver().quit();

        DriverFactory.initDriver();
        goToRegister.goToRegisterPage();

        RegisterFormSteps registerSecondTime = new RegisterFormSteps();
        registerSecondTime.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.className("error-msg"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
    }

    @Test
    public void tryToRegisterWithoutFillingFirstNameField () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = "mail@mail.com";
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.id("advice-required-entry-firstname"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
    }

    @Test
    public void tryToRegisterWithoutFillingLastNameField () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "";
        String emailAddress = "mail@mail.com";
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.id("advice-required-entry-lastname"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
    }

    @Test
    public void tryToRegisterWithoutFillingEmailField () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = "";
        String password = "123456";
        String confirmation = "123456";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.id("advice-required-entry-email_address"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
    }

    @Test
    public void tryToRegisterWithoutFillingPasswordField () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = "mai@mail.com";
        String password = "";
        String confirmation = "123456";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.id("advice-required-entry-password"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
    }

    @Test
    public void tryToRegisterWithoutFillingConfirmPasswordField () {
        RegisterFormSteps goToRegister = new RegisterFormSteps();
        goToRegister.goToRegisterPage();

        String firsName = "Ciprian";
        String middleName = "Augustin";
        String lastName = "Muresan";
        String emailAddress = "mai@mail.com";
        String password = "123456";
        String confirmation = "";

        RegisterFormSteps registerFormSteps = new RegisterFormSteps();
        registerFormSteps.fillOutTheRegisterForm(firsName, middleName, lastName, emailAddress, password, confirmation);

        WebElement errorMsgContainer = DriverFactory.getDriver().findElement(By.id("advice-required-entry-confirmation"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
    }

}
