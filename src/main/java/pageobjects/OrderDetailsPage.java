package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;


public class OrderDetailsPage {

    private final SelenideElement ORDERDETAILS = $x("//*[@class='slds-media']");
    private final SelenideElement SEARCHFIELD = $x("//*[@name='search']");
    private final SelenideElement BUTTONSPANEL = $x("//*[@class='slds-page-header__col-actions slds-col']");
    private final SelenideElement CATALOGSTAB = $x("//a[@data-label='CATALOGS']");
    private final SelenideElement PROMOTIONTAB = $x("//a[@data-label='PROMOTION']");
    private final SelenideElement ARROW = $x("//*[@class='slds-icon-utility-left split-view-btn slds-icon_container']");
    private final SelenideElement SELECTPRODUCTTEXT = $x("//*[text()='Select and add a product from the left list']");
    private final SelenideElement ADDBUTTON = $x("//*[@title='Add']");
    private final SelenideElement TOTALPRICE = $x("//*[text()='Total Price:']");
    private final SelenideElement TOTALDISCOUNT = $x("//*[text()='Total Discount:']");

    public boolean verifyThatOrderDetailsIsDisplayed() {
        ORDERDETAILS.should(visible, Duration.ofSeconds(3000));
        return ORDERDETAILS.isDisplayed();
    }

    public boolean verifyThatSearchFieldIsDisplayed() {
        SEARCHFIELD.should(visible, Duration.ofSeconds(3000));
        return SEARCHFIELD.isDisplayed();
    }

    public boolean verifyThatButtonsPanelIsDisplayed() {
        return BUTTONSPANEL.isDisplayed();
    }

    public boolean verifyThatCatalogTabIsDisplayed() {
        return CATALOGSTAB.isDisplayed();
    }

    public boolean verifyThatPromotionalTabIsDisplayed() {
        return PROMOTIONTAB.isDisplayed();
    }

    public boolean verifyThatArrowIsDisplayed() {
        return ARROW.isDisplayed();
    }

    public boolean verifyThatSelectTextIsDisplayed() {
        return SELECTPRODUCTTEXT.isDisplayed();
    }

    public boolean verifyThatAddButtonIsDisplayed() {
        return ADDBUTTON.isDisplayed();
    }

    public boolean verifyThatTotalPriceIsDisplayed() {
        TOTALPRICE.should(appear, Duration.ofSeconds(3000));
        return TOTALPRICE.isDisplayed();
    }

    public boolean verifyThatTotalDiscountIsDisplayed() {
        TOTALDISCOUNT.should(appear, Duration.ofSeconds(3000));
        return TOTALDISCOUNT.isDisplayed();
    }
}
