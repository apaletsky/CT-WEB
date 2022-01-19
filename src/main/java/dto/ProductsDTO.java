package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductsDTO {

    @JsonProperty("products")
    List<String> Products;

    public List<String> getProducts() {
        return Products;
    }
}
