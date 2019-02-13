package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;


public class ProducColorChangeTest {
    @Test
    public void productColorChangeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\resorces\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("Opened homepage.");

        String keyword = "vase";
       // String productName = "Herald Glass Vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);
        System.out.println("Pressed ENTER in search field.");

        String img_link ="https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/small_image/210x/602f0fa2c1f0d1ba5e241f914e856ff9/h/d/hdd002_1.jpg";


        driver.findElement(By.className("option-black")).click();

        Thread.sleep(1000);

        String src = driver.findElement(By.xpath("//li[@class='item last']//img[@class='product-collection-image-437']")).getAttribute("src");

        //System.out.println(src);

        assertThat("Is not the same image",src.equals(img_link));

    }
}
