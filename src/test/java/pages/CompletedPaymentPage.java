package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Collections;

public class CompletedPaymentPage {
    protected WebDriver driver;

    //page element
    @FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
    private WebElement thanksMessage;

    //constructor
    public CompletedPaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void thanksMessage (){

        //method + Explicit wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(thanksMessage));
        Assert.assertTrue(thanksMessage.isDisplayed());
    }
}


