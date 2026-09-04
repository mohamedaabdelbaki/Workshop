package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class  Hooks {

    public  static WebDriver driver;
    public  static SoftAssert soft=new SoftAssert();
    @Before
    public  void setup ()
    {

        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.ikea.com/eg/en/");


    }

    @After
    public  void finish()
    {   soft.assertAll();
        driver.quit();
    }


}
