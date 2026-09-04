package Tests;

import Pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest {
    protected Homepage home;
    ;

    @Test
    public void VerifySearchReturnsRelatedResults() {

        home = new Homepage(driver);

        // Step 1
        home.SearchTitle("Dubai");

        // Step 2
        for (String suggestion : home.getSuggestionTexts()) {
            soft.assertTrue(suggestion.contains("Dubai"));
        }

        // Step 3
        home.calanderTitle();

        // Step 4 ,6
        home.selectGuest("4", "2", "3", "7");

        // Step 5
        soft.assertTrue(
                home.areChildAgeDropdownsVisible(),
                "Child age dropdowns are not visible."
        );
        // Step 7
        home.clickSearch();


        // Step 8
        List<String> results = home.SearchResult();

        for (String text : home.SearchResult()) {
            if (!text.contains("Dubai")) {
                System.out.println("Doesn't contain Dubai: " + text);
            }
        }

        for (String text : home.SearchResult()) {
            soft.assertTrue(text.contains("Dubai"));
        }
        soft.assertAll();

    }


    /*@Test

    public void VerifySearchFlow()
    {
        //Assert.assertTrue(resultSelected, "Search result not found: " + "dubai");

        home=new Homepage(driver);
        home.SearchTitle("Dubai");

        for (String text : home.getSuggestionTexts()) {
            Assert.assertTrue(text.contains("Dubai"));
        }

        home.calanderTitle();

        home.selectGuest("3","3","5");


        home.clickSearch();

        for (String text1 : home.SearchResult()) {
            Assert.assertTrue(text1.contains("Dubai"));
        }

        soft.assertAll();
    }*/

    /*
    @Test(priority = 1,groups = "SearchFlow")
    public void VerifySearchSuggestions() {

        home = new Homepage(driver);
        home.SearchTitle("Dubai");

        for (String text : home.getSuggestionTexts()) {
            Assert.assertTrue(text.contains("Dubai"));
        }
    }

    @Test(priority = 2, dependsOnMethods = "VerifySearchSuggestions",groups = "SearchFlow")
    public void VerifySearchResults() {

        home.calanderTitle();
        home.selectGuest("3", "3", "5");
        home.clickSearch();

        for (String text : home.SearchResult()) {
            if (!text.contains("Dubai")) {
                System.out.println("Doesn't contain Dubai: " + text);
            }
        }
        for (String text : home.SearchResult()) {
            Assert.assertTrue(text.contains("Dubai"));
        }


    }

    @Test(priority = 3,groups = "SearchFlow")
    public void VerifyPriceRange() {

        home.priceRange();

        for (String price : home.PriceResult()) {

            int value = Integer.parseInt(price.replaceAll("[^0-9]", ""));

            Assert.assertTrue(value >= 200 && value <= 300,
                    "Invalid price: " + value);
        }
    }*/
}
