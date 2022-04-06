package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;
import java.io.IOException;

public class CheckoutProductsTest extends TestUtil {

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/BuyProducts.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void BuyProductsFromCart(String userName, String password, String product1, String product2){
        //Page Object Model
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage1 = new ProductsPage(driver);
        BasketPage cartPage = new BasketPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        PaymentPage checkoutOverviewPage = new PaymentPage(driver);
        CompletedPaymentPage checkoutCompletePage = new CompletedPaymentPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        productsPage.userAllPagesButton();
        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        productsPage1.Checkout();
        cartPage.Checkout();
        checkoutInformationPage.Checkout();
        checkoutOverviewPage.Checkout();
        checkoutCompletePage.thanksMessage();

    }
}