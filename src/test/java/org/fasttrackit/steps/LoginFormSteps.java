package org.fasttrackit.steps;

import org.fasttrackit.DriverFactory;
import org.fasttrackit.webviews.LoginFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginFormSteps {

    public void goToLoginPage() {
        DriverFactory.getDriver().findElement(By.linkText("ACCOUNT")).click();
        DriverFactory.getDriver().findElement(By.linkText("Log In")).click();
        System.out.println("Navigated to Login page");
    }

    public void fillOutTheLoginPage(String email, String password)
    {
        LoginFormPage loginFormPage = PageFactory.initElements(DriverFactory.getDriver(), LoginFormPage.class);

        loginFormPage.getEmailField().sendKeys(email);
        loginFormPage.getPasswordField().sendKeys(password);
        System.out.println("Performed actions on given fields");
        loginFormPage.getLoginButton().click();
        System.out.println("Clicked the Login button");
    }

}
