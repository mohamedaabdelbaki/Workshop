package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PriceModule extends Homepage{

    public PriceModule(WebDriver driver) {
        super(driver);
    }
    private final By PriceLocator=By.xpath("(//div[@data-testid=\"refinement_row_element\"])[3]");
    private final By MinPriceLocator=By.xpath("//input[@data-testid=\"price-filter-value-min\"]");
    private final By MaxPriceLocator=By.xpath("//input[@data-testid=\"price-filter-value-max\"]");
    private final By PriceApplyBtnLocator=By.xpath("//button[@data-testid=\"filters-popover-apply-button\"]");
    private final By ExpectedPriceRangeLocator=By.xpath("//div[@data-testid=\"expected-price\"]");
    private final By RecommendedPriceRangeLocator=By.xpath("//div[@data-testid=\"recommended-price\"]");



    public void PriceFilter()
    {
        Click(PriceLocator);
        Write(MinPriceLocator,"200");
        Write(MaxPriceLocator,"300");
        WebElement oldPrice = driver.findElement(RecommendedPriceRangeLocator);
        Click(PriceApplyBtnLocator);
        wait.until(ExpectedConditions.stalenessOf(oldPrice));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                RecommendedPriceRangeLocator, 0));
    }
    public boolean arePricesWithinRange(int min, int max) {


        List<String> prices = getTexts(RecommendedPriceRangeLocator);

        for (String price : prices) {

            int value = Integer.parseInt(price.replaceAll("[^0-9]", ""));

            if (value < min || value > max) {
                return false;
            }
        }

        return true;
    }


}
