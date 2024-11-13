package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySortProductsFromHighToLow extends BaseTest {
    @Test
    public void verifySortHighToLow(){
        homepage.openWebsite();
        Assert.assertTrue(homepage.verifyIsHomePageVisible());
        homepage.searchByKeyword();
        Assert.assertTrue(searchResultPage.verifySearchResultsVisible());
        searchResultPage.sortFromHighToLow();
       Assert.assertEquals(searchResultPage.checkPriceHighToLowOptionSelected(), ConfigReader.getConfig("sort.high.to.low"));
       //Assert.fail();
    }
}
