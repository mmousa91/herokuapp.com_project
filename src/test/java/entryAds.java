import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class entryAds {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }



    @Test
    public void entryAds () {
        driver.navigate().to("https://the-internet.herokuapp.com/entry_ad");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("modal"))));

        Assert.assertTrue(driver.findElement(By.className("modal")).isDisplayed());

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
       /* driver.findElement(By.cssSelector("button[onclick=\"swapInput()\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

        driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("hala");

        String actualResult =driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualResult,"It's enabled!");*/


    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
