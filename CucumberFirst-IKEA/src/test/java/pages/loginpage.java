package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage extends registerPage {

    public loginpage(WebDriver driver) {
        super(driver);
    }

    //locator
    private final By emailLocator=By.xpath("//input[@id=\"login-email\"]");
    private final By passwordLocator=By.xpath("//input[@id=\"login-password\"]");

    private final By loginBtnLocator=By.xpath("//button[@data-testid=\"login\"]");
    private final By profileiconLocator=By.xpath("//div[@class=\"hnf-navbar__profile-link\"]");
    private final By nameOnProfileLocator=By.xpath("//h1[@data-testid=\"logged-in-sheet-header\"]");

    private final By errorMessageLocator=By.xpath("//div[@data-testid=\"error-message\"]/div/p");







    public  void login()
    {
        clickOnProfileIcon();

    }

    public  void information(String email,String pass)
    {
        Write(emailLocator,email);
        Write(passwordLocator,pass);

    }

    public void clickOnLoginBtn()
    {
        Click(loginBtnLocator);
    }

    public String getProfileName() {
        Click(profileiconLocator);
        return getText(nameOnProfileLocator);
    }

    public String getLoginErrorMessage() {
        return getText(errorMessageLocator);
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElement(errorMessageLocator).isDisplayed();
    }



}
