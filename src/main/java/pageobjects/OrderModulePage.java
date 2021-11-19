package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OrderDTO;
import org.openqa.selenium.JavascriptExecutor;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;

public class OrderModulePage {

    private final SelenideElement TITLE = $x("//span[@title='Order Module']");
    private final SelenideElement NEWBUTTON = $x("//div[@title='New']");
    private final SelenideElement CTORDERSTAB = $x("//*[text()='CT Orders']");
    private final SelenideElement NEWCTORDERVIEW = $x("//*[@class='slds-clearfix detail-panel-root footer-visible']");
    private final SelenideElement ACCOUNTSTABCONTENT = $("#brandBand_1");


    private final SelenideElement ORDERTYPEFIELD = $x("//*[text()='Order Type']/following-sibling::* | //*[@class='slds-form-element_stacked slds-form-element slds-has-error']//input");
    private final SelenideElement ORDERTYPEDROPDOWNLIST = $x("//*[@class=\"slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7\"]");
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

    public boolean verifyThatOrderModulePageIsDisplayed() {
        TITLE.should(appear, Duration.ofSeconds(3000));
        return TITLE.isDisplayed();
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) getAndCheckWebDriver();
    }

    public void openCtOrdersTab() {
        Selenide.open("https://power-nosoftware-2166-dev-ed.lightning.force.com/lightning/o/orders__Order__c/list?filterName=Recent");
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
        OrderDTO orderDTO = orderDTO();
        //NEWCTORDERVIEW.shouldBe(visible, Duration.ofSeconds(2));
        ORDERTYPEFIELD.click();
        //ORDERTYPEDROPDOWNLIST.shouldBe(visible, Duration.ofSeconds(2));
        $x(String.format("//*[@title='%s']", orderDTO.getOrderType())).should(visible, Duration.ofSeconds(3000)).click();

        ACCOUNTFIELD.click();
        ACCOUNTFIELD.sendKeys(orderDTO.getAccount());
        $x(String.format("//*[@class='slds-listbox__option-text slds-listbox__option-text_entity']//*[@title='%s']", orderDTO.getAccount())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        //CONTACTFIELD.click();
        //CONTACTFIELD.sendKeys(orderDTO.getContact());

        PRICEBOOKFIELD.click();
        PRICEBOOKFIELD.sendKeys(orderDTO.getPriceBook());
        $x(String.format("//*[@title='%s']", orderDTO.getPriceBook())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        SALESORGFIELD.click();
        SALESORGFIELD.sendKeys(orderDTO.getSalesOrganization());
        $x(String.format("//*[@class='slds-listbox__option-text slds-listbox__option-text_entity']//*[@title='%s']", orderDTO.getSalesOrganization())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        PRICINGPROCEDURESFIELD.click();
        PRICINGPROCEDURESFIELD.sendKeys(orderDTO.getPricingProcedure());
        $x(String.format("//*[@title='%s']", orderDTO.getPricingProcedure())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        DESCRIPTION.sendKeys(orderDTO().getDescription());
        TOTALPRICE.sendKeys(orderDTO().getTotalPrice());
        TOTALDISCOUNT.sendKeys(orderDTO().getTotalDiscount());
        SAVEBUTTON.click();
    }

    public boolean verifyThatToastMessageIsDisplayed() {
        SUCCESSTOASTBANNER.should(appear, Duration.ofSeconds(3000));
        return SUCCESSTOASTBANNER.isDisplayed();
    }

    public OrderDTO orderDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderDTO orderDTO = null;
        try {
            orderDTO = objectMapper.readValue(new File("src/main/resources/data/order.json"), OrderDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderDTO;
    }
}