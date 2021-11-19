package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pageobjects.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Step("Verify that homepage is displayed")
    public void verifyThatHomepageIsDisplayed() {
        Assertions.assertTrue(homePage.verifyThatHomepageIsDisplayed());
    }

    @Step("Open Salesforce application")
    public void openApplication(String applicationName) {
        homePage.openApplication(applicationName);
    }

}
