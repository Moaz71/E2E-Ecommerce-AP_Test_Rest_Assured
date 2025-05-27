import Models.RequestModels.CreateProductRequestModel;
import Models.ResponseModels.CreateProductResponseModel;
import Models.ResponseModels.LoginResponseModel;
import Utils.Constants;
import Utils.CreateProduct;
import Utils.LoginUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class CreateProductTests {

    String userID ;
    String token ;
    @BeforeClass
    public void setup(){
       LoginResponseModel loginResponseModel = LoginUtils.login(Constants.validEmail, Constants.validPassword, 200, LoginResponseModel.class);
       userID = loginResponseModel.userId;
       token = loginResponseModel.token;
    }
    @Test
    public void createProductTest(){
        CreateProductRequestModel product = new CreateProductRequestModel();
        product.productName = "Apple Vision Pro";
        product.productAddedBy = userID;
        product.productCategory = "Electronics";
        product.productSubCategory = "Smartphones";
        product.productPrice = 1500;
        product.productDescription = "Latest 5G phone";
        product.productFor = "men";
        product.productImage = new File("H:/ITI/Core courses/14-API Testing Eng.AbdAlhameed/projects/E2E-Ecommerce-API-Test-Rest-Assured/product.jpg");
        CreateProductResponseModel createProductResponseModel = CreateProduct.createProduct(token, 201,product);
        Assert.assertEquals(createProductResponseModel.message,"Product Added Successfully");
    }
}
