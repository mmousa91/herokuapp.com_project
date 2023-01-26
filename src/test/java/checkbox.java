import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {

    public static void main(String[] args) throws InterruptedException {

       String ChromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",ChromePath);
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
       // driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]")).click();

        //form[@id="checkboxes"]//input[@type="checkbox"][2]

        Thread.sleep(3000);

        driver.quit();
    }
}
