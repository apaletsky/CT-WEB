package ct.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import dto.CredentionalDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static dto.MapperDTO.credentionalDTO;

public class BaseTest {
    CredentionalDTO credentionalDTO = credentionalDTO();

    @BeforeEach
    void setUp() {
        Selenide.open(credentionalDTO.getOrgLink());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    void closeUp() {
        Selenide.closeWindow();
    }
}
