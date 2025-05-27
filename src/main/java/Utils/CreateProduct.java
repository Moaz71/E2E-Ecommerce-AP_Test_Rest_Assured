package Utils;

import Models.RequestModels.CreateProductRequestModel;
import Models.ResponseModels.CreateProductResponseModel;
import io.restassured.RestAssured;

import java.io.File;

public class CreateProduct {

    public static CreateProductResponseModel createProduct( String token, int statusCode, CreateProductRequestModel product ) {

        /*CreateProductRequestModel createProductRequestModel = new CreateProductRequestModel();
        createProductRequestModel.productName = Constants.productName;
        createProductRequestModel.productAddedBy = userID;
        createProductRequestModel.productCategory = Constants.productCategory;
        createProductRequestModel.productSubCategory = Constants.productSubCategory;
        createProductRequestModel.productPrice = Constants.productPrice;
        createProductRequestModel.productDescription = Constants.productDescription;
        createProductRequestModel.productFor = Constants.productFor;
        createProductRequestModel.productImage = productImage;
        GeneralUtils.returnBody(createProductRequestModel);*/
        return RestAssured.given().log().all().headers(Headers.withAuthHeaders(token, "multipart/form-data"))
                .multiPart("productName", product.productName)
                .multiPart("productAddedBy", product.productAddedBy)
                .multiPart("productCategory", product.productCategory)
                .multiPart("productSubCategory", product.productSubCategory)
                .multiPart("productPrice", product.productPrice)
                .multiPart("productDescription", product.productDescription)
                .multiPart("productFor", product.productFor)
                .multiPart("productImage", product.productImage)
                .when().post(Constants.baseURL+Constants.createproductEndPoint)
                .then().log().all().statusCode(statusCode).extract().response().as(CreateProductResponseModel.class);

    }


}
