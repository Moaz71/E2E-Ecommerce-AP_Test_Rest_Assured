package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginInvalidResponse {
    @JsonProperty("message")
    public String message;
}
