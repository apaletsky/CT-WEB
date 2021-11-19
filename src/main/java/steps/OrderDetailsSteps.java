package steps;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
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

}
