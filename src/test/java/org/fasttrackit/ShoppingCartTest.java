package org.fasttrackit;

import org.fasttrackit.pageobjects.Checkout;
import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest extends TestBase{

    @Test
    public void addToCartFromSearchResultsTest(){

        String keyword = "vase";
        String productName = "Herald Glass Vase";
        Header header = PageFactory.initElements(driver, Header.class);
        header.search(keyword);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        productsGrid.getAddToCartButton(productName,driver).click();

        Checkout checkout = PageFactory.initElements(driver,Checkout.class);

        String msg = driver.findElement(By.className("success-msg")).getText();

        assertThat("Success message is not displayed",msg, is(productName+" was added to your shopping cart."));

        assertThat("Product is not on cart page",checkout.productNameAddedToCart(productName,driver).isDisplayed());

    }
}
