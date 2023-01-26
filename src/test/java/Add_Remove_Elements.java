import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Add_Remove_Elements {

    //create object from webdriver to use it in test cases

    WebDriver driver = null;

    // navigate and open browser

    @BeforeTest
    public void openbrowser ()  {

       String chromepath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();

    }
// test add element  button and delete button
    @Test
    public void addElement() throws InterruptedException {

    //click on add element button
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();

        Thread.sleep(3000);
    //click on delete button
        driver.findElement(By.cssSelector("button[onclick=\"deleteElement()\"]")).click();

        Thread.sleep(3000);


    }
// close browser
    @AfterTest
    public void closebrowser(){

        driver.quit();
    }
}
