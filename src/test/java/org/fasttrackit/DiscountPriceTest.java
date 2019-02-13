package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsNot.not;

public class DiscountPriceTest {
    @Test
    public void discountPriceTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\resorces\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");

        String keyword = "vase";
        // String productName = "Herald Glass Vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);
        System.out.println("Pressed ENTER in search field.");

        String oldPrice = driver.findElement(By.xpath("//li[@class='item last']//p[@class='old-price']")).getText();

        String specialPrice = driver.findElement((By.xpath("//li[@class='item last']//p[@class='special-price']"))).getText();

        String[] newOldPrice=oldPrice.split(" ");
        String intPart=newOldPrice[0];
        String stringPart = newOldPrice[1];
        intPart = intPart.replace(",",".");
        double valueOldPrice = Double.parseDouble(intPart);

        String[] newSpecialPrice=specialPrice.split(" ");
        String intPartSpecialPrice=newSpecialPrice[0];
        String stringPartSpecialPrice = newSpecialPrice[1];
        intPartSpecialPrice = intPartSpecialPrice.replace(",",".");
        double valueSpecialPrice = Double.parseDouble(intPartSpecialPrice);

        System.out.println(valueOldPrice);
        System.out.println(valueSpecialPrice);
        //assertThat("produsul nu e la reducere",specialPrice,not(is(oldPrice)));
        assertThat("produsul nu e la reducere",valueSpecialPrice, lessThan(valueOldPrice));
    }
}
