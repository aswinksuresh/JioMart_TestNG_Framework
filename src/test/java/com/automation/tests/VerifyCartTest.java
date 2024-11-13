package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCartTest extends BaseTest{
    @Test
    public void verifyCart(){
        homepage.openWebsite();
        Assert.assertTrue(homepage.verifyIsHomePageVisible());
        homepage.scrollToGroceryQuickPicks();
        homepage.clickOnGroceryQuickPicksViewAll();

        Assert.assertTrue(groceryQuickPickPage.verifyIsGroceryQuickPicksPageDisplayed());
        groceryQuickPickPage.clickOnAddToCartBtnOnFirstItem();
        Assert.assertTrue(groceryQuickPickPage.verifyIsAddedToCartMsgDisplayed());
        Assert.assertEquals(groceryQuickPickPage.verifyCartQuantityIconCount(), ConfigReader.getConfig("product.quantity"));
        groceryQuickPickPage.clickOnCartIcon();
        Assert.assertTrue(cartPage.verifyIsCartPageDisplayed());
        Assert.assertEquals(cartPage.verifyCartQuantity(),ConfigReader.getConfig("product.quantity"));
    }
}
