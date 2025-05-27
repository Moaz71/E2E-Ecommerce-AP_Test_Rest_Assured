package Utils;

import Models.ResponseModels.ViewOrderDetailsResponseClass;
import io.restassured.RestAssured;

public class ViewOrderDetails {

    public static ViewOrderDetailsResponseClass viewOrderDetails(String token, int statusCode, String orderId) {
        return RestAssured.given().log().all().headers(Headers.withAuthHeaders(token, "application/json"))
                .queryParams(QueryParams.generalQueryParams(orderId))
                .when().get(Constants.baseURL + Constants.viewOlderDetailsEndPoint)
                .then().log().all().statusCode(statusCode).extract().response().as(ViewOrderDetailsResponseClass.class);
    }
}
