import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Hover {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void slider() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);
       action.contextClick()

        Thread.sleep(5000);


    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
