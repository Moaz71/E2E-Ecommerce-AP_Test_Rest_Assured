package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateProductResponseModel {

    @JsonProperty("message")
    public String message;

    @JsonProperty("productId")
    public String productId;

    @JsonProperty("type")
    public String type;
}
