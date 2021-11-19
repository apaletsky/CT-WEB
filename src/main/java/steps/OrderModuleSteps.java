package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pageobjects.OrderModulePage;

public class OrderModuleSteps {

    OrderModulePage orderModulePage = new OrderModulePage();

    @Step("Verify that order module page is displayed")
    public void verifyThatOrderModulePageIsDisplayed() {
        Assertions.assertTrue(orderModulePage.verifyThatOrderModulePageIsDisplayed());
    }

    @Step("Click new button")
    public void clickNewButton() {
        orderModulePage.clickNewButton();
    }

    @Step("Click edit cart button")
    public void clickEditCartButton() {
        orderModulePage.clickEditCartButton();
    }

    @Step("Click orders tab")
    public void goToOrdersTab() {
        orderModulePage.openCtOrdersTab();
    }

    @Step("Verify that New CT Order view is displayed")
    public void verifyThatNewOrderViewIsDisplayed() {
        Assertions.assertTrue(orderModulePage.verifyThatNewOrderViewIsDisplayed());
    }

    @Step("Fill order view")
    public void fillNewOrderView() {
        orderModulePage.fillNewOrderView();
    }

    @Step("Verify that order was created successfully")
    public void verifyThatToastMessageIsDisplayed() {
        Assertions.assertTrue(orderModulePage.verifyThatToastMessageIsDisplayed());
    }
}
