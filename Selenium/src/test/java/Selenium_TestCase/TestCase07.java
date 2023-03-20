package Selenium_TestCase;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.testng.annotations.Test;

import java.io.File;


public class TestCase07 {
    @Test
    public static void TestTC07() {
        // Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        int scc=0;

        try {
            //  Open web : "http://live.techpanda.org/index.php/"
            driver.get("http://davies.vn/");


            //  Click My Account link
            driver.findElement(By.xpath("//a[@title='Đăng ký/Đăng nhập']")).click();


            // Login using previously created credentials
            String Email = "testuser_98bd6287-2c87-479c-ada9-58c10444e459@gmail.com";
            String phone ="84994949499";
            driver.findElement(By.id("customer_email")).sendKeys(Email);
            driver.findElement(By.id("customer_password")).sendKeys("12345678");
            driver.findElement(By.xpath("//input[@value='Đăng nhập']")).click();


//            Step 6: Verify all products are sorted by name
                    scc= (scc+1);

            File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String img= ("H:\\"+"checkImage"+scc+".png");
            FileUtils.copyFile(srcFile, new File(img));


        } catch (Exception e) {
            e.printStackTrace();
        }
//         Close the browser
        driver.quit();
    }
}
