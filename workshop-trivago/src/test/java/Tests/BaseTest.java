package Tests;

import Utilites.ExtendManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert soft;
    protected static ExtentReports extent;

    protected ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = ExtendManager.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {

        soft = new SoftAssert();
        test = extent.createTest(method.getName());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://ar.trivago.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        try {
            soft.assertAll();
        } catch (AssertionError e) {
            result.setStatus(ITestResult.FAILURE);
            throw e;
        } finally {

            if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                test.fail(result.getThrowable());
            } else {
                test.skip("Test Skipped");
            }

            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}