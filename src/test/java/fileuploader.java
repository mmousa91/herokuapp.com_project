import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class fileuploader {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void uploadFile() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\moham\\Downloads\\screenshotselenium.png");
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(4000);

    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
