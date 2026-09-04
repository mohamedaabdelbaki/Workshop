package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SortModule extends Homepage{
    public SortModule(WebDriver driver) {
        super(driver);
    }


    private final By SortLocator=By.xpath("(//div[@data-testid=\"refinement_row_element\"])[2]");
    private final By PriceAscendingLocator=By.xpath("//input[@data-testid=\"sorting-index-1\"]");
    private final By applyButton=By.xpath("//button[@data-testid=\"filters-popover-apply-button\"]");
    private final By expectedPriceLocator=By.xpath("//div[@data-testid=\"expected-price\"]");




    public void SortBy()
    {
        Click(SortLocator);
        Click(PriceAscendingLocator);
        Click(applyButton);

    }
    public boolean arePricesSortedAscending() {

        List<WebElement> prices = driver.findElements(expectedPriceLocator);

        int previous = 0;

        for (WebElement price : prices) {

            int current = Integer.parseInt(price.getText().replaceAll("[^0-9]", ""));

            if (current < previous) {
                return false;
            }

            previous = current;
        }

        return true;
    }
}
