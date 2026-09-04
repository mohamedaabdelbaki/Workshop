package Pages;

import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends Basepage {


    public Homepage(WebDriver driver) {
        super(driver);
    }

    //locator

    private final By searchTitleLocator=By.xpath("//input[@data-testid=\"search-form-input\"]");
    private final By suggestedLocator=By.xpath("//span[@data-testid=\"suggestion-title\"]");
    //private  By searchElementsLocator=By.xpath("(//span[@data-testid=\"suggestion-title\"])[2]");
    private final By calanderTitleLocator=By.xpath("//button[@data-testid=\"search-form-calendar\"]");
    private final By selectdate=By.xpath("//label[@data-testid=\"tomorrowNight-index-label\"]");

    private final By selectGuest=By.cssSelector("span[data-testid='search-form-guest-selector-value']");
    private final By adultLocator=By.xpath("//input[@data-testid=\"adults-amount\"]");
    private final By childrenLocator=By.xpath("//input[@data-testid=\"children-amount\"]");

    private final By increaseChildrenBtn=By.xpath("//button[@data-testid=\"children-amount-plus-button\"]");


    private final By roomLocator=By.xpath("//input[@data-testid=\"rooms-amount\"]");


    private final By childOneAgeLocator=By.xpath("(//select[@data-testid=\"child-age-select\"])[1]");
    private final By childTwoAgeLocator=By.xpath("(//select[@data-testid=\"child-age-select\"])[2]");


    private final By applyBTN=By.xpath("//button[@data-testid=\"guest-selector-apply\"]");
    private final By buttonSearch=By.xpath("//button[@data-testid=\"search-button-with-loader\"]");

    private final By searchResultLocator=By.xpath("//a[@data-testid=\"item-name-link\"]");
    private final By calanderTitle2=By.xpath("//span[@data-testid=\"search-form-calendar-value\"]");

    private final By Price=By.xpath("//button[@name='budget-filter']");
    private final By minPriceLocator=By.xpath("//input[@data-testid=\"price-filter-value-min\"]");
    private final By maxPriceLocator=By.xpath("//input[@data-testid=\"price-filter-value-max\"]");
    private final By PriceapplyLocator=By.xpath("//button[@data-testid=\"filters-popover-apply-button\"]");
    private final By PriceLocator=By.xpath("//div[@data-testid=\"recommended-price\"]");




    public void  SearchTitle(String input)
    {
        Write(searchTitleLocator,input);

    }


    public List<String> getSuggestionTexts() {
        return getTexts(suggestedLocator);
    }



    public  void calanderTitle()
    {
        Click(calanderTitleLocator);
        Click(selectdate);
    }


    public void selectGuest(String adult,String rooms,String childOneAge,String childTwoAge)
    {

        Write(adultLocator,adult);
        Click(increaseChildrenBtn);
        Click(increaseChildrenBtn);
        //Write(childrenLocator,children);
         Write(roomLocator,rooms);
        selectByValue(childOneAgeLocator,childOneAge);
        selectByValue(childTwoAgeLocator,childTwoAge);
        jsClick(applyBTN);


    }



    public  void clickSearch()
    {
        jsClick(buttonSearch);
    }

    public List<String> SearchResult() {

        return getTexts(searchResultLocator);
    }


    public boolean areChildAgeDropdownsVisible() {
        return isDisplayed(childOneAgeLocator)
                && isDisplayed(childTwoAgeLocator);
    }

    public void  priceRange()
    {
        Click(calanderTitle2);
        Click(Price);
        Write(minPriceLocator,"200");
        Write(maxPriceLocator,"300");

        Click(PriceapplyLocator);
    }

    public List<String> PriceResult() {


        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(PriceLocator, 10));

        return getTexts(PriceLocator);
    }



}