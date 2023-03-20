package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class bai2 {
    public static void test() {

        WebDriver driver = driverFactory.getChromeDriver();

        try {
            //

            driver.get("https://davies.vn/");
            //
            WebElement daviesOriginalDropdown = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm'][normalize-space()='DAVIES ORIGINAL']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(daviesOriginalDropdown).build().perform(); // hover over the dropdown
            WebElement aoThunNamOption = driver.findElement(By.xpath("//div[normalize-space()='Áo thun nam']"));
            aoThunNamOption.click();

            //
            WebElement sonyXperiaPrice = driver.findElement(By.xpath("//h3[normalize-space()='Áo thun DSW Tee Waffle Knit']"));
            String HoodedBasicJacket = sonyXperiaPrice.getText();
            System.out.println("Hooded Basic Jacket price: " + HoodedBasicJacket);

            //
            WebElement HoodedBasicJacketlink = driver.findElement(By.xpath("//h3[normalize-space()='Áo thun DSW Tee Waffle Knit']"));
            HoodedBasicJacketlink.click();

            //
            WebElement sonyXperiaTitle = driver.findElement(By.xpath("//h1[@class='ega-product-title']"));
            String sonyXperiaTitleText = sonyXperiaTitle.getText();
            System.out.println("Ao thun nam title: " + sonyXperiaTitleText);

            //
            WebElement sonyXperiaPriceDetail = driver.findElement(By.xpath("//strong[@class='ega-pr-page-price']"));
            String sonyXperiaPriceDetailText = sonyXperiaPriceDetail.getText();
            System.out.println("Ao thun nam detail page price: " + sonyXperiaPriceDetailText);

        } catch (Exception e){
        e.printStackTrace();
        }
        driver.quit();
    }
}