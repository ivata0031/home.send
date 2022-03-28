package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelper;

import java.io.IOException;

public class UnsuccessfulLogin extends TestUtil {
//    private WebDriver driver;


//    @BeforeTest
//    public void initializeDriver(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }

//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

    @DataProvider(name = "UnsuccessfulLogin.csv")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/UnsuccessfulLogin.csv");
    }

    @Test (dataProvider = "UnsuccessfulLogin.csv")
    public void UnsuccessfulLoginTest(String userName, String password) {

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement LoginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        LoginBtn.click();

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));
        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }

}
