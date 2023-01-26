import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkbox {

    //create object from webdriver to use it in test cases
WebDriver driver = null ;

    // navigate and open browser
    @BeforeTest
    public void Openbrowser (){
        String ChromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",ChromePath);
        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        driver.manage().window().maximize();


    }

    // test case 1 to check if checkbox1 isenabled or not if enabled then go to check the second if isselected or not and if not click on it
    @Test
    public void Checkbox1 () throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]"));
        boolean isenabled = checkbox1.isEnabled();
        boolean isselected = checkbox1.isSelected();

        if (isenabled == true)  {

            if (isselected == false){
                checkbox1.click();

            }

        } else System.out.println("the checkbox is not enabled ") ;



        Thread.sleep(2000);


    }


    //testcase 2 to assert that checkbox to isselected
@Test
public void checkbox2 () throws InterruptedException {

    WebElement checkbox1 = driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]"));

    Assert.assertTrue(checkbox1.isSelected(),"wrong checkbox is notselected" );

    Thread.sleep(2000);

}
    //close browser
    @AfterTest
public void Closebrowser (){

      driver.quit();
    }
}
