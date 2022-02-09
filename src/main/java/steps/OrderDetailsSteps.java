package steps;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import pageobjects.OrderDetailsPage;


public class OrderDetailsSteps {

    OrderDetailsPage orderDetailsPage = new OrderDetailsPage();

    @Step("Verify order details page elements is displayed")
    public void verifyThatOrderDetailsElementsIsDisplayed() {
        SoftAssertions.assertSoftly(a -> {
            a.assertThat(orderDetailsPage.verifyThatOrderDetailsIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatSearchFieldIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatButtonsPanelIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatCatalogTabIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatPromotionalTabIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatArrowIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatSelectTextIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatAddButtonIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatTotalPriceIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatTotalDiscountIsDisplayed())
                    .isTrue();
        });
    }

    @Step("Click \"All Accounts. SPOONABLE YOGHURTS\" line")
    public void clickOrderProductHierarchy(){
        orderDetailsPage.clickOrderProductHierarchy();
    }

    @Step("Check that catalog Danissimo Displayed")
    public void verifyThatCatalogDanissimoIsDisplayed(){
        Assertions.assertTrue(orderDetailsPage.verifyThatCatalogDanissimoIsDisplayed());
    }

    @Step("Click on Danissimo Catalog")
    public void clickCatalogDanissimo(){
        orderDetailsPage.clickCatalogDanissimo();
    }

    @Step("Check that under Danissimo exist Catalog #105")
    public void verifyThatCatalogDanissimo105IsDisplayed(){
        Assertions.assertTrue(orderDetailsPage.verifyThatCatalogDanissimo105IsDisplayed());
    }

    @Step("Click on Catalog #105")
    public void clickCatalogDanissimo105(){
        orderDetailsPage.clickCatalogDanissimo105();
    }

    @Step("Check that under Catalog #105 exist Products")
    public void verifyThatProductsInCatalogDanissimo105IsDisplayed(){
        Assertions.assertTrue(orderDetailsPage.verifyThatProductsInCatalogDanissimo105IsDisplayed());
    }

    @Step("Add 4 Products to the Cart")
    public void addProductsFromCatalogDanissimo105(){
        orderDetailsPage.addProductsFromCatalogDanissimo105();
    }

    @Step("Check that 4-th product has yellow Background Color")
    public void verifyProd4BackgroundColorisYellow(){
        Assertions.assertTrue(orderDetailsPage.verifyProd4BackgroundColorisYellow());
    }

    @Step("Verify that after adding 4 products Add Button contain number of added products \"4\"")
    public void verifyThatAddButtonContainNumberOfAddedProduct(){
        Assertions.assertTrue(orderDetailsPage.getAddButtonText().contains("4"));
    }

    @Step("Click Add Button")
    public void clickAddButton(){
        orderDetailsPage.clickAddButton();
    }

    @Step("Verify that Address field is auto-populated with any address")
    public void verifyThatAddressPopulated(){
        Assertions.assertTrue(orderDetailsPage.verifyThatAddressPopulated());
    }

    @Step("Verify that Date field is auto-populated as Today")
    public void verifyThatDatePopulatedAsToday(){
        Assertions.assertTrue(orderDetailsPage.verifyThatDatePopulatedAsToday());
    }

    @Step("Click Ok button")
    public void clickOkButton(){
        orderDetailsPage.clickButtonOK();
    }

    @Step("Verify that on Order Page added selected products with quantity = 0 and Address and Date from previous steps")
    public void verifyThatOrderViewGetData(){
        SoftAssertions.assertSoftly(a->{
            a.assertThat(orderDetailsPage.verifyThatProductNameIsDisplayed())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatDeliveryAddressIsDisplayedAndCorrect())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatDateIsDisplayedAndCorrect())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatProductsAreAdded())
                    .isTrue();
            a.assertThat(orderDetailsPage.verifyThatQuantityOfAddedProductsIsZero())
                    .isTrue();
        });
    }

    @Step
    public void setQuantityValuesForAddedProducts(){
        orderDetailsPage.setQuantityValuesForAddedProducts();
    }

    @Step
    public void verifyThatQuantityOfAddedProductsIsChanged(){
        Assertions.assertTrue(orderDetailsPage.verifyThatQuantityOfAddedProductsIsChanged());
    }

    @Step
    public void clickSafeDraftButton(){
        orderDetailsPage.clickSafeDraftButton();
    }

    @Step
    public void clickExitButton(){
        orderDetailsPage.clickExitButton();
    }

    @Step
    public void verifyThatPopUpForVerificationIsDisplayed(){
        Assertions.assertTrue(orderDetailsPage.verifyThatPopUpForVerificationIsDisplayed());
    }

    @Step
    public void clickOkButtonOnVerificationPopUp(){
        orderDetailsPage.clickOkButtonOnVerificationPopUp();
    }
}
