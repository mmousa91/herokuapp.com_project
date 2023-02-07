import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;

public class deepNested {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void scrollDown() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/large");
      WebElement tableElement=  driver.findElement(By.id("sibling-3.1"));

        JavascriptExecutor js = (JavascriptExecutor) driver ;

        js.executeScript ("arguments[0].scrollIntoView();",tableElement);
        Thread.sleep(3000);

       

        Thread.sleep(4000);



    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
