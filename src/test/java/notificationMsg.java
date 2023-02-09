import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class notificationMsg {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void notiMsg() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/notification_message_rendered");

     //   driver.findElement(By.linkText("Click here")).click();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

      //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("flash"))));

       // Thread.sleep(3000);

    //   String msg = driver.findElement(By.id("flash")).getText();

     //  System.out.println("the msg is : " + msg);



for (int i =0 ;i<2; i++) {
    driver.findElement(By.linkText("Click here")).click();

    Thread.sleep(3000);
    String msg2 = driver.findElement(By.id("flash")).getText();

    System.out.println("the msg is : " + msg2);

}
Thread.sleep(3000);
    }



    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
