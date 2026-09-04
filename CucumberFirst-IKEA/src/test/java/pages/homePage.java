package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static hooks.Hooks.driver;

public class homePage extends basepage{

    public homePage(WebDriver driver) {
        super(driver);
    }


    private final By productNameBeforeClickLocator=By.xpath("(//span[@class=\"pip-price-module__name-decorator notranslate\"])[19]");
    private final By productNameAfterClickLocator=By.xpath("//span[@class=\"pipcom-price-module__name-decorator notranslate\"]");
    private final By viewProductDetailsLocator=By.xpath("(//h3[@class=\"pip-text pip-typography-heading-xs\"])[19]");

    private final By lightningCategoryLocator=By.xpath("(//div[@class=\"hnf-carousel-slide\"])[11]");
    private final By lampLocator=By.xpath("(//div[@role=\"listitem\"])[2]");

    //private final By addBagLocator=By.xpath("(//span[@class=\"plp-typography-label-s plp-btn__inner\"])[1]");
    private final By addBagLocator = By.cssSelector("button[aria-label*='Add'][aria-label*='cart']");
    private final By bagLocator=By.xpath("//a[@data-tracking-label=\"shopping-cart\"]");
    private final By productQuantityLocator=By.xpath("//span[@class=\"cart-text cart-typography-body-m cart-text--lighter\"]");

    private final By productFavLocator=By.xpath("(//button[@type=\"button\"])[60]");
    private final By viewButtonLocator=By.xpath("//button[@class=\"hnf-btn hnf-btn--small hnf-btn--plain hnf-toast__action-message\"]");
   // private final By productName=By.xpath("//span[@class=\"fav-price-module__name-decorator notranslate\"]/h3");
    private final By removeFavLocator=By.xpath("//button[@aria-label=\"Decrease quantity\"]");
    private final By favIndicatorLocator=By.xpath("//h1[@class=\"fav-text fav-typography-heading-xl _title_1rnme_76\"]");






    public String getProductNameBeforeClick() {
        scrollToElement(productNameBeforeClickLocator);
        return getText(productNameBeforeClickLocator);
    }

    public void clickProduct() {
        Click(viewProductDetailsLocator);
    }

    public String getProductNameAfterClick() {
        return getText(productNameAfterClickLocator);
    }

    //7
    public void clickLightingCategory() {
        scrollToElement(lightningCategoryLocator);

        Click(lightningCategoryLocator);
    }

    public void clickLampCategory() {
        Click(lampLocator);
    }

    public void addProductToBag() {
        scrollToElement(addBagLocator);
        jsClick(addBagLocator);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementLocated(
                        bagLocator, "1"));
    }

    public void addProductToBag2() {
        System.out.println("Second add attempt");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addBagLocator));
        scrollToElement(addBagLocator);
        jsClick(addBagLocator);
    }



    public void openBag() {
        scrollToElement(bagLocator);
        jsClick(bagLocator);
    }

    public String getProductQuantity() {
        return getText(productQuantityLocator);
    }


    //8
    public void addToFavorites() {
        scrollToElement(productFavLocator);
        Click(productFavLocator);
    }

    public void clickViewFavorites() {
        Click(viewButtonLocator);
    }

    public String getFavoriteIndicator() {
        return getText(favIndicatorLocator);
    }

    public void removeFromFavorites() {
        Click(removeFavLocator);
    }

    public void waitUntilFavoritesAreEmpty() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(favIndicatorLocator,
                        "Favourites is empty"));
    }
}
