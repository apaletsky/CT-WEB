package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import dto.CredentionalDTO;
import dto.OrderDTO;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;
import static dto.MapperDTO.credentionalDTO;
import static dto.MapperDTO.orderDTO;

public class OrderModulePage {

    private final SelenideElement TITLE = $x("//span[@title='Order Module']");
    private final SelenideElement NEWBUTTON = $x("//div[@title='New']");
    private final SelenideElement CTORDERSTAB = $x("//*[text()='CT Orders']");
    private final SelenideElement NEWCTORDERVIEW = $x("//*[@class='slds-clearfix detail-panel-root footer-visible']");
    private final SelenideElement ACCOUNTSTABCONTENT = $("#brandBand_1");

    private final SelenideElement COMPLETETHISFIELDMESSAGE = $x("//*[@class='slds-form-element__help']");

    private final SelenideElement ORDERTYPEFIELD = $x("//*[text()='Order Type']/following-sibling::* | //*[@class='slds-form-element_stacked slds-form-element slds-has-error']//input");
    private final SelenideElement ORDERTYPEFIELDORDER = $x("//span[@title='Order']");
    private final SelenideElement ACCOUNTFIELD = $x("//*[@placeholder=\"Search Accounts...\"]");
    private final SelenideElement PRICEBOOKFIELD = $x("//*[@placeholder=\"Search CT Price Books...\"]");
    private final SelenideElement SALESORGFIELD = $x("//*[@placeholder=\"Search Sales Organizations...\"]");
    private final SelenideElement PRICINGPROCEDURESFIELD = $x("//*[@placeholder=\"Search Pricing Procedures...\"]");
    private final SelenideElement DESCRIPTION = $x("//*[@name=\"orders__Description__c\"]");
    private final SelenideElement SAVEBUTTON = $x("//*[@name=\"SaveEdit\"]");
    private final SelenideElement SUCCESSTOASTBANNER = $x("//div[@data-key='success']");
    private final SelenideElement EDITCARTBUTTON = $x("//*[text()='Edit Cart']");
    //https://www.scientecheasy.com/2019/08/xpath-axes.html/   - хорошее пояснение про переходы в xpath по дереву элементов
    private final SelenideElement STAGEFIELD = $x("//*[text()=\"Stage\"]//parent::div//following-sibling::div//child::lightning-formatted-text");
    private final String ONHOLD = "On-Hold";
    private final ElementsCollection RELATEDLISTSOLI = $$x("//*[@aria-label='Order Line Item #']//ancestor::table//tbody//tr");
    private final ElementsCollection RELATEDLISTDELIVERY = $$x("//*[@aria-label='Delivery #']//ancestor::table//tbody//tr");
    private final SelenideElement DELIVERYRECORDBUTTON= $x("//*[@aria-label='Delivery #']//ancestor::table//tbody//tr//lightning-button-icon//preceding-sibling::a");
    private final SelenideElement FOOTER = $x("//*[@data-component-id='force_relatedListContainer']");

    CredentionalDTO credentionalDTO = credentionalDTO();

    public boolean verifyThatOrderModulePageIsDisplayed() {
        TITLE.should(appear, Duration.ofSeconds(60));
        return TITLE.isDisplayed();
    }

