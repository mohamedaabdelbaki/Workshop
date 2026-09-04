package Tests;

import Pages.Homepage;
import Pages.SortModule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest{
    protected SortModule Sort;



    @Test
    public void VerifySortFunctionality()
    {
        Sort = new SortModule(driver);
        // Step 1
        Sort.SearchTitle("Cairo");
        // Step 2
        Sort.calanderTitle();
        // Step 3
        Sort.clickSearch();
        // Step 4
        Sort.SortBy();
        //Step5
        Sort.arePricesSortedAscending();
        //Step6
        Assert.assertTrue(
                Sort.arePricesSortedAscending(),
                "Returned results are not sorted in ascending order."
        );
    }
}
