package dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//Данный класс был в Order Module Page и перенесла сюда тк показалось будет логичным держать маппер к созданию заказ и маппер к кредам
//Класс создан для того, что бы указать путь к файлу с json, из которого будут тянустья данные
public class MapperDTO {

    public MapperDTO() {
    }

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
//прописала аналогичное для Credational
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
