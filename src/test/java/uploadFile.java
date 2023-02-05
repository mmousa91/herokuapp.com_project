import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class uploadFile {

    WebDriver driver = null;

    @BeforeTest
    public void fileUpload (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void exit_Intent () throws InterruptedException, AWTException {
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload")).click();


        driver.findElement(By.id("file-submit")).click();




    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
