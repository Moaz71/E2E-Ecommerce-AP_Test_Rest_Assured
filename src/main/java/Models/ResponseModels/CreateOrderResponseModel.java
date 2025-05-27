package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateOrderResponseModel {
    @JsonProperty("orders")
    public List<String> orders;

    @JsonProperty("productOrderId")
    public List<String> productOrderIds;

    @JsonProperty("message")
    public String message;

}
