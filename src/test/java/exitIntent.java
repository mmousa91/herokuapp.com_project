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

public class exitIntent {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void exit_Intent () throws InterruptedException, AWTException {
       driver.navigate().to("https://the-internet.herokuapp.com/exit_intent");


        Actions action = new Actions(driver);
        action.moveByOffset(600,0).build().perform();
        Robot robot = new Robot();
        robot.mouseMove(600,0);


        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
