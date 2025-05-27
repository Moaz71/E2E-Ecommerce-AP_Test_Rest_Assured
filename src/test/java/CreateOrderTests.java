import Models.RequestModels.CreateProductRequestModel;
import Models.ResponseModels.CreateOrderResponseModel;
import Models.ResponseModels.CreateProductResponseModel;
import Models.ResponseModels.LoginResponseModel;
import Utils.Constants;
import Utils.CreateOrder;
import Utils.CreateProduct;
import Utils.LoginUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class CreateOrderTests {
    String userID ;
    String token ;
    String productId ;
    String country = "Egypt";
    @BeforeClass
    public void setup(){
        LoginResponseModel loginResponseModel = LoginUtils.login(Constants.validEmail, Constants.validPassword, 200, LoginResponseModel.class);
        userID = loginResponseModel.userId;
        token = loginResponseModel.token;
        CreateProductRequestModel product = new CreateProductRequestModel();
        product.productName = "Apple Vision Pro+";
        product.productAddedBy = userID;
        product.productCategory = "Electronics";
        product.productSubCategory = "Smartphones";
        product.productPrice = 1500;
        product.productDescription = "Latest 5G phone";
        product.productFor = "men";
        product.productImage = new File("H:/ITI/Core courses/14-API Testing Eng.AbdAlhameed/projects/E2E-Ecommerce-API-Test-Rest-Assured/product.jpg");
        CreateProductResponseModel createProductResponseModel = CreateProduct.createProduct(token, 201, product);
        productId = createProductResponseModel.productId;
    }

    @Test
    public void createOrderTest() {
        CreateOrderResponseModel createOrderResponseModel = CreateOrder.createOlder(token, 201, country, productId);
        Assert.assertEquals(createOrderResponseModel.message, "Order Placed Successfully");
    }
}
