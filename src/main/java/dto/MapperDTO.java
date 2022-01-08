package dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MapperDTO {
    public static OrderDTO orderDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderDTO orderDTO = null;
        try {
            orderDTO = objectMapper.readValue(new File("src/main/resources/data/order.json"), OrderDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderDTO;
    }

    public MapperDTO() {
    }

    public static CredentionalDTO credentionalDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        CredentionalDTO credentionalDTO = null;
        try {
            credentionalDTO = objectMapper.readValue(new File("src/main/resources/data/credentials.json"), CredentionalDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentionalDTO;
    }
}
