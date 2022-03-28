package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ProductTests extends TestUtil {

    @Test
    public void selectDifferentOrder() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement LoginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        LoginBtn.click();

        //Explicit wait
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement dropDownSortingOptions = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        //dropDownSortingOptions.wait();
        //wait.until(ExpectedConditions.elementToBeClickable(dropDownSortingOptions));
        //dropDownSortingOptions.click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropDownSortingOptions = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownSortingOptions));//v2
        dropDownSortingOptions.click();

        //Fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));
        WebElement lowToHighPriceOption = driver.findElement(By.cssSelector("[value=lohi]"));

        fluentWait.until(ExpectedConditions.elementToBeClickable(lowToHighPriceOption));
        lowToHighPriceOption.click();
        //Thread.sleep(3000);
    }

    @Test
    public void addItemsToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
    }
}
