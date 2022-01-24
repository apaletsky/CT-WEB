package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderDTO {

    @JsonProperty("orderType") //поля из Order.json
    String orderType; // поля объекта из PagesObject

    @JsonProperty("account")
    String account;

    @JsonProperty("contact")
    String contact;

    @JsonProperty("priceBook")
    String priceBook;

    @JsonProperty("salesOrganization")
    String salesOrganization;

    @JsonProperty("pricingProcedure")
    String pricingProcedure;

    @JsonProperty("description")
    String description;

    @JsonProperty("stage")
    String stage;

    @JsonProperty("totalPrice")
    String totalPrice;

    @JsonProperty("totalDiscount")
    String totalDiscount;

    // конструктор OrderDTO метода OrderDTO (не используется, потому что не вызывается, не вызывается, потому что используется статичный метод Mapper DTO)
    public OrderDTO(String orderType, String account, String contact, String priceBook, String salesOrganization, String pricingProcedure, String description, String stage, String totalPrice, String totalDiscount) {
        this.orderType = orderType;
        this.account = account;
        this.contact = contact;
        this.priceBook = priceBook;
        this.salesOrganization = salesOrganization;
        this.pricingProcedure = pricingProcedure;
        this.description = description;
        this.stage = stage;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
    }

    public OrderDTO() {
    }

// get и set используются для реализации принципа инкапсуляцииб
    public String getOrderType() {
        return orderType;
    }

    public String getAccount() {
        return account;
    }

    public String getContact() {
        return contact;
    }

    public String getPriceBook() {
        return priceBook;
    }

    public String getSalesOrganization() {
        return salesOrganization;
    }

    public String getPricingProcedure() {
        return pricingProcedure;
    }

    public String getDescription() {
        return description;
    }

    public String getStage() {
        return stage;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }


}
