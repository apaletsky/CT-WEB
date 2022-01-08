package ct.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void setUp() {
        Selenide.open("https://saas-drive-8735-dev-ed.lightning.force.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    void closeUp() {
        Selenide.closeWindow();
    }
}
