package stepDefs;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.registerPage;
import pages.registerPage;

public class RegisterSteps {

    private registerPage register;
    public static String existingEmail = "yourregisteredemail@yahoo.com";


    public static String registeredEmail;
    public static final String password = "FBrWwTu6ds_jL7e";
    public static final String name = "Test";


    @Given("the user is on the IKEA home page")
    public void userIsOnHomePage() {
        // Hooks already opens the website
         register = new registerPage(Hooks.driver);
    }

    @When("the user navigates to the Create Account page")
    public void navigateToCreateAccount() {
        register.navigateToRegisterPage();
    }

    @When("the user enters valid registration details")
    public void enterDetails() {
        String registeredEmail = register.generateRandomEmail();
        register.fillInformation("Test", "User", registeredEmail, password);
    }

    @When("the user accepts the terms")
    public void acceptTerms() {
        register.clickCheckBox();
    }

    @When("the user clicks the Create Account button")
    public void clickCreateAccount() {
        register.clickCreateAccount();
    }

    @Then("the account should be created successfully")
    public void verifyRegistration() {
        Assert.assertTrue(register.isRegistrationSuccessful("Test"));
    }

    @And("the user enters an existing email")
    public void theUserEntersAnExistingEmail() {
        // Write code here that turns the phrase above into concrete actions
        register.fillInformation("Test", "User", existingEmail, password);

    }

    @Then("an email already exists error should be displayed")
    public void anEmailAlreadyExistsErrorShouldBeDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(register.isDuplicateEmailDisplayed());

    }
}