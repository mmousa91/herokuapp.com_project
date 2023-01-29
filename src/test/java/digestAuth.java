import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class digestAuth {

    WebDriver driver = null;
    String userName;
    String password;
    String domain;
    String url;

    @BeforeTest
    public void openBrowser (){

        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        userName = "admin";
        password = "admin";
        domain = "the-internet.herokuapp.com/basic_auth";

    }

    @Test
    public void contextMenu () throws InterruptedException {
    url = "https://"+ userName +":"+ password +"@"+domain;
    driver.get(url);

    String actualResult = driver.findElement(By.cssSelector("div[class=\"example\"]>p")).getText();

        //String actualResult = driver.findElement(By.cssSelector("div.example p")).getText();
        Thread.sleep(3000);

        Assert.assertTrue(actualResult.contains("Congratulations! You must have the proper credentials."));



    }

    @AfterTest
    public void closeBrowser (){

        driver.quit();
    }
}
