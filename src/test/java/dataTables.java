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

public class dataTables {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void table1() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[1]/td[6]/a[1]")).click();

        Thread.sleep(3000);


    }


    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
