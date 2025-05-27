package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewOrderDetailsResponseClass {

    @JsonProperty("data")
    public OrderData data;

    @JsonProperty("message")
    public String message;

    public static class OrderData {
        @JsonProperty("_id")
        public String id;

        @JsonProperty("orderById")
        public String orderById;

        @JsonProperty("orderBy")
        public String orderByEmail;

        @JsonProperty("productOrderedId")
        public String productOrderedId;

        @JsonProperty("productName")
        public String productName;

        @JsonProperty("country")
        public String country;

        @JsonProperty("productDescription")
        public String productDescription;

        @JsonProperty("productImage")
        public String productImageUrl;

        @JsonProperty("orderPrice")
        public String orderPrice;

        @JsonProperty("__v")
        public int version;
    }

}
