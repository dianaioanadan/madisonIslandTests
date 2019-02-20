package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);
        List<WebElement> productNameContainers = driver.findElements(By.cssSelector(".product-name >a"));

        for (WebElement containers: productNameContainers){
            String productName = containers.getText();

            assertThat("Some of the products names, do not contain the search heyword", productName,containsString(keyword.toUpperCase()));
        }


    }
}
