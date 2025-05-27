import Models.RequestModels.CreateProductRequestModel;
import Models.ResponseModels.LoginInvalidResponse;
import Models.ResponseModels.LoginResponseModel;
import groovyjarjarantlr4.v4.misc.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.LoginUtils;
import Utils.Constants;
import Utils.CreateProduct;

import java.io.File;

public class LoginTests {


    @Test
    public void validLoginTest() {
        LoginResponseModel loginResponseModel = LoginUtils
                .login(Constants.validEmail, Constants.validPassword, 200, LoginResponseModel.class);
        Assert.assertNotNull(loginResponseModel.token);
    }

    @Test
    public void invalidLoginTest(){
        LoginInvalidResponse loginInvalidResponse = LoginUtils
                .login(Constants.invalidEmail, Constants.validPassword, 400, LoginInvalidResponse.class);
        Assert.assertEquals(loginInvalidResponse.message,"Incorrect email or password.");
    }

    @Test
    public void invalidLoginTest1(){
        LoginResponseModel loginInvalidResponse = LoginUtils
                .login(Constants.invalidEmail, Constants.validPassword, 400, LoginResponseModel.class);
        Assert.assertEquals(loginInvalidResponse.message,"Incorrect email or password.");
    }



}
