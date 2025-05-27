package Models.RequestModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestModel {
    // annotation used to map the name of the json key to the name of the variable
    //it case sensitive and must has the same name as the json key
    @JsonProperty("userEmail")
    public String email;
    @JsonProperty("userPassword")
    public String password;

}
