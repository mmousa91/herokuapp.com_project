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
       WebElement Slider = driver.findElement(By.cssSelector("[type=\"range\"]"));

       WebElement outPut = driver.findElement(By.id("range"));

        action.dragAndDropBy(Slider,10,0).release().perform();

        System.out.println("the output after drag to right is : "+outPut.getText());

        Thread.sleep(5000);


    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
