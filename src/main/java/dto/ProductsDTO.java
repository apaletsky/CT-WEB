package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductsDTO {

    @JsonProperty("products")
    private List<Product> Products;

    public List<Product> getProducts() {
        return Products;
    }

    @Data
    public static class Product {
        @JsonProperty("name")
        private String name;
        @JsonProperty("quantity")
        private String quantity;

        public String getName() {
            return name;
        }

        public String getQuantity() {
            return quantity;
        }
    }
}
