package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TC05 {
    public static void main() {
        //email and password
        String email = "example1231@abc.xyz";
        String password = "password123";
        // Step 1:
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://davies.vn/");

        // Step 2:
        WebElement Account = driver.findElement(By.xpath("//a[@title='Đăng ký/Đăng nhập']"));
        Account.click();
        // Step 3:
        WebElement createAccountLink = driver.findElement(By.xpath("//a[@class='btn']"));
        createAccountLink.click();

        WebElement firstNameInput = driver.findElement(By.name("lastName"));
        firstNameInput.sendKeys("Nguyen");

        WebElement lastNameInput = driver.findElement(By.name("firstName"));
        lastNameInput.sendKeys("Khang");

        WebElement email1Input = driver.findElement(By.name("email"));
        email1Input.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        // Step 4:
        WebElement registerButton = driver.findElement(By.xpath("//button[@value='Đăng ký']"));
        registerButton.click();

        driver.quit();
    }
}

