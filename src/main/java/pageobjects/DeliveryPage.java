package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dto.ProductsDTO;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static dto.MapperDTO.productsDTO;

public class DeliveryPage {
    public ElementsCollection RELATEDLISTDLI;
    private final ElementsCollection DLIQUANTITY = $$x("//*[@data-label='Quantity']//lightning-formatted-number");
    private final SelenideElement ORDERLINK = $x("//*[@title='Order']//following-sibling::p//a");

    private ProductsDTO productsDTO = productsDTO();

    public boolean verifyThatRelatedListsDLILoaded(int sizeOfDLI){
        String customLocator = "//*[text() ='" + sizeOfDLI + " items • ']//ancestor::lst-list-view-manager-header/following-sibling::div//tbody//tr";
        RELATEDLISTDLI = $$x(customLocator);
        RELATEDLISTDLI.get(0).should(appear, Duration.ofSeconds(60));
        return RELATEDLISTDLI.size() == sizeOfDLI;
    }

    public boolean verifyThatDLIsHaveProductsQuantity(){
        return Objects.equals(DLIQUANTITY.get(0).getAttribute("value"), productsDTO.getProducts().get(0).getQuantity())
                && Objects.equals(DLIQUANTITY.get(1).getAttribute("value"), productsDTO.getProducts().get(1).getQuantity())
                && Objects.equals(DLIQUANTITY.get(2).getAttribute("value"), productsDTO.getProducts().get(2).getQuantity())
                && Objects.equals(DLIQUANTITY.get(3).getAttribute("value"), productsDTO.getProducts().get(3).getQuantity());
    }

    public void clickDeliveryRecord(){
        String href = ORDERLINK.getAttribute("href");
        Selenide.open(href);
    }
}
