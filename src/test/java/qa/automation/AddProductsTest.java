package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;
import java.io.IOException;

public class AddProductsTest extends TestUtil {

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/AddProduct.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void AddProductIntoCart(String userName, String password, String product1, String product2, String product3) throws InterruptedException {
        //Page Object Model
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);
        productsPage.userAllPagesButton();
        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        productsPage.addItemToTheCart(product3);
        Thread.sleep(3000);
        productsPage.getItemsInTheCart();
    }
}