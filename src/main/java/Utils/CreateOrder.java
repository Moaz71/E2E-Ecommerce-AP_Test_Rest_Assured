package Utils;

import Models.RequestModels.CreateOrderRequestModel;
import Models.ResponseModels.CreateOrderResponseModel;
import io.restassured.RestAssured;

public class CreateOrder {
    public static CreateOrderResponseModel createOlder(String token, int statusCode, String country, String productId) {
        CreateOrderRequestModel createOrderRequestModel = new CreateOrderRequestModel();
        createOrderRequestModel.addOrderItem(country,productId);
        return RestAssured.given().log().all().headers(Headers.withAuthHeaders(token,"application/json"))
                .body(GeneralUtils.returnBody(createOrderRequestModel))
                .when().post(Constants.baseURL+Constants.createOlderEndPoint)
                .then().log().all().statusCode(statusCode).extract().response().as(CreateOrderResponseModel.class);

    }
}
