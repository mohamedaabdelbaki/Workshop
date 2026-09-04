package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class favouritesModule extends Basepage {
    public favouritesModule(WebDriver driver) {
        super(driver);
    }

    private String savedPlaceName1;

    private final By HotDealsSectionLocator=By.xpath("//h2[@data-testid=\"popular-destinations-deals-carousel-heading\"]");
    private final By firstDealLocator=By.xpath("(//button[@class=\"ehv1KY tjDLq2 e4r_YY IKMUBE\"])[1]");
    private final By placeNameLocator=By.xpath("(//a[@data-testid=\"item-name-link\"])[1]");
    private final By favBTnLocator=By.xpath("(//div[@data-testid=\"tooltip-wrapper\"])[1]");
    private final By menuBtnLocator=By.xpath("//button[@data-testid=\"header-profile-menu-desktop\"]");
    private final By favOptionLocator=By.xpath("//a[@data-testid=\"profile-menu-favorites\"]");
    private final By nextStayLocator=By.xpath("//img[@data-testid=\"favorite-list-item-element-image\"]");
    private final By itemInFavLocator=By.xpath("//h3[@class=\"tODn3R _5NF9ws XRetcy SwVR4I\"]");
    private final By favIconRemoverLocator=By.xpath("//div[@data-testid=\"tooltip-children-wrapper\"]");
    private final By favCountLocator=By.xpath("//p[@data-testid=\"favorites-page-items-count\"]");


    public void openFirstHotDeal()
    {
        scrollToElement(firstDealLocator);
        jsClick(firstDealLocator);
    }

    public void savePlaceName()
    {
        savedPlaceName1 = jsGetText(placeNameLocator);
    }

    public void addToFavourite()
    {
        Click(favBTnLocator);
    }

    public void openFavouriteList()
    {
        jsClick(menuBtnLocator);
        jsClick(favOptionLocator);
        jsClick(nextStayLocator);
    }

    public String getSavedPlaceName()
    {
        return savedPlaceName1;
    }

    public String getFavouritePlaceName()
    {
        return jsGetText(itemInFavLocator);
    }

    public void removeFromFavourite() {
        Click(favIconRemoverLocator);
    }

    public String getFavouriteCount() {
        return getText(favCountLocator);
    }

}