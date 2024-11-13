package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//button[@class=\"jm-btn secondary small jm-fc-black\"]//img[@class='collapse-toggle']")
    WebElement sortBtn;
    @FindBy(xpath = "//input[@id='sort_prod_mart_master_vertical_products_price_desc']/following-sibling::div")
    WebElement priceHighToLowBtn;
    @FindBy(xpath = "//span[@id='current_sort']")
    WebElement currentSort;
    @FindBy(xpath = "//div[text()='Search Results']")
    WebElement searchResultsTitle;

    public void sortFromHighToLow() {
        sortBtn.click();
        priceHighToLowBtn.click();
    }


    public String checkPriceHighToLowOptionSelected() {
        return currentSort.getText();
    }

    public boolean verifySearchResultsVisible() {
       return searchResultsTitle.isDisplayed();
    }
}
