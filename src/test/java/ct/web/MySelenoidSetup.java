package ct.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MySelenoidSetup implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "90.0");
        capabilities.setCapability("browserSize", "1366x768");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://localhost:4444/wd/hub"; // Selenoid config
        //Configuration.remote = "http://34.122.208.8:4444/wd/hub"; // Moon config

    }
}
