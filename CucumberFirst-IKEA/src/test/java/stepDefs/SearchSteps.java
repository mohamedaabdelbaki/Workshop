package stepDefs;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps {
    private SearchPage search;


    @When("the user searches for {string}")
    public void theUserSearchesFor(String keyword) {
        // Write code here that turns the phrase above into concrete actions
        search = new SearchPage(Hooks.driver);
        search.searchForProduct(keyword);
        search.clickSearch();
    }

    @Then("the displayed products should be related to {string}")
    public void theDisplayedProductsShouldBeRelatedTo(String keyword) {

        SoftAssert soft = new SoftAssert();

        for (String text : search.getProductNames()) {

            if (!text.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Doesn't contain " + keyword + ": " + text);
            }

            soft.assertTrue(
                    text.toLowerCase().contains(keyword.toLowerCase()),
                    "Product does not contain '" + keyword + "': " + text);
        }

        soft.assertAll();
    }

    @And("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        search.clickSearch();
    }

    @And("the user opens the filter")
    public void theUserOpensTheFilter() {
        search.openFilter();
    }


    @And("the user selects Price Low to High")
    public void theUserSelectsPriceLowToHigh() {
        search.selectPriceLowToHigh();
    }



    @Then("the products should be sorted from low to high")
    public void theProductsShouldBeSortedFromLowToHigh() {

        List<Integer> prices = search.getProductPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue(
                    prices.get(i) <= prices.get(i + 1),
                    "Prices are not sorted. " + prices.get(i) + " is greater than " + prices.get(i + 1)
            );
        }
    }
}
