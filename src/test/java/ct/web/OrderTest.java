package ct.web;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.HomeSteps;
import steps.LoginSteps;
import steps.OrderDetailsSteps;
import steps.OrderModuleSteps;

@DisplayName("Order test")
public class OrderTest extends BaseTest {

    LoginSteps loginSteps = new LoginSteps();
    HomeSteps homeSteps = new HomeSteps();
    OrderModuleSteps orderModuleSteps = new OrderModuleSteps();
    OrderDetailsSteps orderDetailsSteps = new OrderDetailsSteps();

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
        orderModuleSteps.verifyThatRelatedListsHaveCountsOfAddedItems();
    }
}
