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

public class dynamic_controls {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void checkBox () {
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"swapCheckbox()\"]")).click();


        //WebDriver has a class that's called WebDriverWait
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//When click the “remove” button, we see that the loading icon is here and before we move on,
// we need to wait until it's gone
        // this method called invisibilityOf from expected conditions class
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));


        String actualResult =driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualResult,"It's gone!");


    }

    @Test
    public void enable_disable () {
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("button[onclick=\"swapInput()\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

        driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("hala");

        String actualResult =driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualResult,"It's enabled!");


    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
