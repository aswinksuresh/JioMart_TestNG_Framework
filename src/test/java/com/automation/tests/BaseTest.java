package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.GroceryQuickPickPage;
import com.automation.pages.Homepage;
import com.automation.pages.SearchResultPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    static Homepage homepage;
    static GroceryQuickPickPage groceryQuickPickPage;
    static CartPage cartPage;
    static SearchResultPage searchResultPage;
    @BeforeMethod
    public  static void setUp(){
        ConfigReader.initConfig();
        DriverManager.createDriver();
        homepage = new Homepage();
        groceryQuickPickPage = new GroceryQuickPickPage();
        cartPage=new CartPage();
        searchResultPage = new SearchResultPage();

    }

    @AfterMethod
    public static void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
