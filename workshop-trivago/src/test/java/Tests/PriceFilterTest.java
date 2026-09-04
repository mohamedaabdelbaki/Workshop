package Tests;

import Pages.PriceModule;
import Pages.SortModule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceFilterTest extends BaseTest{
    protected PriceModule Price;


    @Test
    public void VerifyPriceFunctionality()
    {
        Price = new PriceModule(driver);
        // Step 1
        Price.SearchTitle("Dubai");
        // Step 2
        Price.calanderTitle();
        // Step 3
        Price.clickSearch();
        // Step 4,6 couldn't apply step 5 as Select for total stay does not appear
        Price.PriceFilter();
        //Step 7
        soft.assertTrue(
                Price.arePricesWithinRange(200, 300),
                "Some results are outside the selected price range."
        );



    }
}
