package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class currencyAndLanguageModule extends Basepage {
    public currencyAndLanguageModule(WebDriver driver) {
        super(driver);
    }
    private final By languageBtnLocator=By.xpath("//button[@data-testid=\"header-localization-menu\"]");
    private final By CurrencyOptionLocator=By.xpath("//select[@data-testid=\"localization-currency-select\"]");
    private final By applyCurrencyBtnLocator=By.xpath("//button[@class=\"VHolYY tjDLq2 e4r_YY\"]");
    private final By EgySignLocators=By.xpath("//div[@data-testid=\"recommended-price\"]");


    //language locators
    private final By LanguageLocator=By.xpath("//select[@data-testid=\"localization-language-select\"]");


    public void changeCurrencyToEGP()
    {
        Click(languageBtnLocator);

        selectByValue(CurrencyOptionLocator,"EGP");
        Click(applyCurrencyBtnLocator);
    }

    public boolean arePricesInEGP()
    {
        for (String price : getTexts(EgySignLocators))
        {
            if (!price.contains("EGP"))
            {
                return false;
            }
        }
        return true;
    }

    public void changeLanguageArabic()
    {
        Click(languageBtnLocator);
        selectByValue(LanguageLocator,"ar-145");
        Click(applyCurrencyBtnLocator);
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }


}
