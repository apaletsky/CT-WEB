package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement USERNAME = $("#username");
    private final SelenideElement PASSWORD = $("#password");
    private final SelenideElement LOGINBUTTON = $("#Login");

public void loginWithValidCredentials(){
    $(USERNAME).sendKeys("test-za6bqfkrq3wa@example.com");
    $(PASSWORD).sendKeys("Enter123");
    $(LOGINBUTTON).click();
}







}
