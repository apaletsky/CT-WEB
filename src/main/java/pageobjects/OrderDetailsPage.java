package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dto.ProductsDTO;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static dto.MapperDTO.productsDTO;

public class OrderDetailsPage {

    private final SelenideElement ORDERDETAILS = $x("//*[@class='slds-media']");
    private final SelenideElement SEARCHFIELD = $x("//*[@name='search']");
    private final SelenideElement BUTTONSPANEL = $x("//*[@class='slds-page-header__col-actions slds-col']");
    private final SelenideElement CATALOGSTAB = $x("//a[@data-label='CATALOGS']");
    private final SelenideElement ACCORDINGSUMMARY = $x("//*[@title='All Accounts. SPOONABLE YOGHURTS']");
    private final SelenideElement CATALOGDANISSIMO = $x("//*[@title='Danissimo']");
    private final SelenideElement CATALOGDANISSIMO105 = $x("//*[@title='105']");
    private SelenideElement CATALOGDANISSIMO105_prod1;
    private SelenideElement CATALOGDANISSIMO105_prod2;
    private SelenideElement CATALOGDANISSIMO105_prod3;
    private SelenideElement CATALOGDANISSIMO105_prod4;
    private final SelenideElement CATALOGDANISSIMO105_prod4_BACKGROUNDCOLOR = $x("//*[@class='child-product item-checked']");
    private final SelenideElement PROMOTIONTAB = $x("//a[@data-label='PROMOTION']");
    private final SelenideElement ARROW = $x("//*[@class='slds-icon-utility-left split-view-btn slds-icon_container']");
    private final SelenideElement SELECTPRODUCTTEXT = $x("//*[text()='Select and add a product from the left list']");
    private final SelenideElement ADDBUTTON = $x("//*[@title='Add']");
    private final SelenideElement TOTALPRICE = $x("//*[text()='Total Price:']");
    private final SelenideElement TOTALDISCOUNT = $x("//*[text()='Total Discount:']");
    private final SelenideElement ADDADDRESS = $x("//*[text()='Add Address']//following-sibling::div//button/span");
    private final SelenideElement ADDDATE = $x("//*[@name='deliveryDate']");
    private final SelenideElement OKBUTTON = $x("//*[@title='OK']");
    private String DELIVERYADDRESS;
    private final SelenideElement PRODUCTNAME = $x("//*[text()='Product Name']");
    private SelenideElement DELIVERYADDEDADDRESS;
    private final SelenideElement DELIVERYADDEDDATE = $x("//*[@data-name='delivery_date_header']");
    private final ElementsCollection ADDEDPRODUCTS = $$x("//*[@data-name='product']");
    private final ElementsCollection QUANTITYOFADDEDPRODUCTS = $$x("//*[@data-name='dli']//input");
    private final ElementsCollection PRODUCTSDELETIONCHECKBOXES = $$x("//*[@data-name='product']//ancestor::th//following-sibling::td/lightning-input/div/span/label"); //$$x("//*[@class='order-table-row slds-hint-parent']//td//input");
    private final ElementsCollection DELETEBUTTON = $$x("//*[@title='delete']");
    private int countOfAddedProduct;
    private final SelenideElement SAFEDRAFTBUTTON = $x("//*[text()='Save Draft']");
    private final SelenideElement EXITBUTTON = $x("//*[@title='Exit']");
    private final SelenideElement POPUP_AREYOUSURE = $x("//*[text()='All changes will be lost. Are you sure?']");
    private final SelenideElement OKBUTTONONPOPUP = $x("//section/div/footer/lightning-button[1]/button");
    private final String YELLOWBACKGROUNDCOLOR = "250, 255, 143";
    private ProductsDTO productsDTO = productsDTO();

    public boolean verifyThatOrderDetailsIsDisplayed() {
        ORDERDETAILS.should(visible, Duration.ofSeconds(60));
        return ORDERDETAILS.isDisplayed();
    }

    public boolean verifyThatSearchFieldIsDisplayed() {
        SEARCHFIELD.should(visible, Duration.ofSeconds(60));
        return SEARCHFIELD.isDisplayed();
    }

    public boolean verifyThatButtonsPanelIsDisplayed() {
        return BUTTONSPANEL.isDisplayed();
    }

    public boolean verifyThatCatalogTabIsDisplayed() {
        return CATALOGSTAB.isDisplayed();
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
       
        CATALOGDANISSIMO105_prod1 = $x(String.format("//*[text()='%s']",productsDTO.getProducts().get(0).getName())).shouldBe(visible, Duration.ofSeconds(60));
        CATALOGDANISSIMO105_prod2 = $x(String.format("//*[text()='%s']",productsDTO.getProducts().get(1).getName())).shouldBe(visible, Duration.ofSeconds(60));
        CATALOGDANISSIMO105_prod3 = $x(String.format("//*[text()='%s']",productsDTO.getProducts().get(2).getName())).shouldBe(visible, Duration.ofSeconds(60));
        CATALOGDANISSIMO105_prod4 = $x(String.format("//*[text()='%s']",productsDTO.getProducts().get(3).getName())).shouldBe(visible, Duration.ofSeconds(60));
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
        TOTALPRICE.should(appear, Duration.ofSeconds(60));
        return TOTALPRICE.isDisplayed();
    }

