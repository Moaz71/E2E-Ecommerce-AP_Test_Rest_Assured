import Models.RequestModels.CreateProductRequestModel;
import Models.ResponseModels.*;
import Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class E2ETest {
    String userID ;
    String token ;
    String productId ;
    String country = "Egypt";
    String orderId;
    @Test
    public void E2ETest(){
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
        CreateOrderResponseModel createOrderResponseModel = CreateOrder.createOlder(token, 201, country, productId);
        orderId = createOrderResponseModel.orders.get(0);
        ViewOrderDetailsResponseClass viewOrderDetailsResponseClass = ViewOrderDetails.viewOrderDetails(token, 200, orderId);
        DeleteProductResponseModel deleteProductResponseModel = DeleteProduct.deleteProduct(token, 200, productId);

        Assert.assertNotNull(loginResponseModel.token);
        Assert.assertEquals(createProductResponseModel.message,"Product Added Successfully");
        Assert.assertEquals(createOrderResponseModel.message, "Order Placed Successfully");
        Assert.assertEquals(viewOrderDetailsResponseClass.message, "Orders fetched for customer Successfully");
        Assert.assertEquals(deleteProductResponseModel.message, "Product Deleted Successfully");
    }


}
