import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class keypress {

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
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");

      //  driver.findElement(By.id("target")).click();

        Actions action = new Actions(driver);
        WebElement output = driver.findElement(By.id("result"));

        action.sendKeys(Keys.ENTER).build().perform();
        System.out.println( output.getText());
        Thread.sleep(3000);

        action.sendKeys(Keys.TAB).build().perform();
        System.out.println( output.getText());

        action.sendKeys(Keys.ESCAPE).build().perform();
        System.out.println( output.getText());

        // action.sendKeys(Keys.ENTER);
        Thread.sleep(5000);


    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
