package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CsvHelper;

import java.io.IOException;

public class UnsuccessfulLoginTest extends TestUtil {

    @DataProvider(name = "UnsuccessfulLogin.csv")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/UnsuccessfulLogin.csv");
    }

    @Test (dataProvider = "UnsuccessfulLogin.csv")
    public void UnsuccessfulLoginTest(String userName, String password) {

        //Page Object model
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        loginPage.errorLoginLabel();
    }

}
