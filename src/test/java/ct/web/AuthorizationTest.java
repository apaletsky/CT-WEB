package ct.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.HomeSteps;
import steps.LoginSteps;
import steps.OrderModuleSteps;

@DisplayName("Авторизация")
public class AuthorizationTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    HomeSteps homeSteps = new HomeSteps();
    OrderModuleSteps orderModuleSteps = new OrderModuleSteps();

    @Story("C52998 Авторизация и вход в Order Module")
    @Description("C52998 Авторизация и вход в Order Module")
    @DisplayName("Авторизация и вход в Order Module")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @TmsLink("C52998")
    public void authorizationWithValidCredentials() {
        loginSteps.loginWithValidCredentials();
        homeSteps.verifyThatHomepageIsDisplayed();
        homeSteps.openApplication("Order M");
        orderModuleSteps.verifyThatOrderModulePageIsDisplayed();
    }
}
