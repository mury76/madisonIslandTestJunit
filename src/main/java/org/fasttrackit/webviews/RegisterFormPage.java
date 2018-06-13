package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterFormPage {

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "middlename")
    private WebElement middleNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailAddressField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmation")
    private WebElement confirmationField;

    @FindBy(name = "is_subscribed")
    private WebElement subscribeCheckButton;

    @FindBy(css = "button[title='Register']")
    private WebElement registerButton;



    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getMiddleNameField() {
        return middleNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmationField() {
        return confirmationField;
    }

    public WebElement getSubscribeCheckButton() {
        return subscribeCheckButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }
}
