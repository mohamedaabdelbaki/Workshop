package Tests;

import Pages.HotDealsPage;
import Pages.SortModule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotDeals extends BaseTest {
    protected HotDealsPage HotDeals;

    @Test
    public void VerifyOfferCardDetailsAreMatchedWithOfferDetailsInsidePage()
    {
        HotDeals = new HotDealsPage(driver);
        // Step 1
        HotDeals.ViewHotDeals();
        // Step 2
        HotDeals.ScrolToHurghada();
        //Step 3
        HotDeals.saveNameAndClick();
        soft.assertEquals(
                HotDeals.getHotelNameAfterClick(),
                HotDeals.getSavedName(),
                "Wrong hotel was opened.");

        soft.assertEquals(
                HotDeals.getHotelPriceAfterClick(),
                HotDeals.getSavedPrice(),
                "Price does not match.");

        HotDeals.clickViewDetail();

        String url = HotDeals.getCurrentUrl();

        System.out.println("Opened URL: " + url);

        soft.assertTrue(
                url.contains(HotDeals.getCompanyName()),
                "URL does not contain company name."
        );


        soft.assertAll();

    }
}
