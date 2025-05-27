package Utils;

import Models.ResponseModels.DeleteProductResponseModel;
import io.restassured.RestAssured;

public class DeleteProduct {

    public static DeleteProductResponseModel deleteProduct(String token, int statusCode, String productId) {
        return RestAssured.given().log().all().headers(Headers.withAuthHeaders(token, "application/json"))
                .when().delete(Constants.baseURL+Constants.deleteproductEndPoint+"/"+productId)
                .then().log().all().statusCode(statusCode).extract().response().as(DeleteProductResponseModel.class);
    }
}
