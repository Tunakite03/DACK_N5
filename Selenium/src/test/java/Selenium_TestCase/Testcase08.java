package Selenium_TestCase;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

    public class Testcase08 {
        @Test
        public static void Test08() {
            StringBuffer verificationErrors = new StringBuffer();
            WebDriver driver = driverFactory.getChromeDriver();
            try {
                // 1. Go to https://davies.vn/
                driver.get("https://davies.vn/");


                //2. Click on 'Login' link
                driver.findElement(By.xpath("//a[@title='Đăng ký/Đăng nhập']")).click();
                Thread.sleep(2000);


                // 3. Login in application using previously created credential
                driver.findElement(By.id("customer_email")).clear();
                driver.findElement(By.id("customer_email")).sendKeys("doanthu544@gmail.com");
                driver.findElement(By.id("customer_password")).clear();
                driver.findElement(By.id("customer_password")).sendKeys("123456");
                driver.findElement(By.xpath("//input[@value='Đăng nhập']")).click();
                Thread.sleep(2000);

                // 4. Click on a product , Add to cart
                driver.findElement(By.xpath("//a[@title='Tất cả sản phẩm']")).click();
                driver.findElement(By.xpath("//img[@alt='áo khoác local brand đẹp Davies']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//button[@title='Cho vào giỏ hàng']")).click();
                Thread.sleep(3500);
                driver.findElement(By.cssSelector("a[class='ega-a-cart-icon-top']")).click();
                Thread.sleep(1000);

                //Change Quantity and click Update
                String result_old = driver.findElement(By.xpath("//b[@class='product-price']")).getText();
                int price_old = Integer.parseInt(result_old.replace(".", "").replace("₫",""));

                driver.findElement(By.xpath("//input[@class='form-control text-center']")).clear();
                driver.findElement(By.xpath("//input[@class='form-control text-center']")).sendKeys("100");
                Thread.sleep(1000);

                driver.findElement(By.cssSelector("input[class='btn btn-gray pull-xs-right ega-btn-round']")).click();
                Thread.sleep(1000);

                String result_new = driver.findElement(By.xpath("//b[@class='product-price']")).getText();
                int price_new = Integer.parseInt(result_new.replace(".", "").replace("₫",""));
                System.out.println(price_old);
                System.out.println(price_new);


                // 5. Verify Grand Total is changed
                if(price_old == (price_new / 100)) {
                    System.out.println("This Total is changed success");
                }else System.out.println("This Total change FAIL");


                // 6. Display show erorr because of an insufficient number of responses
                Thread.sleep(1000);
                driver.findElement(By.xpath("//button[@title='Tiến hành thanh toán']")).click();
                Thread.sleep(1000);
                String error = driver.findElement(By.xpath("//p[@class='section__text']")).getText();
                System.out.println(error);
                Thread.sleep(1000);

                // 7. After agreeing to the maximum number of product, click Continue
                driver.findElement(By.xpath("//button[@class='btn btn-checkout spinner']")).click();
                Thread.sleep(2000);

                // 8. Complete Billing & Shipping Information
                driver.findElement(By.id("customer-address")).click();
                driver.findElement(By.id("paymentMethod-293802")).click();
                Thread.sleep(1000);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            driver.quit();
        }
}
