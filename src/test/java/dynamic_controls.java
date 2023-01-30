import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dynamic_controls {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void enable_disable () {
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");
        //driver.findElement(By.cssSelector("button[onclick=\"swapCheckbox()\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[onclick=\"swapCheckbox()\"]"))));
       // driver.findElement(By.cssSelector("input[type=\"text\"]")).click();




    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
