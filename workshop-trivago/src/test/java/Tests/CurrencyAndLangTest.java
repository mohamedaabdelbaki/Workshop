package Tests;

import Pages.Basepage;
import Pages.Homepage;
import Pages.SortModule;
import Pages.currencyAndLanguageModule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyAndLangTest extends BaseTest {
    protected currencyAndLanguageModule  currencyAndLanguage;

    @Test
    public void VerifyCurrencyChange()
    {
        currencyAndLanguage = new currencyAndLanguageModule(driver);
        // Step 1,2,3
        currencyAndLanguage.changeCurrencyToEGP();
        // Step 4
        soft.assertTrue(currencyAndLanguage.arePricesInEGP(),
                "Not all prices are displayed in EGP.");

    }

    @Test
    public void VerifyLanguageChange()
    {
        currencyAndLanguage = new currencyAndLanguageModule(driver);
        // Step 1,2,3
        currencyAndLanguage.changeLanguageArabic();

        soft.assertTrue(
                currencyAndLanguage.getPageTitle().contains("فنادق"),
                "Home page title is not in Arabic."
        );




    }





}
