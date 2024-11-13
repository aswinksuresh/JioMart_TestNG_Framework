package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//h1[text()='My Cart']")
    WebElement myCartTitle;
    @FindBy(xpath = "//span[@class='j-text val pd--left sp--xxs j-text-body-xs ng-star-inserted']")
    WebElement cartQuantity;
    public boolean verifyIsCartPageDisplayed() {
        return myCartTitle.isDisplayed();
    }

    public String verifyCartQuantity() {
        String cartCount =cartQuantity.getText();
        cartCount=cartCount.replaceAll("[()]","");
      return cartCount;

    }
}
