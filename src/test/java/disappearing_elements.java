import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class disappearing_elements {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
         driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void disappearingElement() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/disappearing_elements");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href=\"/gallery/\"]")).isDisplayed(),"element is disappearing");
    }

    @Test(priority = 2)
    public void secondassert () throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        driver.navigate().refresh();
        Thread.sleep(4000);
       soft.assertTrue(driver.findElement(By.xpath("//a[@href=\"/gallery/\"]")).isDisplayed(),"element is disappearing");
        soft.assertAll();


    }


    @AfterTest
    public void closeBrowser (){
        driver.quit();
    }
}
