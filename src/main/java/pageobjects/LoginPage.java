package pageobjects;

import com.codeborne.selenide.SelenideElement;
import dto.CredentionalDTO;
import static dto.MapperDTO.credentionalDTO;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    CredentionalDTO credentionalDTO = credentionalDTO();

    private final SelenideElement USERNAME = $("#username");
    private final SelenideElement PASSWORD = $("#password");
    private final SelenideElement LOGINBUTTON = $("#Login");

public void loginWithValidCredentials(){
    $(USERNAME).sendKeys(credentionalDTO.getUsername());
    $(PASSWORD).sendKeys(credentionalDTO.getPassword());
    $(LOGINBUTTON).click();
}







}
