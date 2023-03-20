package Selenium_TestCase;
    /*
1. Go to http://live.techpanda.org/
2. Add any product to cart
3. Click 'Cart' link and Proceed to payment
4. Enter Coupon Code
5. Verify error coupon code
*/

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Testcase09 {
    @Test
          public static void Test09() {
            StringBuffer verificationErrors = new StringBuffer();
            WebDriver driver = driverFactory.getChromeDriver();
            try {
                // 1. Go to https://davies.vn/
                driver.get("https://davies.vn/");


                //2. Add any product to cart
                driver.findElement(By.xpath("//a[@title='DSW Drawstring Backpack']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//button[@title='Cho vào giỏ hàng']")).click();
                Thread.sleep(3500);


                // 3. Click 'Cart' link
                driver.findElement(By.xpath("//a[@title='cart']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//button[@title='Tiến hành thanh toán']")).click();
                Thread.sleep(1000);


                // 4. Enter Coupon Code
                driver.findElement(By.id("reductionCode")).sendKeys("DAVIES");
                driver.findElement(By.xpath("//button[@class='field__input-btn btn spinner']")).click();
                Thread.sleep(1000);


                // 5. Verify error coupon code
                String error = driver.findElement(By.xpath("//p[@class='field__message field__message--error']")).getText();
                System.out.println(error);

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

