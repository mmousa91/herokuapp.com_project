import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class drag_and_drop {

    WebDriver driver = null;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void contextMenu () throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(2000);

        Actions action = new Actions(driver);

       WebElement drag = driver.findElement(By.id("column-a"));

        WebElement drop = driver.findElement(By.id("column-b"));

        action.dragAndDrop(drag, drop).build().perform();

       // Action draganddrop=action.clickAndHold(drag).moveToElement(drop).release(drop).build();

       // draganddrop.perform();

        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
