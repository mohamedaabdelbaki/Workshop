package Tests;

import Pages.Homepage;
import Pages.SortModule;
import Pages.favouritesModule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavTest extends BaseTest{
    protected favouritesModule fav;

    @Test
    public void VerifyPlaceAddedToFavourite()
    {
        fav  = new favouritesModule(driver);

        fav.openFirstHotDeal();

        fav.savePlaceName();

        fav.addToFavourite();

        fav.openFavouriteList();

        soft.assertEquals(fav.getFavouritePlaceName(),
                fav.getSavedPlaceName(),
                "Place was not added to favourites."
        );
        fav.removeFromFavourite();

        soft.assertEquals(
                fav.getFavouriteCount(), "0 stays",
                "Favourite was not removed."
        );

        soft.assertAll();
    }
}
