package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Homepage extends BasePage{
    @FindBy(xpath = "//img[@class='banner_img animation_img']")
    WebElement homeBannerImage;
    @FindBy(xpath = "//div[text()=' Grocery Quick Picks ']")
    WebElement groceryQuickPicksTitle;
    @FindBy(xpath = "//div[text()=' Grocery Quick Picks ']/following-sibling::div/a")
    WebElement groceryQuickPicksViewAllLink;
    @FindBy(id="autocomplete-0-input")
    WebElement searchBar;

    public void openWebsite() {
        driver.get(ConfigReader.getConfig("application.url"));
    }

    public boolean verifyIsHomePageVisible() {
         return homeBannerImage.isDisplayed();
    }

    public void scrollToGroceryQuickPicks() {
        action.moveToElement(groceryQuickPicksTitle);
    }

    public void clickOnGroceryQuickPicksViewAll() {
        groceryQuickPicksViewAllLink.click();
    }


    public void searchByKeyword() {
        searchBar.sendKeys(ConfigReader.getConfig("search.product"));
        action.sendKeys(Keys.ENTER).perform();
      }
}
