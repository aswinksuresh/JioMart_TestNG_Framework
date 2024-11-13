package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.beans.Visibility;

public class GroceryQuickPickPage extends BasePage {
    @FindBy(xpath = "//div[text()='Top Deals']")
    WebElement topDealsHeading;
    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement addToCartBtn;
    @FindBy(className = "jm-toast-content-message")
    WebElement addedToCartMsg;
    @FindBy(xpath = "//div[@class='header-main-user-cart-count counter-number']")
    WebElement cartIconQuantityCount;
    @FindBy(id = "btn_minicart")
    WebElement cartIcon;
    @FindBy(id="//button[@id='minicart_proceed']")
    WebElement proceedToCartBtn;
    public boolean verifyIsGroceryQuickPicksPageDisplayed() {
        return topDealsHeading.isDisplayed();
    }

    public void clickOnAddToCartBtnOnFirstItem() {
        addToCartBtn.click();
    }

    public boolean verifyIsAddedToCartMsgDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(addedToCartMsg));
        return addedToCartMsg.isDisplayed();
    }

    public String verifyCartQuantityIconCount() {
        return cartIconQuantityCount.getText();
    }

    public void clickOnCartIcon() {
        js.executeScript("arguments[0].click();",cartIcon);
    }
}
