package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormPage {

        @FindBy(id = "email")
        private WebElement emailField;

        @FindBy(id = "pass")
        private WebElement passwordField;

        @FindBy(id = "send2")
        private WebElement loginButton;

        public WebElement getEmailField() {
            return emailField;
        }

        public WebElement getPasswordField() {
            return passwordField;
        }

        public WebElement getLoginButton() {
            return loginButton;
        }
}


