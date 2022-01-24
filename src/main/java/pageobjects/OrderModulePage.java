package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dto.CredentionalDTO;
import dto.OrderDTO;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;
import static dto.MapperDTO.credentionalDTO;
import static dto.MapperDTO.orderDTO;

public class OrderModulePage {

    private final SelenideElement TITLE = $x("//span[@title='Order Module']");
    private final SelenideElement NEWBUTTON = $x("//div[@title='New']");
    private final SelenideElement CTORDERSTAB = $x("//*[text()='CT Orders']");
    private final SelenideElement NEWCTORDERVIEW = $x("//*[@class='slds-clearfix detail-panel-root footer-visible']");
    private final SelenideElement ACCOUNTSTABCONTENT = $("#brandBand_1");


    private final SelenideElement ORDERTYPEFIELD = $x("//*[text()='Order Type']/following-sibling::* | //*[@class='slds-form-element_stacked slds-form-element slds-has-error']//input");
    private final SelenideElement ORDERTYPEFIELDORDER = $x("//span[@title='Order']");
    private final SelenideElement ACCOUNTFIELD = $x("//*[@placeholder=\"Search Accounts...\"]");
    private final SelenideElement CONTACTFIELD = $x("//*[@placeholder=\"Search Contacts...\"]");
    private final SelenideElement PRICEBOOKFIELD = $x("//*[@placeholder=\"Search CT Price Books...\"]");
    private final SelenideElement SALESORGFIELD = $x("//*[@placeholder=\"Search Sales Organizations...\"]");
    private final SelenideElement PRICINGPROCEDURESFIELD = $x("//*[@placeholder=\"Search Pricing Procedures...\"]");
    private final SelenideElement DESCRIPTION = $x("//*[@name=\"orders__Description__c\"]");
    private final SelenideElement TOTALPRICE = $x("//*[@name=\"orders__TotalPrice__c\"]");
    private final SelenideElement TOTALDISCOUNT = $x("//*[@name=\"orders__TotalDiscount__c\"]");
    private final SelenideElement SAVEBUTTON = $x("//*[@name=\"SaveEdit\"]");
    private final SelenideElement SUCCESSTOASTBANNER = $x("//div[@data-key='success']");
    private final SelenideElement EDITCARTBUTTON = $x("//*[text()='Edit Cart']");

    CredentionalDTO credentionalDTO = credentionalDTO();

    public boolean verifyThatOrderModulePageIsDisplayed() {
        TITLE.should(appear, Duration.ofSeconds(3000));
        return TITLE.isDisplayed();
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) getAndCheckWebDriver();
    }

    public void openCtOrdersTab() {
        Selenide.open(credentionalDTO.getCtOrderTab());
        /*ACCOUNTSTABCONTENT.shouldBe(Condition.visible);
        Selenide.sleep(2000);
        final JavascriptExecutor executor = getJavascriptExecutor();
        executor.executeScript("arguments[0].click();", CTORDERSTAB.getWrappedElement());*/
    }

    public void clickNewButton() {
        NEWBUTTON.click();
    }

    public void clickEditCartButton() {
        EDITCARTBUTTON.click();
    }

    public boolean verifyThatNewOrderViewIsDisplayed() {
        NEWCTORDERVIEW.should(appear, Duration.ofSeconds(3000));
        return NEWCTORDERVIEW.isDisplayed();
    }

    public void fillNewOrderView() {
        OrderDTO orderDTO = orderDTO(); //здесь создается экземпляр Order DTO, поля которого хранят в себе поля из Order.Json

        NEWCTORDERVIEW.shouldBe(visible, Duration.ofSeconds(2));
        ORDERTYPEFIELD.click();
        if(!ORDERTYPEFIELDORDER.isDisplayed()){
            ORDERTYPEFIELD.click();
        }
        ORDERTYPEFIELDORDER.shouldBe(visible, Duration.ofSeconds(3));
        ORDERTYPEFIELDORDER.click();

        ACCOUNTFIELD.sendKeys(orderDTO.getAccount());
        ACCOUNTFIELD.click();
        $x(String.format("//*[@class='slds-listbox__option-text slds-listbox__option-text_entity']//*[@title='%s']", orderDTO.getAccount())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        PRICEBOOKFIELD.sendKeys(orderDTO.getPriceBook());
        PRICEBOOKFIELD.click();
        $x(String.format("//*[@title='%s']", orderDTO.getPriceBook())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        SALESORGFIELD.sendKeys(orderDTO.getSalesOrganization());
        SALESORGFIELD.click();
        $x(String.format("//*[@class='slds-listbox__option-text slds-listbox__option-text_entity']//*[@title='%s']", orderDTO.getSalesOrganization())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        PRICINGPROCEDURESFIELD.sendKeys(orderDTO.getPricingProcedure());
        PRICINGPROCEDURESFIELD.click();
        $x(String.format("//*[@title='%s']", orderDTO.getPricingProcedure())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        DESCRIPTION.sendKeys(orderDTO().getDescription());
        SAVEBUTTON.click();
    }

    public boolean verifyThatToastMessageIsDisplayed() {
        SUCCESSTOASTBANNER.should(appear, Duration.ofSeconds(3000));
        return SUCCESSTOASTBANNER.isDisplayed();
    }
}