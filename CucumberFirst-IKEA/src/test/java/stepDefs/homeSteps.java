package stepDefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.homePage;

import static hooks.Hooks.driver;

public class homeSteps {

    private homePage home;
    private String productNameBefore;

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        home = new homePage(driver);
    }

    @When("the user stores the selected product name")
    public void theUserStoresTheSelectedProductName() {
        productNameBefore = home.getProductNameBeforeClick();
    }

    @When("the user clicks on the selected product")
    public void theUserClicksOnTheSelectedProduct() {
        home.clickProduct();
    }

    @Then("the product name should match the selected product")
    public void theProductNameShouldMatchTheSelectedProduct() {

        String productNameAfter = home.getProductNameAfterClick();
        System.out.println("Before: " + productNameBefore);
        System.out.println("After : " + productNameAfter);

        Assert.assertTrue(
                productNameAfter.contains(productNameBefore),
                "The product displayed on the details page does not match the selected product."
        );
    }


    @When("the user clicks on the Lighting category")
    public void theUserClicksOnTheLightingCategory() {
        // Write code here that turns the phrase above into concrete actions
        home.clickLightingCategory();
    }

    @And("the user opens the Lamps category")
    public void theUserOpensTheLampsCategory() {
        // Write code here that turns the phrase above into concrete actions
        home.clickLampCategory();
    }

    @And("the user adds the product to the bag")
    public void theUserAddsTheProductToTheBag() {
        // Write code here that turns the phrase above into concrete actions
        home.addProductToBag();
    }

    @And("the user adds the same product to the bag again")
    public void theUserAddsTheSameProductToTheBagAgain() {
        // Write code here that turns the phrase above into concrete actions


        driver.navigate().refresh();
        home.addProductToBag2();

    }

    @And("the user opens the shopping bag")
    public void theUserOpensTheShoppingBag() {
        // Write code here that turns the phrase above into concrete actions
        home.openBag();
    }

    @Then("the quantity displayed in the bag should be {int}")
    public void theQuantityDisplayedInTheBagShouldBe(int arg0) {

        String actualQuantity = home.getProductQuantity();

        Assert.assertTrue(
                actualQuantity.contains(String.valueOf(arg0)),
                "Expected quantity: " + arg0 + " but found: " + actualQuantity
        );
    }

    //8

    @When("the user adds a product to favorites")
    public void theUserAddsAProductToFavorites() {
        // Write code here that turns the phrase above into concrete actions
        home.addToFavorites();
    }

    @And("the user opens the favorites page")
    public void theUserOpensTheFavoritesPage() {
        // Write code here that turns the phrase above into concrete actions
        home.clickViewFavorites();
    }

    @Then("the favorites page should contain products")
    public void theFavoritesPageShouldContainProducts() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(home.getFavoriteIndicator().contains("Favourites"),
                "Product was not added to favourites.");
    }

    @When("the user removes the product from favorites")
    public void theUserRemovesTheProductFromFavorites() {
        // Write code here that turns the phrase above into concrete actions
        home.removeFromFavorites();
    }

    @Then("the favorites page should be empty")
    public void theFavoritesPageShouldBeEmpty() {
        // Write code here that turns the phrase above into concrete actions
        home.waitUntilFavoritesAreEmpty();
        Assert.assertTrue(home.getFavoriteIndicator().contains("Favourites is empty"),
                "Favourite was not removed."
        );
    }
}