    public boolean verifyThatTotalDiscountIsDisplayed() {
        TOTALDISCOUNT.should(appear, Duration.ofSeconds(60));
        return TOTALDISCOUNT.isDisplayed();
    }

    public void clickAddButton(){
        ADDBUTTON.should(visible, Duration.ofSeconds(60));
        ADDBUTTON.click();
    }

    public boolean verifyThatAddressPopulated(){
        DELIVERYADDRESS = ADDADDRESS.getText();
        return DELIVERYADDRESS.length() != 0;
    }

    public boolean verifyThatDatePopulatedAsToday(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        return ADDDATE.getAttribute("value").equals(dtf.format(now));
    }

    public void clickButtonOK(){
        OKBUTTON.should(visible, Duration.ofSeconds(60));
        OKBUTTON.click();
    }

    public boolean verifyThatProductNameIsDisplayed() {
        PRODUCTNAME.should(visible,Duration.ofSeconds(60));
        return PRODUCTNAME.isDisplayed();
    }

    public boolean verifyThatDeliveryAddressIsDisplayedAndCorrect() {
        DELIVERYADDEDADDRESS = $x(String.format("//*[@title='%s']", DELIVERYADDRESS)).shouldBe(visible, Duration.ofSeconds(60));
        return DELIVERYADDRESS.equals(DELIVERYADDEDADDRESS.getText());
    }

    public boolean verifyThatDateIsDisplayedAndCorrect() {
        DELIVERYADDEDDATE.shouldBe(visible, Duration.ofSeconds(60));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return DELIVERYADDEDDATE.getText().equals(dtf.format(now));
    }

    public int getCountOfAddedProduct() {
        return countOfAddedProduct;
    }

    public void setCountOfAddedProduct(int countOfAddedProduct) {
        this.countOfAddedProduct = countOfAddedProduct;
    }

    public boolean verifyThatProductsAreAdded(){
        setCountOfAddedProduct(ADDEDPRODUCTS.size());
        return ADDEDPRODUCTS.size() == productsDTO.getProducts().size();
    }

    public boolean verifyThatQuantityOfAddedProductsIsZero(){
        return QUANTITYOFADDEDPRODUCTS.get(0).getAttribute("value").equals("0")
                && QUANTITYOFADDEDPRODUCTS.get(1).getAttribute("value").equals("0")
                && QUANTITYOFADDEDPRODUCTS.get(2).getAttribute("value").equals("0")
                && QUANTITYOFADDEDPRODUCTS.get(3).getAttribute("value").equals("0");
    }

    public void setQuantityValuesForAddedProducts(){
        QUANTITYOFADDEDPRODUCTS.get(0).setValue(productsDTO.getProducts().get(0).getQuantity());
        QUANTITYOFADDEDPRODUCTS.get(1).click();
        QUANTITYOFADDEDPRODUCTS.get(1).setValue(productsDTO.getProducts().get(1).getQuantity());
        QUANTITYOFADDEDPRODUCTS.get(2).click();
        QUANTITYOFADDEDPRODUCTS.get(2).setValue(productsDTO.getProducts().get(2).getQuantity());
        QUANTITYOFADDEDPRODUCTS.get(3).click();
        QUANTITYOFADDEDPRODUCTS.get(3).setValue(productsDTO.getProducts().get(3).getQuantity());
        QUANTITYOFADDEDPRODUCTS.get(0).click();
    }

    public boolean verifyThatQuantityOfAddedProductsIsChanged(){
        return Objects.equals(QUANTITYOFADDEDPRODUCTS.get(0).getAttribute("value"), productsDTO.getProducts().get(0).getQuantity())
                && Objects.equals(QUANTITYOFADDEDPRODUCTS.get(1).getAttribute("value"), productsDTO.getProducts().get(1).getQuantity())
                && Objects.equals(QUANTITYOFADDEDPRODUCTS.get(2).getAttribute("value"), productsDTO.getProducts().get(2).getQuantity())
                && Objects.equals(QUANTITYOFADDEDPRODUCTS.get(3).getAttribute("value"), productsDTO.getProducts().get(3).getQuantity());
    }

    public void clickSafeDraftButton(){
        SAFEDRAFTBUTTON.shouldBe(enabled, Duration.ofSeconds(60));
        SAFEDRAFTBUTTON.click();
    }

    public void clickExitButton(){
        EXITBUTTON.shouldBe(visible, Duration.ofSeconds(60));
        EXITBUTTON.click();
    }

    public boolean verifyThatPopUpForVerificationIsDisplayed(){
        POPUP_AREYOUSURE.should(visible,Duration.ofSeconds(60));
        OKBUTTONONPOPUP.should(visible, Duration.ofSeconds(60));
        return POPUP_AREYOUSURE.isDisplayed() && OKBUTTONONPOPUP.isDisplayed();
    }

    public void clickOkButtonOnVerificationPopUp(){
        OKBUTTONONPOPUP.shouldBe(visible, Duration.ofSeconds(60));
        OKBUTTONONPOPUP.click();
    }

    public void deleteLastProduct(){
        PRODUCTSDELETIONCHECKBOXES.last().click();
        DELETEBUTTON.last().click();
    }
}
