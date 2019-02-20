package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    @Test
    public void searchByOneKeywordTest(){
        System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());

//        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);
//        driver.findElement(By.name("q")).sendKeys("vase" + Keys.ENTER);
//        driver.findElement(By.tagName("input")).sendKeys("vase" + Keys.ENTER);
//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.className("button")).click();
//
//        driver.findElement(By.linkText("WOMEN")).click();
//        driver.findElement(By.partialLinkText("OMEN")).click();

        String keyword = "vase";

         Header header = PageFactory.initElements(driver,Header.class);

       header.search(keyword);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        for (WebElement containers: productsGrid.getProductNameContainers()){
            String productName = containers.getText();

            assertThat("Some of the products names, do not contain the search keyword.", productName,containsString(keyword.toUpperCase()));
        }

        driver.quit();
    }
}
