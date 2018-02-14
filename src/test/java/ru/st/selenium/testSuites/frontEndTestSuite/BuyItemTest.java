package ru.st.selenium.testSuites.frontEndTestSuite;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;

import java.io.IOException;

public class BuyItemTest extends ru.st.selenium.pages.TestBase {
    public static final Logger log = Logger.getLogger(ForgotPasswordTest.class.getName());

    @Test
    public void buyItemTest() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = TESTUSER;
        User paypalUser = PAYPALUSER;
        app.getPages().internalPage.setLanguage("rus");
        app.getUserHelper().loginAs(user);
        app.getShopHelper().buyItemOnShopPage("Product 2");
        app.getShopHelper().buyItemOnShopPage("Product 1");
        app.getShopHelper().checkItemInCart("Product 2");
        app.getShopHelper().checkItemInCart("Product 1");
        app.getShopHelper().buyItemsInCart(paypalUser);
        //TODO make purchase with paypal
        //app.getShopHelper().removeItemFromCart("Product 2");
        //app.getShopHelper().removeItemFromCart("Product 1");
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
