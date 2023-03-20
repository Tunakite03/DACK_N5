package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class TC01 {

    public static void test() throws InterruptedException {
        WebDriver driver = driverFactory.getChromeDriver();

        //
        driver.get("https://davies.vn/");
        //
        WebElement daviesOriginalDropdown = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm'][normalize-space()='DAVIES ORIGINAL']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(daviesOriginalDropdown).build().perform();
        WebElement aoThunNamOption = driver.findElement(By.xpath("//div[normalize-space()='Áo thun nam']"));
        aoThunNamOption.click();
        //
        WebElement sortByDropdown = driver.findElement(By.xpath("//select[@id='sort-tag']"));
        sortByDropdown.click();
        WebElement sortByNameOption = driver.findElement(By.xpath("//option[@value='name:asc']"));
        sortByNameOption.click();
        // Verify all products are sorted by name A-Z
        Thread.sleep(2000);
        WebElement firstProductName = driver.findElement(By.xpath("//h3[@class='ega-product-col-name']"));
        String firstProductNameText = firstProductName.getText();
        WebElement lastProductName = driver.findElement(By.xpath("//div[@class='ega-col-product-item']/div/div/div/div/a"));
        String lastProductNameText = lastProductName.getText();
        if (firstProductNameText.compareTo(lastProductNameText) <= 0) {
            System.out.println("Products sorted by name A-Z");
        } else {
            System.out.println("Products not sorted by name");
        }
        driver.quit();
    }
}