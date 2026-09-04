package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class basepage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public basepage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void Click(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        }
    }

    public void Write(By Locator ,String input)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
        driver.findElement(Locator).sendKeys(input);
    }

    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public  void hover(By locator)
    {
        WebElement element= driver.findElement(locator);
        Actions actions=new Actions(driver);
        actions.click(element).perform();

    }

    public void selectByIndex(By locator, int index) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(element);
        select.selectByIndex(index);
    }


    public void selectByValue(By locator, String value) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<String> getTexts(By locator) {
        List<String> texts = new ArrayList<>();

        List<WebElement> elements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        for (WebElement element : elements) {
            texts.add(element.getText());
        }

        return texts;
    }

    public void scrollToElement(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    public void jsClick(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }


    public boolean isDisplayed(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void switchToNewTab() {

        String currentWindow = driver.getWindowHandle();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void hoverAndClick(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void Hover(By locator)
    {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public String jsGetText(By locator) {
        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].innerText;", element);
    }

    public String jsGetText(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
                "return arguments[0].textContent.trim();",
                element);
    }

    public int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


}
