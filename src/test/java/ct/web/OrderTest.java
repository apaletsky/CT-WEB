package ct.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.DeliveryPage;
import steps.*;

@DisplayName("Order test")
public class OrderTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    HomeSteps homeSteps = new HomeSteps();
    OrderModuleSteps orderModuleSteps = new OrderModuleSteps();
    OrderDetailsSteps orderDetailsSteps = new OrderDetailsSteps();
    DeliverySteps deliverySteps = new DeliverySteps();

    @Story("C53000 Создание заказа")
    @Description("C53000 Создание заказа")
    @DisplayName("C53000 Создание заказа")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @TmsLink("C53000")
    public void createOrder() {
        loginSteps.loginWithValidCredentials();
        homeSteps.clickSwitchToLightning(); //
        homeSteps.verifyThatHomepageIsDisplayed();
        homeSteps.openApplication("Order M");
        orderModuleSteps.verifyThatOrderModulePageIsDisplayed();
        orderModuleSteps.goToOrdersTab();
        orderModuleSteps.clickNewButton();
        orderModuleSteps.verifyThatNewOrderViewIsDisplayed();
        orderModuleSteps.fillNewOrderView();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
    }

    @Story("C52999 Отображение элементов на странице формирования заказа (каталог, промо, кнопки, номер заказа и тд) ")
    @Description("C52999 Отображение элементов на странице формирования заказа (каталог, промо, кнопки, номер заказа и тд) ")
    @DisplayName("C52999 Отображение элементов на странице формирования заказа (каталог, промо, кнопки, номер заказа и тд)")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @TmsLink("C52999")
    public void verifyOrderView() {
        loginSteps.loginWithValidCredentials();
        homeSteps.clickSwitchToLightning();
        homeSteps.verifyThatHomepageIsDisplayed();
        homeSteps.openApplication("Order M");
        orderModuleSteps.verifyThatOrderModulePageIsDisplayed();
        orderModuleSteps.goToOrdersTab();
        orderModuleSteps.clickNewButton();
        orderModuleSteps.verifyThatNewOrderViewIsDisplayed();
        orderModuleSteps.fillNewOrderView();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
        orderModuleSteps.clickEditCartButton();
        orderDetailsSteps.verifyThatOrderDetailsElementsIsDisplayed();
    }

    @Story("C53575 Добавление в заказ продуктов и первой доставки -проверка создания записей OLI и DLI")
    @Description("C53575 Добавление в заказ продуктов и первой доставки -проверка создания записей OLI и DLI")
    @DisplayName("C53575 Добавление в заказ продуктов и первой доставки -проверка создания записей OLI и DLI")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @TmsLink("https://ctm.testrail.io/index.php?/cases/view/53575&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=6518")
    public void verifyProductAndDeliveryAdditionWithOLIAndDLICreation(){
        loginSteps.loginWithValidCredentials();
        homeSteps.clickSwitchToLightning();
        homeSteps.verifyThatHomepageIsDisplayed();
        homeSteps.openApplication("Order M");
        orderModuleSteps.verifyThatOrderModulePageIsDisplayed();
        orderModuleSteps.goToOrdersTab();
        orderModuleSteps.clickNewButton();
        orderModuleSteps.verifyThatNewOrderViewIsDisplayed();
        orderModuleSteps.fillNewOrderView();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
        orderModuleSteps.clickEditCartButton();
        orderDetailsSteps.verifyThatOrderDetailsElementsIsDisplayed();
        orderDetailsSteps.clickOrderProductHierarchy();
        orderDetailsSteps.verifyThatCatalogDanissimoIsDisplayed();
        orderDetailsSteps.clickCatalogDanissimo();
        orderDetailsSteps.verifyThatCatalogDanissimo105IsDisplayed();
        orderDetailsSteps.clickCatalogDanissimo105();
        orderDetailsSteps.verifyThatProductsInCatalogDanissimo105IsDisplayed();
        orderDetailsSteps.addProductsFromCatalogDanissimo105();
        orderDetailsSteps.verifyProd4BackgroundColorisYellow();
        orderDetailsSteps.verifyThatAddButtonContainNumberOfAddedProduct();
        orderDetailsSteps.clickAddButton();
        orderDetailsSteps.verifyThatAddressPopulated();
        orderDetailsSteps.verifyThatDatePopulatedAsToday();
        orderDetailsSteps.clickOkButton();
        orderDetailsSteps.verifyThatOrderViewGetData();
        orderDetailsSteps.setQuantityValuesForAddedProducts();
        orderDetailsSteps.verifyThatQuantityOfAddedProductsIsChanged();
        orderDetailsSteps.clickSafeDraftButton();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
        orderDetailsSteps.clickExitButton();
        orderDetailsSteps.verifyThatPopUpForVerificationIsDisplayed();
        orderDetailsSteps.clickOkButtonOnVerificationPopUp();
        orderModuleSteps.verifyThatStageFieldIsOnHold();
        orderModuleSteps.verifyThatRelatedListsHaveCountsOfAddedItems(4,1);
    }

    @Story("C56460 Удаление продукта из заказа")
    @Description("C56460 Удаление продукта из заказа")
    @DisplayName("C56460 Удаление продукта из заказа")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @TmsLink("https://ctm.testrail.io/index.php?/cases/view/56460&group_by=cases:section_id&group_id=6518&group_order=asc&display_deleted_cases=0")
    public void deletionProductsFromAnOrder () {
        loginSteps.loginWithValidCredentials();
        homeSteps.clickSwitchToLightning();
        homeSteps.verifyThatHomepageIsDisplayed();
        homeSteps.openApplication("Order M");
        orderModuleSteps.verifyThatOrderModulePageIsDisplayed();
        orderModuleSteps.goToOrdersTab();
        orderModuleSteps.clickNewButton();
        orderModuleSteps.verifyThatNewOrderViewIsDisplayed();
        orderModuleSteps.fillNewOrderView();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
        orderModuleSteps.clickEditCartButton();
        orderDetailsSteps.verifyThatOrderDetailsElementsIsDisplayed();
        orderDetailsSteps.clickOrderProductHierarchy();
        orderDetailsSteps.verifyThatCatalogDanissimoIsDisplayed();
        orderDetailsSteps.clickCatalogDanissimo();
        orderDetailsSteps.verifyThatCatalogDanissimo105IsDisplayed();
        orderDetailsSteps.clickCatalogDanissimo105();
        orderDetailsSteps.verifyThatProductsInCatalogDanissimo105IsDisplayed();
        orderDetailsSteps.addProductsFromCatalogDanissimo105();
        orderDetailsSteps.verifyProd4BackgroundColorisYellow();
        orderDetailsSteps.verifyThatAddButtonContainNumberOfAddedProduct();
        orderDetailsSteps.clickAddButton();
        orderDetailsSteps.verifyThatAddressPopulated();
        orderDetailsSteps.verifyThatDatePopulatedAsToday();
        orderDetailsSteps.clickOkButton();
        orderDetailsSteps.verifyThatOrderViewGetData();
        orderDetailsSteps.setQuantityValuesForAddedProducts();
        orderDetailsSteps.verifyThatQuantityOfAddedProductsIsChanged();
        orderDetailsSteps.clickSafeDraftButton();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
        orderDetailsSteps.clickExitButton();
        orderDetailsSteps.verifyThatPopUpForVerificationIsDisplayed();
        orderDetailsSteps.clickOkButtonOnVerificationPopUp();
        orderModuleSteps.verifyThatStageFieldIsOnHold();
        orderModuleSteps.verifyThatRelatedListsHaveCountsOfAddedItems(4,1);
        orderModuleSteps.clickDeliveryRecord();
        deliverySteps.verifyThatRelatedListsDLILoaded(4);
        deliverySteps.verifyThatDLIsHaveProductsQuantity();
        deliverySteps.clickOrderRecord();
        orderModuleSteps.clickEditCartButton();
        orderDetailsSteps.verifyThatOrderDetailsElementsIsDisplayed();
        orderDetailsSteps.deleteLastProduct();
        orderDetailsSteps.clickSafeDraftButton();
        orderModuleSteps.verifyThatToastMessageIsDisplayed();
        orderDetailsSteps.clickExitButton();
        orderDetailsSteps.verifyThatPopUpForVerificationIsDisplayed();
        orderDetailsSteps.clickOkButtonOnVerificationPopUp();
        orderModuleSteps.verifyThatStageFieldIsOnHold();
        orderModuleSteps.verifyThatRelatedListsHaveCountsOfAddedItems(3,1);
        orderModuleSteps.clickDeliveryRecord();
        deliverySteps.verifyThatRelatedListsDLILoaded(3);
    }
}
