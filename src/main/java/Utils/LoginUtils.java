package Utils;

import Models.RequestModels.LoginRequestModel;
import io.restassured.RestAssured;

public class LoginUtils
{
    public static <T> T login(String email, String password, int statusCode, Class<T> responseClass) {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.email = email;
        loginRequestModel.password = password;
        return RestAssured.given().log().all().headers(Headers.standardHeaders()).body(GeneralUtils.returnBody(loginRequestModel))
                .when().post(Constants.baseURL + Constants.loginEndPoint)
                .then().log().all().statusCode(statusCode).extract().response().as(responseClass);

    }
}