    public static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) getAndCheckWebDriver();
    }

    public void openCtOrdersTab() {
        Selenide.open(credentionalDTO.getCtOrderTab());
    }

    public void clickNewButton() {
        NEWBUTTON.should(visible, Duration.ofSeconds(60));
        NEWBUTTON.click();
    }

    public void clickEditCartButton() {
        EDITCARTBUTTON.should(visible, Duration.ofSeconds(60));
        EDITCARTBUTTON.click();
    }

    public boolean verifyThatNewOrderViewIsDisplayed() {
        NEWCTORDERVIEW.should(appear, Duration.ofSeconds(60));
        return NEWCTORDERVIEW.isDisplayed();
    }

    public void fillNewOrderView() {
        OrderDTO orderDTO = orderDTO(); //здесь создается экземпляр Order DTO, поля которого хранят в себе поля из Order.Json

        ORDERTYPEFIELD.click(); // тут SendKeys не нужен, тк мы не заполняем значением поля, а выбираем из выпадающего списка
//        if(!ORDERTYPEFIELDORDER.isDisplayed()){ //услвоие отобразился или нет пиклист (знак ! в условии делает инверсию Boolean значение (true<->false))
//            ORDERTYPEFIELD.click(); // если не отобразился пиклист, то выполняется второй клик
//        }
        if(COMPLETETHISFIELDMESSAGE.isDisplayed()){
            ORDERTYPEFIELD.click();
        }
        ORDERTYPEFIELDORDER.shouldBe(visible, Duration.ofSeconds(60));
        ORDERTYPEFIELDORDER.click();

        ACCOUNTFIELD.sendKeys(orderDTO.getAccount()); //sendKeys здесь нужен потому что берем значение из поля
        if(COMPLETETHISFIELDMESSAGE.isDisplayed()){
            ACCOUNTFIELD.click();
        }
        $x(String.format("//*[@class='slds-listbox__option-text slds-listbox__option-text_entity']//*[@title='%s']", orderDTO.getAccount())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        PRICEBOOKFIELD.sendKeys(orderDTO.getPriceBook());
        if(COMPLETETHISFIELDMESSAGE.isDisplayed()){
            PRICEBOOKFIELD.click();
        }
        $x(String.format("//*[@title='%s']", orderDTO.getPriceBook())).shouldBe(visible, Duration.ofSeconds(60)).click();

        SALESORGFIELD.sendKeys(orderDTO.getSalesOrganization());
        try {
            //https://overcoder.net/q/855235/%D0%BF%D0%BE%D1%87%D0%B5%D0%BC%D1%83-java-%D0%B2%D1%8B%D0%B1%D1%80%D0%B0%D1%81%D1%8B%D0%B2%D0%B0%D0%B5%D1%82-javalangillegalmonitorstateexception-%D0%BA%D0%BE%D0%B3%D0%B4%D0%B0-%D1%8F-%D0%B2%D1%8B%D0%B7%D1%8B%D0%B2%D0%B0%D1%8E
            synchronized(this){
                this.wait(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(COMPLETETHISFIELDMESSAGE.isDisplayed()){
            SALESORGFIELD.click();
        }
        $x(String.format("//*[@class='slds-listbox__option-text slds-listbox__option-text_entity']//*[@title='%s']", orderDTO.getSalesOrganization())).shouldBe(visible, Duration.ofSeconds(3000)).click();

        PRICINGPROCEDURESFIELD.sendKeys(orderDTO.getPricingProcedure());
        $x(String.format("//*[@title='%s']", orderDTO.getPricingProcedure())).shouldBe(visible, Duration.ofSeconds(60)).click();

        DESCRIPTION.sendKeys(orderDTO().getDescription());
        SAVEBUTTON.click();
    }

    public boolean verifyThatToastMessageIsDisplayed() {
        SUCCESSTOASTBANNER.should(appear, Duration.ofSeconds(60));
        return SUCCESSTOASTBANNER.isDisplayed();
    }

    public boolean verifyThatStageFieldIsOnHold() {
        STAGEFIELD.should(visible, Duration.ofSeconds(60));
        return STAGEFIELD.getText().equals(ONHOLD);
    }

    public boolean verifyThatRelatedListsHaveCountsOfAddedItems(int sizeOfOLI, int sizeOfDelivery){
        FOOTER.scrollIntoView(true);
        RELATEDLISTDELIVERY.get(0).should(appear,Duration.ofSeconds(60));
        return RELATEDLISTSOLI.size() == sizeOfOLI && RELATEDLISTDELIVERY.size() == sizeOfDelivery;
    }

    public void clickDeliveryRecord(){
        String href = DELIVERYRECORDBUTTON.getAttribute("href");
        Selenide.open(href);
  }
    
}
