import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class opennewWindow {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void newWindow() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.linkText("Click Here")).click();
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

Thread.sleep(3000);
      //  driver.switchTo().newWindow(WindowType.WINDOW);
       // System.out.println("the new window name is : " + driver.getTitle());
      //  driver.close();


       // Thread.sleep(3000);



    }



    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
