package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pageobjects.LoginPage;

public class LoginSteps {

    LoginPage loginButton = new LoginPage();

    @Step("Login with valid credentials")
    public void loginWithValidCredentials() {
        loginButton.loginWithValidCredentials();
        Selenide.sleep(5000);
    }
}
