package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {

    @Test
    public void addToCartFromSearchResultsTest(){
        System.setProperty("webdriver.chrome.driver", "src\\resorces\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        String keyword = "vase";
        String productName = "Herald Glass Vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='product-info' and .//a[text()= '"+productName+"']]//button[@title='Add to Cart']")).click();

        String msg = driver.findElement(By.className("success-msg")).getText();

        assertThat("Success message is not displayed",msg, is(productName+" was added to your shopping cart."));

        WebElement productNameAddedToCart = driver.findElement(By.xpath("//tr[@class='first last odd'] //h2[@class = 'product-name'] // a [text()='"+productName+"']"));

        assertThat("Product is not on cart page",productNameAddedToCart.isDisplayed());

    }
}
