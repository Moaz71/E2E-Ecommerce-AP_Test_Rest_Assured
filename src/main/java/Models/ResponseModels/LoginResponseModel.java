package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseModel {
    @JsonProperty("token")
    public String token;
    @JsonProperty("userId")
    public String userId;
    @JsonProperty("message")
    public String message;
}
