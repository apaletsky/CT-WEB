package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data; //библиотека для того чтобы линковать поля из JSON с полями объекта (JsonProperty), есть и другие возможности, которые не используем (замена get и set)

@Data
public class CredentionalDTO {

    // https://habr.com/ru/post/513072/ пояснение о DTO
    //Линковка полей объекта к полям из Json файла
    @JsonProperty("orgLink") //поле из .json
    String orgLink;

    @JsonProperty("ctOrderTab")
    String ctOrderTab;

    @JsonProperty("username")
    String username;

    @JsonProperty("password")
    String password;

    //Конструктор кредов и линка (называется всегда также как сам класс, класс не вызывается)
    //нужен для того чтобы создать экземпляр класса с конкретными значениями полей
    //Прочитала, что у каждого класса должен быть свой конструктор
    //в данном случае прописала в качестве попытки создать конструктор, по факту не вызывается
    public CredentionalDTO(String orgLink, String ctOrderTab, String username, String password){
        this.orgLink = orgLink;
        this.ctOrderTab = ctOrderTab;
        this.username = username;
        this.password = password;
    }

    // пустой конструктор, который можно будет использовать для создания экземпляра класса (класс не вызывается)
    // прочитала, что так должно быть
    public CredentionalDTO(){}

    // Если бы поля были private, то getter и setter - must have для доступа к полям.
    // методы get|set используются для доступа к значению поля, чтобы не обращаться на прямую к полю (принцип инкапсуляции)
    // метод get - получить значение из поля. Метод используется, тк нужно получить значение из поля OrgLInk

    public String getOrgLink() {
        return orgLink;
    }

    public String getCtOrderTab() {
        return ctOrderTab;
    }

    // метод set - задать значение в поле, метод не вызывается, тк данные беруться из файлв с Json (ссылка на файл в классе маппер)
    public void setCtOrderTab(String ctOrderTab) {
        this.ctOrderTab = ctOrderTab;
    }

    public void setOrgLink(String orgLink) {
        this.orgLink = orgLink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
