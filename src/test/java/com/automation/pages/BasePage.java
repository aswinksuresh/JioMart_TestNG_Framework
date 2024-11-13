package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    JavascriptExecutor js;
    public BasePage(){
        driver= DriverManager.getDriver();
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        js=(JavascriptExecutor) driver;
    }
}
