import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdown_list {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void dropDown () throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);
        //Declare the drop-down element as an instance of the Select class
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        //now start controlling “drop-down” by using Select-by-visible-text method to select dropdown option 1
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000);

        dropdown.selectByVisibleText("Option 2");
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
