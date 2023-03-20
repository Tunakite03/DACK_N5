package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class bai3{
    @Test
    public static  void Test3(){
        // Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();


        try {
            //  Open web : "http://live.techpanda.org/index.php/"

            driver.get("https://davies.vn/");
            //
            WebElement daviesOriginalDropdown = driver.findElement(By.xpath("//a[@title='Tất cả sản phẩm']"));
            daviesOriginalDropdown.click();

            Thread.sleep(2000);

            // Click on "ADD TO CART"
            WebElement DSWDRAWSTRINGBACKPACK  = driver.findElement(By.xpath("//h3[normalize-space()='DSW Drawstring Backpack']"));
            DSWDRAWSTRINGBACKPACK.click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@title='Cho vào giỏ hàng']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[@class='ega-a-cart-icon-top']//span[@class='glyphicon glyphicon-shopping-cart']")).click();

            // Change "QTY" value to 1000 and click "UPDATE" button
            WebElement QTY = driver.findElement(By.xpath("//tbody//input[@id='updates_81104216']"));
            QTY.clear();
            QTY.sendKeys("1000");
            driver.findElement(By.xpath("//input[@class='btn btn-gray pull-xs-right ega-btn-round']")).click();

            Thread.sleep(2000);

            // Click on "EMPTY CART" link in the footer of list of all mobiles

            driver.findElement(By.xpath("//td[@class='text-right']//a[@class='ega-a-cart-remove'][normalize-space()='Xóa']")).click();

            Thread.sleep(2000);

            // Verify cart is empty
            String  MessageEmpty = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]")).getText();
            System.out.println(" A message: " + MessageEmpty);

            String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";

            if (MessageEmpty.equals(expectedEmptyCartMessage)) {
                System.out.println("Cart is empty as expected: " + expectedEmptyCartMessage);
            } else {
                System.out.println("Cart is not empty: " + MessageEmpty);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
       driver.quit();

    }

}