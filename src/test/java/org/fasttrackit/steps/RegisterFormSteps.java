package org.fasttrackit.steps;

import org.fasttrackit.DriverFactory;
import org.fasttrackit.webviews.RegisterFormPage;
import org.openqa.selenium.support.PageFactory;

public class RegisterFormSteps {

public void fillOutTheForm (String firstName, String middleName, String lastName, String emailAddress, String password,
                            String confirmation)
{
    RegisterFormPage registerFormPage = PageFactory.initElements(DriverFactory.getDriver(), RegisterFormPage.class);

    registerFormPage.getFirstNameField().sendKeys(firstName);
    registerFormPage.getMiddleNameField().sendKeys(middleName);
    registerFormPage.getLastNameField().sendKeys(lastName);
    registerFormPage.getEmailAddressField().sendKeys(emailAddress);
    registerFormPage.getPasswordField().sendKeys(password);
    registerFormPage.getConfirmationField().sendKeys(confirmation);
    registerFormPage.getSubscribeCheckButton().click();
    registerFormPage.getRegisterButton().click();

}

}
