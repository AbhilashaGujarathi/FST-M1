
package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void verifyHomepage() {
        WebElement username = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();
        WebElement welcome = driver.findElement(By.xpath("//a[@id = 'welcome']"));
        Assert.assertEquals(welcome.getText(), "Welcome Abhi");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}











