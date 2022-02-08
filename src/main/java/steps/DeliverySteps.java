package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pageobjects.DeliveryPage;

public class DeliverySteps {
    DeliveryPage deliveryPage = new DeliveryPage();

    @Step ("Verify that related list DLI is displayed")
    public void verifyThatRelatedListsDLILoaded (int sizeOfDLI) {
        Assertions.assertTrue(deliveryPage.verifyThatRelatedListsDLILoaded(sizeOfDLI));
    }

    @Step
    public void verifyThatDLIsHaveProductsQuantity() {
        Assertions.assertTrue(deliveryPage.verifyThatDLIsHaveProductsQuantity());
    }

    @Step
    public void clickOrderRecord(){
        deliveryPage.clickDeliveryRecord();
    }
}
