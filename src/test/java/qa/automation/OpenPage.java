package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenPage extends TestUtil {

    @Test
    public void successfulLoginTest(){
        //driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement LoginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        LoginBtn.click();

        //Assert
        WebElement userAllPagesButton = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(userAllPagesButton.isDisplayed());

    }



}
