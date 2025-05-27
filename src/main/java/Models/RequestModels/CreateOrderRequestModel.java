package Models.RequestModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderRequestModel {
    @JsonProperty("orders")
    public List<OrderItem> orders = new ArrayList<>();

    public static class OrderItem {
        @JsonProperty("country")
        public String country;

        @JsonProperty("productOrderedId")
        public String productOrderedId;
    }


    public void addOrderItem(String country, String productId) {
        OrderItem item = new OrderItem();
        item.country = country;
        item.productOrderedId = productId;
        orders.add(item);
    }
}
