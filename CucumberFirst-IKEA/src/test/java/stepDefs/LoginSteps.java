package stepDefs;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.loginpage;

public class LoginSteps {
    private loginpage login;


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        login = new loginpage(Hooks.driver);
        login.login();

    }

    @When("the user enters the previously registered email and valid password")
    public void theUserEntersThePreviouslyRegisteredEmailAndValidPassword() {
        // Write code here that turns the phrase above into concrete actions
        login.information(RegisterSteps.existingEmail, RegisterSteps.password);
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        // Write code here that turns the phrase above into concrete actions
      login.clickOnLoginBtn();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(login.getProfileName().contains(RegisterSteps.name));
    }

    @When("the user enters a valid email and an invalid password")
    public void theUserEntersAValidEmailAndAnInvalidPassword() {
        // Write code here that turns the phrase above into concrete actions
        login.information(RegisterSteps.existingEmail, "test1");
    }

    @Then("a login error message should be displayed")
    public void aLoginErrorMessageShouldBeDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(login.isLoginErrorDisplayed());
    }
}
