package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotDealsPage extends Homepage{
    public HotDealsPage(WebDriver driver) {
        super(driver);
    }



    private String savedName;
    private String savedPrice;
    private String companyName;

    private final By HotDealsLocator=By.xpath("(//a[@data-testid=\"explore-more-link\"])[1]");
    private final By HurghadaLocator=By.xpath("(//a[@data-testid=\"popular-city\"])[1]");
    private final By FirstCardLocator = By.xpath("(//div[@data-testid='deal-item-card-details'])[1]");

    private final By NameInsideCardLocator = By.xpath(".//span[contains(@data-testid,'accommodation-name')]");

    private final By PriceInsideCardLocator = By.xpath(".//div[@data-testid='recommended-price']");
    private final By ShowDetailsLocator=By.xpath("(//button[@aria-label='View'])[1]");

    private final By PriceAfterLocator=By.xpath("(//div[@data-testid=\"recommended-price\"])[1]");
    private final By NameAfterLocator=By.xpath("(//a[@data-testid=\"item-name-link\"])[1]");

    private final By companyNameLocator=By.xpath("(//span[@data-testid=\"advertiser-name\"])[1]");

    private final By viewDetailButton=By.xpath("(//button[@data-testid=\"champion-deal\"])[2]");






    public void ViewHotDeals()
    {
        scrollToElement(HotDealsLocator);
        Click(HotDealsLocator);
        switchToNewTab();

    }

    public void ScrolToHurghada()
    {
        scrollToElement(HurghadaLocator);
        Click(HurghadaLocator);

    }

    public void saveNameAndClick() {

        WebElement firstCard = driver.findElement(FirstCardLocator);

        savedName = jsGetText(firstCard.findElement(NameInsideCardLocator));
        savedPrice = jsGetText(firstCard.findElement(PriceInsideCardLocator));

       jsClick(ShowDetailsLocator);
        switchToLatestTab();
    }

    public String getSavedName() {

        return savedName;
    }

    public String getSavedPrice() {
        return savedPrice;
    }


    public String getHotelNameAfterClick() {
        return jsGetText(NameAfterLocator);
    }

    public String getHotelPriceAfterClick() {
        return jsGetText(PriceAfterLocator);
    }
    public String getCompanyName() {
        companyName = jsGetText(companyNameLocator);
        return companyName;
    }

    public void clickViewDetail() {

        jsClick(viewDetailButton);
        switchToLatestTab();

    }

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }




    public void switchToLatestTab() {

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }






}



