package steps;

import io.qameta.allure.Step;
import pageobjects.LoginPage;

public class LoginSteps {

    LoginPage loginButton = new LoginPage();

    @Step("Login with valid credentials")
    public void loginWithValidCredentials() {
        loginButton.loginWithValidCredentials();
    }
}
