package org.fasttrackit.steps;

import org.fasttrackit.DriverFactory;
import org.fasttrackit.webviews.LoginFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginFormSteps {

    public void goToLoginPage() {
        DriverFactory.getDriver().findElement(By.linkText("ACCOUNT")).click();
        DriverFactory.getDriver().findElement(By.linkText("Log In")).click();
    }

    public void fillOutTheLoginPage(String email, String password)
    {
        LoginFormPage loginFormPage = PageFactory.initElements(DriverFactory.getDriver(), LoginFormPage.class);

        loginFormPage.getEmailField().sendKeys(email);
        loginFormPage.getPasswordField().sendKeys(password);
        loginFormPage.getLoginButton().click();
    }

}
