package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

import java.time.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;


public class OrderDetailsPage {

    private final SelenideElement ORDERDETAILS = $x("//*[@class='slds-media']");
    private final SelenideElement SEARCHFIELD = $x("//*[@name='search']");
    private final SelenideElement BUTTONSPANEL = $x("//*[@class='slds-page-header__col-actions slds-col']");
    private final SelenideElement CATALOGSTAB = $x("//a[@data-label='CATALOGS']");
    private final SelenideElement ACCORDINGSUMMARY = $x("//*[@title='All Accounts. SPOONABLE YOGHURTS']");
    private final SelenideElement CATALOGDANISSIMO = $x("//*[@title='Danissimo']");
    private final SelenideElement ACCORDINGCONTENT = $x("//*[@class='accordion__content']");

    private final SelenideElement CATALOGDANISSIMO105 = $x("//*[@title='105']");
    private final SelenideElement CATALOGDANISSIMO105_prod1 = $x("//*[text()='DM SPOON YOG 105 CRNCH-MAR-MAN/plast cup']");
    private final SelenideElement CATALOGDANISSIMO105_prod2 = $x("//*[text()='DM SPOON YOG 105 CHO FLAK/plast cup']");
    private final SelenideElement CATALOGDANISSIMO105_prod3 = $x("//*[text()='DM SPOON YOG 105 CRUNCH/plast cup']");
    private final SelenideElement CATALOGDANISSIMO105_prod4 = $x("//*[text()='DM SPOON YOG 105 CRNCH BER FLV/plast cup']");

    private final SelenideElement CATALOGDANISSIMO105_prod4_BACKGROUNDCOLOR = $x("//*[@class='child-product item-checked']");

    private final SelenideElement PROMOTIONTAB = $x("//a[@data-label='PROMOTION']");
    private final SelenideElement ARROW = $x("//*[@class='slds-icon-utility-left split-view-btn slds-icon_container']");
    private final SelenideElement SELECTPRODUCTTEXT = $x("//*[text()='Select and add a product from the left list']");
    private final SelenideElement ADDBUTTON = $x("//*[@title='Add']");
    private final SelenideElement TOTALPRICE = $x("//*[text()='Total Price:']");
    private final SelenideElement TOTALDISCOUNT = $x("//*[text()='Total Discount:']");
    // окно создания доставки
    private final SelenideElement ADDADDRESS = $x("//*[@name='deliveryAddress']");
    private final SelenideElement ADDDATE = $x("//*[@name='deliveryDate']");
    private final SelenideElement BUTTONOK = $x("//*[@title='OK']");

    //элементы на странице заказа для валидации после добавления продуктов в закза
    private String DELIVERYADDADDRESS;
    private final SelenideElement PRODUCTNAME = $x("//*[text()='Product Name']");
    private final SelenideElement DELIVERYADDRESS = $x(String.format("//*[@title='%s']",DELIVERYADDADDRESS));
    //private final SelenideElement LISTPRICE =


    // метод CATALOGDANISSIMO105_prod4_BACKGROUNDCOLOR.getCssValue("background-color")
    // может вернуть rgba(250, 255, 143, 0.925) где последний параметр это яркость
    // яркость у нас за доли секунды меняется с 0 до 1
    // чтобы не ждать секунду, можес не методос equals проверить совпадение цвета, а методом contains
    private final String YELLOWBACKGROUNDCOLOR = "250, 255, 143";


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

    public boolean verifyThatOrderProductHierarchyIsDisplayed() {
        return ACCORDINGSUMMARY.isDisplayed();
    }

    public void clickOrderProductHierarchy() {
        ACCORDINGSUMMARY.click();
    }

    public boolean verifyThatCatalogDanissimoIsDisplayed() {
        return CATALOGDANISSIMO.isDisplayed();
    }

    public void clickCatalogDanissimo() {
        CATALOGDANISSIMO.click();
    }

    public boolean verifyThatCatalogDanissimo105IsDisplayed() {
        return CATALOGDANISSIMO105.isDisplayed();
    }

    public void clickCatalogDanissimo105() {
        CATALOGDANISSIMO105.click();
    }

    public boolean verifyThatProductsInCatalogDanissimo105IsDisplayed() {
        return CATALOGDANISSIMO105_prod1.isDisplayed()
                && CATALOGDANISSIMO105_prod2.isDisplayed()
                && CATALOGDANISSIMO105_prod3.isDisplayed()
                && CATALOGDANISSIMO105_prod4.isDisplayed();
    }

    public void addProductsFromCatalogDanissimo105() {
        CATALOGDANISSIMO105_prod1.click();
        CATALOGDANISSIMO105_prod2.click();
        CATALOGDANISSIMO105_prod3.click();
        CATALOGDANISSIMO105_prod4.click();
    }

    public boolean verifyProd4BackgroundColorisYellow(){
        //System.out.println("************* = " + CATALOGDANISSIMO105_prod4_BACKGROUNDCOLOR.getCssValue("background-color"));
        //System.out.println("************* = " + CATALOGDANISSIMO105_prod4_BACKGROUNDCOLOR.getCssValue("background-color").contains(YELLOWBACKGROUNDCOLOR));
        return CATALOGDANISSIMO105_prod4_BACKGROUNDCOLOR.getCssValue("background-color").contains(YELLOWBACKGROUNDCOLOR);
    }

    public String getAddButtonText(){
        return ADDBUTTON.getText();
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

    public void clickAddButton(){
        ADDBUTTON.click();
    }

    public boolean verifyThatAddressPopulated(){
        //System.out.println("****** = " + ADDADDRESS.getText());
        DELIVERYADDADDRESS = ADDADDRESS.getText();
        return ADDADDRESS.getText().length() != 0;
    }

    public boolean verifyThatDatePopulatedAsToday(){
        // getText() не работает на полях с типом Input.
        // вместо этого есть метод getAttribute
        // https://stackoverflow.com/questions/36202689/selenium-webdriver-get-text-from-input-field
        System.out.println("****** = " + ADDDATE.getAttribute("value"));

        // How Current day: https://www.javatpoint.com/java-get-current-date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("CompareDate = " + ADDDATE.getAttribute("value").equals(dtf.format(now)));
        return ADDDATE.getAttribute("value").equals(dtf.format(now));
    }

    public void clickButtonOK(){
        BUTTONOK.click();
    }

    public boolean verifyThatProductNameIsDisplayed() {
        PRODUCTNAME.should(visible,Duration.ofSeconds(3000));
        System.out.println("PRODUCTNAME.isDisplayed() = "+ PRODUCTNAME.isDisplayed());
        return PRODUCTNAME.isDisplayed();
    }

    public boolean verifyThatDeliveryAddressIsDisplayed () {
        DELIVERYADDRESS.should(visible,Duration.ofSeconds(3000));
        System.out.println("DELIVERYADDRESS.isDisplayed() = "+ DELIVERYADDRESS.isDisplayed());
        return DELIVERYADDRESS.isDisplayed();
    }

}
