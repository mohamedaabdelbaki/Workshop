package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends basepage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchLocator=By.xpath("//input[@id=\"ikea-search-input\"]");
    private final By searchBtnLocator=By.xpath("//button[@type='submit']");
    private final By itemsLocator=By.xpath("//span[@class=\"plp-text plp-typography-label-m plp-typography-regular plp-price-module__description\"]");

    private final By filterLocator=By.xpath("//span[@id=\"SEC_sort_title\"]");
    private final By priceLowToHighLocator = By.xpath("//input[@id='plp-PRICE_LOW_TO_HIGH']");
    private final By viewBtnLocator=By.xpath("//button[@class=\"plp-btn plp-btn--primary\"]");
    private final By priceLocator=By.xpath("//span[contains(@class,'plp-price-module__current-price')]//span[@class='plp-price__sr-text']");


    public void searchForProduct(String keyword) {
        Write(searchLocator, keyword);
    }

    public void clickSearch() {
        Click(searchBtnLocator);
    }

    public List<String> getProductNames() {
        return getTexts(itemsLocator);
    }

    public boolean areResultsRelatedTo(String keyword) {

        List<String> products = getProductNames();

        for (String product : products) {
            if (!product.toLowerCase().contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

//--------------
    public void openFilter() {
        Click(filterLocator);
    }



    public void selectPriceLowToHigh() {
        jsClick(priceLowToHighLocator);
    }

    public void clickView() {
        Click(viewBtnLocator);
    }

    public List<Integer> getProductPrices() {

        List<Integer> priceList = new ArrayList<>();

        for (WebElement price : driver.findElements(priceLocator).subList(0, Math.min(10, driver.findElements(priceLocator).size()))) {
            priceList.add(Integer.parseInt(price.getText().replaceAll("[^0-9]", "")));
        }

        return priceList;
    }
}



