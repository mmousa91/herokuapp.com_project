import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class frames {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void iframe() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("hello");

        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        Thread.sleep(3000);



    }

    @Test
    public void nestedFrame() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        Thread.sleep(4000);

        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.cssSelector("[name=\"frame-top\"]")));

        driver.switchTo().frame(driver.findElement(By.cssSelector("[name=\"frame-left\"]")));

Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) driver ;

        String currentFrame = (String) js.executeScript("return self.name");

        System.out.println("the current frame name is : " + currentFrame);






    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
