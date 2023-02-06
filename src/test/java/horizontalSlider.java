import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class horizontalSlider {

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
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        Actions action = new Actions(driver);
       // action.clickAndHold(driver.findElement(By.cssSelector("[type=\"range\"]"))).sendKeys(Keys.ARROW_RIGHT).release().build().perform();
        action.clickAndHold(driver.findElement(By.cssSelector("[type=\"range\"]")));
        action.moveByOffset(1,0).build().perform();

        Thread.sleep(5000);


    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
