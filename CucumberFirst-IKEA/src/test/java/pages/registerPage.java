package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage extends basepage{
    public registerPage(WebDriver driver) {
        super(driver);
    }

    //https://www.ikea.com/eg/en/profile/sign-up/?openedBy=https%3A%2F%2Fwww.ikea.com%2Feg%2Fen%2F
    private final By firstNameLocator=By.xpath("//input[@id=\"first-name\"]");
    private final By lastNameLocator=By.xpath("//input[@id=\"last-name\"]");
    private final By emailLocator=By.xpath("//input[@id=\"email\"]");
    private final By passwordLocator=By.xpath("//input[@id=\"_r_6_\"]");
    private final By checkBoxLocator=By.xpath("//input[@name=\"checkboxname\"]");
    private final By createAccountBtnLocator=By.xpath("//button[@data-testid=\"sign-up-create-account\"]");
    private final By profileIconLocator=By.xpath("//div[@class=\"hnf-navbar__profile-link\"]");
    private final By createAccountLocator=By.xpath("//button[@data-testid=\"create-account\"]");
    private final By existingAccountErrorBtn=By.xpath("//span[@role=\"alert\"]");
    private final By welcomeHeadingLocator=By.xpath("//h1[@class=\"pp-skapa__text pp-skapa__typography-heading-m\"]");


    public void clickOnProfileIcon()
    {
        Click(profileIconLocator);
    }

    public void navigateToRegisterPage()
    {
        clickOnProfileIcon();
        Click(createAccountLocator);
    }

    public void fillInformation(String firstName, String lastName,
                                String email, String password)
    {
        Write(firstNameLocator, firstName);
        Write(lastNameLocator, lastName);
        Write(emailLocator, email);
        Write(passwordLocator, password);
    }
    public String generateRandomEmail() {
        return "test" + randomNumber(1, 1000) + "@yahoo.com";
    }

    public  void fillInformation()
    {
        int randomTestNumber=randomNumber(1, 1000);
        Write(firstNameLocator,"test");
        Write(lastNameLocator,"testm");
        Write(emailLocator,"test+"+randomTestNumber+"@yahoo.com");
        Write(passwordLocator,"FBrWwTu6ds_jL7e");

    }

    public void clickCheckBox()
    {
        jsClick(checkBoxLocator);
    }

    public void clickCreateAccount()
    {
        jsClick(createAccountBtnLocator);
    }

    public boolean isRegistrationSuccessful(String firstName) {
        return getText(welcomeHeadingLocator).contains(firstName);
    }

    public boolean isDuplicateEmailDisplayed() {
        return isDisplayed(existingAccountErrorBtn);
    }
}
