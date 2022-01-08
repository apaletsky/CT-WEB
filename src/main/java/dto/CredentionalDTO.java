package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CredentionalDTO {

    @JsonProperty("orgLink")
    String orgLink;

    @JsonProperty("username")
    String username;

    @JsonProperty("password")
    String password;

    public CredentionalDTO(String orgLink, String username, String password){
        this.orgLink = orgLink;
        this.username = username;
        this.password = password;
    }

    public CredentionalDTO(){}

    public String getOrgLink() {
        return orgLink;
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
