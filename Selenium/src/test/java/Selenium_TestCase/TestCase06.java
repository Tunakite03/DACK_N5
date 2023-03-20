package Selenium_TestCase;
//--------------TESTCASE06-------------------------
/* Verify user is able to purchase product using registered email id(USE CHROME BROWSER)
Test Steps:
1. Go to http://davies.vn/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate
8. Verify Shipping cost generated
9. Select Shipping Cost, Update Total
10. Verify shipping cost is added to total
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed.
Rest of the steps renumbered accordingly.*/


import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.util.UUID;

public class TestCase06 {
    @Test
    public static  void TestTC06(){
        // Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();


        try {
            //  Open web : "http://live.techpanda.org/index.php/"
            driver.get("https://davies.vn/");

//            Create Account
            //  Click My Account link
            driver.findElement(By.xpath("//a[@title='Đăng ký/Đăng nhập']")).click();

            driver.findElement(By.xpath("//DIV[@class='pull-xs-left']//A[@href='/account/register'][text()='Đăng ký']")).click();

            Thread.sleep(2000);
            // Fill the form with new user information
            String email = "testuser_" + UUID.randomUUID().toString() + "@gmail.com";
            driver.findElement(By.id("lastName")).sendKeys("Tuni");
            driver.findElement(By.id("firstName")).sendKeys("vvvv");
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys("12345678");
            driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
            System.out.println("Email: " + email );


//    CLick to All products
            driver.findElement(By.xpath("//a[contains(text(),'Tất cả sản phẩm')]")).click();
            Thread.sleep(2000);

            //Go to DSW Hooded Basic Jacket - Xám
            driver.findElement(By.xpath("(//a[@title='DSW Hooded Basic Jacket - Xám'])[2]")).click();
            Thread.sleep(2000);


            //  Click ADD To Cart
            driver.findElement(By.xpath("//button[@title='Cho vào giỏ hàng']")).click();

            //  Click ADD To Cart
            Thread.sleep(4000);
//     Click cart
            driver.findElement(By.xpath("//a[@class='ega-a-cart-icon-top']")).click();

//            CLick Estimate
            driver.findElement(By.xpath("//button[@title='Tiến hành thanh toán']")).click();



//            //  12a. Enter Billing Information, and click Continue
            WebElement input = driver.findElement(By.id("billingPhone"));
            input.clear();
            input.sendKeys("84994949499");
//
            WebElement input2 =  driver.findElement(By.id("billingAddress"));
            input2.clear();
            input2.sendKeys("Tuna");


//            Nhập Thành phố
            driver.findElement(By.xpath("(//SPAN[@class='select2-selection select2-selection--single'])[1]//SPAN[@class='select2-selection__arrow']")).click();
            WebElement input3=   driver.findElement(By.xpath("//input[@role='searchbox']"));
            input3.sendKeys("Tp Hồ Chí Minh");
            input3.sendKeys(Keys.RETURN);

//            Nhập quận
            driver.findElement(By.xpath("(//SPAN[@class='select2-selection select2-selection--single'])[2]//SPAN[@class='select2-selection__arrow']")).click();
            WebElement input4=   driver.findElement(By.xpath("//SPAN[@class='select2-search select2-search--dropdown']//INPUT[@class='select2-search__field']"));
            input4.sendKeys("Quận 1");
            input4.sendKeys(Keys.RETURN);

//            Nhập xã, Phường
            driver.findElement(By.xpath("(//SPAN[@class='select2-selection select2-selection--single'])[3]//SPAN[@class='select2-selection__arrow']")).click();
            WebElement input5=   driver.findElement(By.xpath("//SPAN[@class='select2-search select2-search--dropdown']//INPUT[@class='select2-search__field']"));
            input5.sendKeys("Phường Tân Định");
            input5.sendKeys(Keys.RETURN);


            //12b. Enter Shipping Information, and click Continue
            driver.findElement(By.id("paymentMethod-293802")).click();
//
            Thread.sleep(3000);
//
          // In Shipping Method, Click Continue
            driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
            Thread.sleep(3000);


            String Order= driver.findElement(By.xpath("//DIV[@class='order-summary__header']//DIV[@class='order-summary__title']")).getText();

            System.out.println("Your Order: " + Order);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
