package pageobjects;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class HomePage {

    public final SelenideElement HOMEPAGE = $("#setupComponent");
    public final SelenideElement APPLAUNCHER = $x("//div[contains(@class, 'slds-icon-waffle')]");
    public final SelenideElement APPLAUNCHERSERCH = $x("//*[@class='slds-input']");

    public boolean verifyThatHomepageIsDisplayed() {
        HOMEPAGE.should(appear, Duration.ofSeconds(3000));
        return HOMEPAGE.isDisplayed();
    }

    public void openApplication(String appName) {
        APPLAUNCHER.click();
        APPLAUNCHERSERCH.sendKeys(appName);
        String fullLocator = format((("//*[text()='%s']")), appName);
        $x(fullLocator).click();
    }
}
